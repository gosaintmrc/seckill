package com.gosaint.dto;

import com.gosaint.domain.SuccessKilled;
import com.gosaint.enums.SeckillStatEnum;

/**
 * @author gosaint
 * @Description:
 * @Date Created in 22:40 2018/12/18
 * @Modified By:秒杀执行后的结果
 */
public class SeckillExecution {

    private long seckilld;
    //秒杀状态
    private int state;
    /**
     * 状态的String标识
     */
    private String stateInfo;
    /**
     * 秒杀成功对象
     */
    private SuccessKilled successKilled;

    public long getSeckilld() {
        return seckilld;
    }

    public void setSeckilld(final long seckilld) {
        this.seckilld = seckilld;
    }

    public int getState() {
        return state;
    }

    public void setState(final int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(final String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(final SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    public SeckillExecution(
            final long seckilld,
             SeckillStatEnum seckillStatEnum,
            final SuccessKilled successKilled) {
        this.seckilld = seckilld;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(final long seckilld, SeckillStatEnum seckillStatEnum) {
        this.seckilld = seckilld;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
    }
}
