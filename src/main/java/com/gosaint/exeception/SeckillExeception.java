package com.gosaint.exeception;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 22:48 2018/12/18
 * @Modified By:秒杀相关异常
 */
public class SeckillExeception extends RuntimeException {

    public SeckillExeception(final String message) {
        super(message);
    }

    public SeckillExeception(final String message, final Throwable cause) {
        super(message, cause);
    }
}
