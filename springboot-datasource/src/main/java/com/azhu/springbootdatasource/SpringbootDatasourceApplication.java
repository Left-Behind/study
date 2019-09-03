package com.azhu.springbootdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//排除自动注入数据源的配置（取消数据库配置）
@MapperScan("com.azhu.springbootdatasource.mapper")//这个和mapper层的@Data注解作用一样,可以都加,
public class SpringbootDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatasourceApplication.class, args);
    }

}
