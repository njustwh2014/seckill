package cn.edu.seu.wh.seckill.mapper;

import cn.edu.seu.wh.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @program:seckill
 * @description:秒杀系统数据库Mapper
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 09:43
 **/

@Mapper
@Component
public interface SeckillMapper {

    /**
    * @Description: 查询所有秒杀商品信息
    * @Param: []
    * @return: java.util.List<cn.edu.seu.wh.seckill.entity.Seckill>
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    List<Seckill> findAll();

    /**
    * @Description: 根据主键查询商品信息
    * @Param: [id] id: 商品主键
    * @return: cn.edu.seu.wh.seckill.entity.Seckill
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    Seckill findById(long id);

    /**
    * @Description: 减库存
    * @Param: [seckillId：商品主键id, killTime：秒杀时间]
    * @return: int：该操作影响行数
    * @thorws:
    * @Author: Mr.Wang
    * @Date: 2019/11/13
    */
    int reduceStock(@Param("seckillId") long seckillId, @Param("killTime")Date killTime);
}
