package com.azhu.springbootsessionredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableCaching
@EnableRedisHttpSession  //开启springboot-session-redis 把session存放到指定的redis里
//这里好像不用配置注解和yml配置文件里不需要 session:
//    store-type: redis # spring session使
//    只要pom.xml里添加这两个依赖就行，
/**
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-data-redis</artifactId>
 *         </dependency>
 *         <!-- https://mvnrepository.com/artifact/org.springframework.session/spring-session-data-redis -->
 *         <dependency>
 *             <groupId>org.springframework.session</groupId>
 *             <artifactId>spring-session-data-redis</artifactId>
 *             <version>2.1.3.RELEASE</version>
 *         </dependency>
 */
@SpringBootApplication
public class SpringbootSessionRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSessionRedisApplication.class, args);
    }

}
