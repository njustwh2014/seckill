package cn.edu.seu.wh.seckill.mapper;

import cn.edu.seu.wh.seckill.entity.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program:seckill
 * @description:秒杀清单Mapper
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 09:55
 **/
@Mapper
@Component
public interface SeckillOrderMapper {

    /**
    * @Description: 插入订单信息
    * @Param: [seckillId：秒杀到的商品id, money：订单金额, userPhone：用户手机号码]
    * @return: int：该操作影响行数
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    int insertOrder(@Param("seckillId") long seckillId, @Param("money")BigDecimal money,@Param("userPhone") long userPhone);

    /**
    * @Description: 根据商品id和用户手机号码查询订单信息
    * @Param: [seckillId：商品id, userPhone：用户手机号码]
    * @return: cn.edu.seu.wh.seckill.entity.SeckillOrder
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    SeckillOrder findById(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
