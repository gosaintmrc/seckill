package com.gosaint.service.impl;

import java.util.Date;
import java.util.List;

import com.gosaint.dao.SeckillMapper;
import com.gosaint.dao.SuccessKilledMapper;
import com.gosaint.domain.Seckill;
import com.gosaint.domain.SuccessKilled;
import com.gosaint.dto.Exposer;
import com.gosaint.dto.SeckillExecution;
import com.gosaint.enums.SeckillStatEnum;
import com.gosaint.exeception.RepeatExeception;
import com.gosaint.exeception.SeckillCloseExeception;
import com.gosaint.exeception.SeckillExeception;
import com.gosaint.service.SeckillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * @author gosaint
 * @Description:
 * @Date Created in 22:51 2018/12/18
 * @Modified By:
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String salt = "&*UJYHFG==KIJGFD!WDFGJMMJUGF";
    @Autowired
    private SeckillMapper seckillMapper;
    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Override
    public List<Seckill> getSeckillList() {
        return seckillMapper.queryAll(0, 4);
    }

    @Override
    public Seckill getBySeckillId(final long seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    /**
     * 展示秒杀接口地址
     *
     * @param seckillId
     * @return
     */
    @Override
    public Exposer exportSeckillUrl(final long seckillId) {
        Seckill seckill = seckillMapper.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date start_time = seckill.getStart_time();
        Date end_time = seckill.getEnd_time();
        Date nowDate = new Date();
        if (nowDate.getTime() < start_time.getTime() || nowDate.getTime() > end_time.getTime()) {
            //系统时间小于秒杀开始时间 或者系统时间大于秒杀结束时间
            return new Exposer(false, seckillId, nowDate.getTime(), start_time.getTime(), end_time.getTime());
        }
        //不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Transactional
    @Override
    public SeckillExecution executeSeckill(
            final long seckillId, final long userPhone,
            final String md5)
            throws SeckillExeception, RepeatExeception, SeckillCloseExeception {
        if (md5 == null || md5.equals(getMD5(seckillId))) {
            throw new SeckillExeception("秒杀数据重写");
        }
        //减库存 记录秒杀行为
        Date seckill_Time = new Date();
        try {
            int updateCount = seckillMapper.reduceNumber(seckillId, seckill_Time);
            if (updateCount <= 0) {
                throw new SeckillCloseExeception("秒杀结束");
            } else {
                //记录购买行为
                int successInsertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
                if (successInsertCount <= 0) {
                    throw new RepeatExeception("重复秒杀");
                } else {
                    SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseExeception sce) {
            throw sce;
        } catch (RepeatExeception re) {
            throw re;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new SeckillExeception("seckill inner error");
        }

    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + salt;
        //Spring MD5的操作
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
