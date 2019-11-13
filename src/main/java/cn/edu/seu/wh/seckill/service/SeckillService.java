package cn.edu.seu.wh.seckill.service;

import cn.edu.seu.wh.seckill.dto.Exposer;
import cn.edu.seu.wh.seckill.dto.SeckillExcution;
import cn.edu.seu.wh.seckill.entity.Seckill;
import cn.edu.seu.wh.seckill.exception.RepeatKillException;
import cn.edu.seu.wh.seckill.exception.SeckillCloseException;
import cn.edu.seu.wh.seckill.exception.SeckillException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program:seckill
 * @description:秒杀系统service
 * 应该站在"使用者"的角度设计，比如：
 *  * 1.定义方法的颗粒度要细
 *  * 2.方法的参数要明确且简练，不建议用类似Map这种让使用者封装一堆参数传递过来
 *  * 3.方法的return类型，除了要明确返回值类型，还应该指定该方法可能抛出的异常
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 13:10
 **/
public interface SeckillService {

    /**
    * @Description: 获取所有的秒杀商品列表
    * @Param: []
    * @return: java.util.List<cn.edu.seu.wh.seckill.entity.Seckill>
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    List<Seckill> findAll();

    /**
    * @Description: 获取某一条商品秒杀信息
    * @Param: [seckillId：商品id]
    * @return: cn.edu.seu.wh.seckill.entity.Seckill
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    Seckill findById(long seckillId);


    /**
    * @Description: 秒杀开始时输出暴露秒杀的地址
     *      * 否则输出系统时间和秒杀时间
    * @Param: [seckillId]
    * @return: cn.edu.seu.wh.seckill.dto.Exposer
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    Exposer exportSeckillURL(long seckillId);


    SeckillExcution excuteSeckill(long seckillId, BigDecimal money, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException;



}
