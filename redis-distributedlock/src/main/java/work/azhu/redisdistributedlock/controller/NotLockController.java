package work.azhu.redisdistributedlock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Azhu
 * @Date 2020/1/17 17:56
 * @Description
 */
@Api(tags = "不加锁测试")
@Controller
public class NotLockController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String PRODUCT_KEY = "notLockStock";


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @ApiOperation("减库存,购买")
    @RequestMapping(value = "/getStock",method = RequestMethod.POST)
    public void getStockTest(){
        Integer num = Integer.valueOf(stringRedisTemplate.opsForValue().get(PRODUCT_KEY));
        if(num>0){
            logger.info("当前库存: "+num);
            stringRedisTemplate.boundValueOps(PRODUCT_KEY).increment(-1);
        }else{
            logger.info("库存不足！");
        }
    }

    @ApiOperation("恢复初始库存,100件")
    @RequestMapping(value = "/addStock",method = RequestMethod.POST)
    @ResponseBody()
    public String addStockTest(){
        stringRedisTemplate.opsForValue().set(PRODUCT_KEY,"100");
        return "恢复库存成功";
    }
}
