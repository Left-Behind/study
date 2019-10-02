package com.azhu.springbootmail;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "test")
public class MyConfiguration {


    private String name;


    private Map map = new HashMap();


    public Map getMap() {

        return map;

    }


    public String getName() {

        return name;

    }


    public void setName(String name) {

        this.name = name;

    }

}

