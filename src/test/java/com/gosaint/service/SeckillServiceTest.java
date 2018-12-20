package com.gosaint.service;

import java.util.List;

import com.gosaint.domain.Seckill;
import com.gosaint.dto.Exposer;
import com.gosaint.dto.SeckillExecution;
import com.gosaint.exeception.RepeatExeception;
import com.gosaint.exeception.SeckillCloseExeception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 20:47 2018/12/19
 * @Modified By:
 */
public class SeckillServiceTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list={}", seckillList);
    }

    @Test
    public void getBySeckillId() {
        Seckill seckill = seckillService.getBySeckillId(1000);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 15140366083L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", execution);
            } catch (RepeatExeception re) {
                logger.error(re.getMessage());
            } catch (SeckillCloseExeception sce) {
                logger.error(sce.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
    }
}