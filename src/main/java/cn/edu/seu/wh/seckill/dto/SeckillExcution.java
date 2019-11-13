package cn.edu.seu.wh.seckill.dto;

import cn.edu.seu.wh.seckill.entity.SeckillOrder;
import cn.edu.seu.wh.seckill.enums.SeckillStateEnum;

/**
 * @program:seckill
 * @description:封装执行秒杀结果
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:26
 **/
public class SeckillExcution {

    private long seckillId;

    //执行秒杀结果状态
    private int state;

    //状态结果表示
    private String stateInfo;

    //秒杀成功的订单对象
    private SeckillOrder seckillOrder;

    public SeckillExcution(Long seckillId, SeckillStateEnum seckillStatEnum, SeckillOrder seckillOrder) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
        this.seckillOrder = seckillOrder;
    }

    public SeckillExcution(Long seckillId, SeckillStateEnum seckillStatEnum) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SeckillOrder getSeckillOrder() {
        return seckillOrder;
    }

    public void setSeckillOrder(SeckillOrder seckillOrder) {
        this.seckillOrder = seckillOrder;
    }

    @Override
    public String toString() {
        return "SeckillExcution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", seckillOrder=" + seckillOrder +
                '}';
    }
}
