package cn.edu.seu.wh.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program:seckill
 * @description:用于页面跳转
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 14:52
 **/
@Controller
public class BaseController {


    /**
     * 跳转到秒杀商品页
     *
     * @return
     */
    @RequestMapping("/seckill")
    public String seckillGoods() {
        return "redirect:/seckill/list";
    }
}
