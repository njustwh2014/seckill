package cn.edu.seu.wh.seckill.exception;

/**
 * @program:seckill
 * @description:秒杀系统运行时异常
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:54
 **/
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
