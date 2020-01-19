package work.azhu.redisdistributedlock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @Author Azhu
 * @Date 2020/1/19 17:47
 * @Description
 */
@Api("Redisson分布式锁")
@Slf4j
@Controller
@RequestMapping("/redisson")
public class RedissonLockController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    private static final String PRODUCT_KEY = "redisProductKey";

    private static final String LOCK_KEY = "redissonLock";

    private final RedissonClient redissonClient;

    public RedissonLockController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    @ApiOperation("模拟购买,减库存")
    @RequestMapping(value = "/lock",method = RequestMethod.POST)
    public void lock() {
        RLock lock = redissonClient.getLock(LOCK_KEY);
        // 设置5秒过期时间
        lock.lock(5, TimeUnit.SECONDS);
        String lockValue = lock.toString();
        log.info("[{}]成功获取锁，开始执行业务。。。", lockValue);

        RAtomicLong atomicLong = redissonClient.getAtomicLong(PRODUCT_KEY);
        long surplus = atomicLong.get();
        if (surplus <= 0) {
            lock.unlock();
            log.info("[{}]库存不足，释放锁 ##########################################", lockValue);
            return;
        }
        log.info("[{}]当前库存[{}]，库存 -1，剩余库存[{}]", lockValue, surplus, atomicLong.decrementAndGet());

        log.info("[{}]操作完成，释放锁", lockValue);
        lock.unlock();
    }

    @ApiOperation("恢复初始库存,100件")
    @RequestMapping(value = "/returnStockTest",method = RequestMethod.POST)
    @ResponseBody()
    public String returnStockTest(){
        stringRedisTemplate.opsForValue().set(PRODUCT_KEY,"100");
        return "恢复库存成功";
    }
}
