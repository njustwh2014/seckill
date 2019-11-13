package cn.edu.seu.wh.seckill.exception;

/**
 * @program:seckill
 * @description:重复秒杀异常
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:51
 **/
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
