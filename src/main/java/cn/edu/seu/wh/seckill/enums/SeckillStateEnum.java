package cn.edu.seu.wh.seckill.enums;

/**
 * @program:seckill
 * @description:用来封装返回的结果信息的
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:30
 **/
public enum SeckillStateEnum {
    SUCCESS(1,"秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据串改");

    private int state;
    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStateEnum stateOf(int index){
        for(SeckillStateEnum state:values()){
            if(state.getState()==index){
                return  state;
            }
        }
        return null;
    }
}
