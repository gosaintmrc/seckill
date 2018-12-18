package com.gosaint.exeception;

/**
 * @author gosaint
 * @Description:
 * @Date Created in 22:45 2018/12/18
 * @Modified By:重复秒杀异常（运行期异常）
 */
public class RepeatExeception extends SeckillExeception {

    public RepeatExeception(final String message) {
        super(message);
    }

    public RepeatExeception(final String message, final Throwable cause) {
        super(message, cause);
    }

}
