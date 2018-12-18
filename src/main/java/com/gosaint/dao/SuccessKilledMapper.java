package com.gosaint.dao;

import com.gosaint.domain.SuccessKilled;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 12:50 2018/11/11
 * @Modified By:
 */
public interface SuccessKilledMapper {
    /**
     * 插入秒杀成功记录，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(long seckillId,long userPhone);

    /**
     * 查询秒杀成功记录
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);
}
