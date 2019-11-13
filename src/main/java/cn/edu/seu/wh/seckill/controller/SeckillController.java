package cn.edu.seu.wh.seckill.controller;

import cn.edu.seu.wh.seckill.dto.Exposer;
import cn.edu.seu.wh.seckill.dto.SeckillExcution;
import cn.edu.seu.wh.seckill.dto.SeckillResult;
import cn.edu.seu.wh.seckill.entity.Seckill;
import cn.edu.seu.wh.seckill.enums.SeckillStateEnum;
import cn.edu.seu.wh.seckill.exception.RepeatKillException;
import cn.edu.seu.wh.seckill.exception.SeckillCloseException;
import cn.edu.seu.wh.seckill.exception.SeckillException;
import cn.edu.seu.wh.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program:seckill
 * @description:秒杀系统控制层
 * @author: Huan Wang(https://github.com/njustwh2014)
 * @create:2019-11-13 14:54
 **/
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    SeckillService seckillService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/list")
    public String findSeckillList(Model model) {
        List<Seckill> list = seckillService.findAll();
        model.addAttribute("list", list);
        return "page/seckill";
    }

    @ResponseBody
    @RequestMapping("/findById")
    public Seckill findById(@RequestParam("id") Long id) {
        return seckillService.findById(id);
    }

    @RequestMapping("/{seckillId}/detail")
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "page/seckill";
        }
        Seckill seckill = seckillService.findById(seckillId);
        model.addAttribute("seckill", seckill);
        if (seckill == null) {
            return "page/seckill";
        }
        return "page/seckill_detail";
    }

    @ResponseBody
    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillURL(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExcution> execute(@PathVariable("seckillId") Long seckillId,
                                                  @PathVariable("md5") String md5,
                                                  @RequestParam("money") BigDecimal money,
                                                  @CookieValue(value = "killPhone", required = false) Long userPhone) {
        if (userPhone == null) {
            return new SeckillResult<SeckillExcution>(false, "未注册");
        }
        try {
            SeckillExcution execution = seckillService.excuteSeckill(seckillId, money, userPhone, md5);
            return new SeckillResult<SeckillExcution>(true, execution);
        } catch (RepeatKillException e) {
            SeckillExcution seckillExecution = new SeckillExcution(seckillId, SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExcution>(true, seckillExecution);
        } catch (SeckillCloseException e) {
            SeckillExcution seckillExecution = new SeckillExcution(seckillId, SeckillStateEnum.END);
            return new SeckillResult<SeckillExcution>(true, seckillExecution);
        } catch (SeckillException e) {
            SeckillExcution seckillExecution = new SeckillExcution(seckillId, SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExcution>(true, seckillExecution);
        }
    }

    @ResponseBody
    @GetMapping(value = "/time/now")
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult(true, now.getTime());
    }


}
