package com.azhu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: Azhu
 * @date: 19-7-22下午10:17
 * Description:
 */
public class JedisDemo1 {
    @Test
    public void T1() {
        //1.设置ip地址和端口
        Jedis jedis=new Jedis("localhost",6379);
        //2.保存数据
        jedis.set("Azhu","666");
        //3.获取数据
        String value =jedis.get("Azhu");
        System.out.println(value);
        jedis.close();

    }

    /**
     * 通过连接池获取数据
     */
    @Test
    public void T2(){
        //获得连接池的配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(30);
        //设置最大空闲时间连接数
        config.setMinIdle(10);
        //获得连接池
        JedisPool jedisPool=new JedisPool(config,"localhost",6379);
        //获得核心对象
        Jedis jedis=null;
        try{

            //通过连接池获取对象
            jedis=jedisPool.getResource();
            //设置数据
            jedis.set("name","Azhu66");
            String value=jedis.get("name");
            System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null!=jedis){
                jedis.close();
            }
            if(null!=jedisPool){
                jedisPool.close();
            }

        }


    }
}