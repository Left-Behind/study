package com.azhu.springbootdatasourceaop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = "com.azhu.springbootdatasourceaop.mapper")
public class SpringbootDatasourceAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatasourceAopApplication.class, args);
    }

}
