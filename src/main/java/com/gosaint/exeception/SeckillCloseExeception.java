package com.gosaint.exeception;

/**
 * @author gosaint
 * @Description:
 * @Date Created in 22:47 2018/12/18
 * @Modified By:秒杀关闭异常
 */
public class SeckillCloseExeception extends SeckillExeception {
    public SeckillCloseExeception(final String message) {
        super(message);
    }

    public SeckillCloseExeception(final String message, final Throwable cause) {
        super(message, cause);
    }
}
