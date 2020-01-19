package work.azhu.redisdistributedlock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author Azhu
 * @Date 2020/1/19 14:06
 * @Description
 */
@Api("Redis分布式锁测试")
@Slf4j
@RequestMapping("/redis")
@Controller
public class RedisLockController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String PRODUCT_KEY = "productKey";

    private static final String LOCK_KEY = "redisLock";

    @ApiOperation("模拟购买,减库存")
    @RequestMapping(value = "/lock",method = RequestMethod.POST)
    public void lockTest() throws InterruptedException {
        // 用户唯一标识
        String lockValue = UUID.randomUUID().toString().replace("-", "");
        Random random = new Random();
        int sleepTime;
        while (true) {
            if (tryLock(LOCK_KEY, lockValue)) {
                log.info("[{}]成功获取锁", lockValue);
                break;
            }
            sleepTime = random.nextInt(1000);
            Thread.sleep(sleepTime);
            log.info("[{}]获取锁失败，{}毫秒后重新尝试获取锁", lockValue, sleepTime);
        }
        // 剩余库存
        String products = stringRedisTemplate.opsForValue().get(PRODUCT_KEY);
        if (products == null) {
            log.info("[{}]获取剩余库存失败，释放锁：{} @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", lockValue, unLock(LOCK_KEY, lockValue));
            return;
        }
        int surplus = Integer.parseInt(products);
        if (surplus <= 0) {
            log.info("[{}]库存不足，释放锁：{} ##########################################", lockValue, unLock(LOCK_KEY, lockValue));
            return;
        }

        log.info("[{}]当前库存[{}]，操作：库存-1", lockValue, surplus);
        stringRedisTemplate.opsForValue().decrement(PRODUCT_KEY);
        log.info("[{}]操作完成，开始释放锁，释放结果：{}", lockValue, unLock(LOCK_KEY, lockValue));
    }

    @ApiOperation("恢复初始库存,100件")
    @RequestMapping(value = "/returnStockTest",method = RequestMethod.POST)
    @ResponseBody()
    public String returnStockTest(){
        stringRedisTemplate.opsForValue().set(PRODUCT_KEY,"100");
        return "恢复库存成功";
    }


    /**
     * 加锁
     *
     * @param key   | 指定锁
     * @param value | 用户唯一标识，用于释放锁是校验是否是加锁客户端
     */
    public boolean tryLock(String key, String value) {
        /*
         * 如果这个key存在则返回 false，
         * 不存在的，设置这个key，设置过期时间，返回true
         * 调用 set k v ex 5 nx 命令 (ex表示单位为秒，px表示单位是毫秒)
         */
        Boolean isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, value, 5, TimeUnit.SECONDS);
        if (isLocked == null) {
            return false;
        }
        return isLocked;
    }

    /**
     * 解锁
     */
    public Boolean unLock(String key, String value) {
        // 执行 lua 脚本
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        // 指定 lua 脚本
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/unLock.lua")));
        // 指定返回类型
        redisScript.setResultType(Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(key), value);
        return result != null && result > 0;
    }

    public Boolean unLockWithoutLua(String key, String value) throws InterruptedException {

        if(stringRedisTemplate.opsForValue().get(key).equals(value)){
            Thread.sleep(20);
            return stringRedisTemplate.delete(key);
        }
        return false;
    }




}
