package com.gosaint.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gosaint
 * @Description:
 * @Date Created in 12:41 2018/11/11
 * @Modified By:
 */
public class SuccessKilled implements Serializable {

    private long seckill_id;
    private long user_phone;
    private short status;
    private Date create_time;
    /**
     * 多个秒杀成功实体对应一个秒杀实体
     */
    private Seckill seckill;

    public long getSeckill_id() {
        return seckill_id;
    }

    public void setSeckill_id(final long seckill_id) {
        this.seckill_id = seckill_id;
    }

    public long getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(final long user_phone) {
        this.user_phone = user_phone;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(final short status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(final Date create_time) {
        this.create_time = create_time;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(final Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckill_id=" + seckill_id +
                ", user_phone=" + user_phone +
                ", status=" + status +
                ", create_time=" + create_time +
                '}';
    }
}
