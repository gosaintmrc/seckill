package com.gosaint.dao;

import com.gosaint.domain.Seckill;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 18:35 2018/11/24
 * @Modified By:
 */
public class SeckillMapperTest extends BaseTest {

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void reduceNumber() {
        //int reduceNumber(long seckillId,Date killTime);
        //seckillMapper.reduceNumber(1000L,);
    }

    @Test
    public void queryById() {
        Seckill seckill = seckillMapper.queryById(1000);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
    }
}