package com.gosaint.dao;

import java.util.Date;
import java.util.List;

import com.gosaint.domain.Seckill;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 12:45 2018/11/11
 * @Modified By:
 */
public interface SeckillMapper {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 减库存以影响的行数
     */
    int reduceNumber(long seckillId,Date killTime);

    /**
     * 查询秒杀库存
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀库存列表
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offet,int limit);
}
