package com.azhu.springbootsessionredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableCaching
@EnableRedisHttpSession  //开启springboot-session-redis 把session存放到指定的redis里
@SpringBootApplication
public class SpringbootSessionRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSessionRedisApplication.class, args);
    }

}
