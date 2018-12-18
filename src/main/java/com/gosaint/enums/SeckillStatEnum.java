package com.gosaint.enums;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 23:28 2018/12/18
 * @Modified By:枚举数据字典
 */
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNNER_ERROR(-2,"内部异常"),
    DATE_REWRITE(-3,"数据篡改");
    private int state;
    private String stateInfo;

    SeckillStatEnum(final int state, final String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static SeckillStatEnum stateOf(int index){
        for (SeckillStatEnum seckillStatEnum:values()){
            if(seckillStatEnum.getState()==index){
                return seckillStatEnum;
            }
        }
        return null;
    }
}
