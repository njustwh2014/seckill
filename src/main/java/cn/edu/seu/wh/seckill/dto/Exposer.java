package cn.edu.seu.wh.seckill.dto;

import java.util.Date;

/**
 * @program:seckill
 * @description:暴露秒杀地址DTO，类似JavaBean但又不属于，仅用来封装秒杀状态的结果，目的是提高代码的重用率
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:14
 **/
public class Exposer {

    //是否开启秒杀
    private boolean exposed;

    //加密措施，避免用户通过抓包拿到秒杀地址
    private String md5;

    //ID
    private long sckillId;

    //系统当前时间(ms)
    private long now;

    //秒杀开启的时间
    private long start;

    //秒杀结束时间
    private long end;

    public Exposer(boolean exposed, String md5, long sckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.sckillId = sckillId;
    }

    public Exposer(boolean exposed, long sckillId) {
        this.exposed = exposed;
        this.sckillId = sckillId;
    }

    public Exposer(boolean exposed, String md5, long sckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.md5 = md5;
        this.sckillId = sckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long sckillId, long now, long start, long end) {
        this.exposed = exposed;
        this.sckillId = sckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSckillId() {
        return sckillId;
    }

    public void setSckillId(long sckillId) {
        this.sckillId = sckillId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", sckillId=" + sckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
