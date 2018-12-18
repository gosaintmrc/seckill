package com.gosaint.service;

import java.util.List;

import com.gosaint.domain.Seckill;
import com.gosaint.dto.Exposer;
import com.gosaint.dto.SeckillExecution;
import com.gosaint.exeception.RepeatExeception;
import com.gosaint.exeception.SeckillCloseExeception;
import com.gosaint.exeception.SeckillExeception;

/**
 * @author gosaint
 * @Description:
 * @Date Created in 22:23 2018/12/18
 * @Modified By:业务接口
 */
public interface SeckillService {
    /**
     * 查询所有的秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getBySeckillId(long seckillId);

    /**
     * 秒杀开启时输出秒杀地址，否则输出秒杀时间和系统时间
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillExeception 秒杀相关异常
     * @throws RepeatExeception 重复秒杀异常
     * @throws SeckillCloseExeception 秒杀关闭异常
     */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String md5) throws SeckillExeception,RepeatExeception,SeckillCloseExeception;
}
