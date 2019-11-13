package cn.edu.seu.wh.seckill.exception;

/**
 * @program:seckill
 * @description:秒杀关闭异常
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:56
 **/
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
