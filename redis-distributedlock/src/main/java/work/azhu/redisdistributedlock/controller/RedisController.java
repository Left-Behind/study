package work.azhu.redisdistributedlock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author Azhu
 * @Date 2020/1/17 13:59
 * @Description
 */
@Api(tags = "redis测试")
@Controller
public class RedisController {

    @Autowired
    public RedisTemplate redisTemplate;



    @ApiOperation(value = "redis的set操作")
    @RequestMapping(value = "/redisSet",method = RequestMethod.POST)
    @ResponseBody
    public String testRedis(@RequestParam(name = "key") String key, @RequestParam(name = "value") String value){
        System.out.println(key);
        System.out.println(value);
        redisTemplate.opsForValue().set(key,value);
        return "success";
    }

}
