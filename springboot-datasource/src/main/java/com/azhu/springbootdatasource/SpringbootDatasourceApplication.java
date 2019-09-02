package com.azhu.springbootdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.azhu.springbootdatasource.mapper")//这个和mapper层的@Data注解作用一样,可以都加,
public class SpringbootDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatasourceApplication.class, args);
    }

}
