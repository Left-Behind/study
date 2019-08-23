package com.azhu.springcloudeureka.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Azhu
 * @date 2019/7/18 15:05
 */
@RestController
public class TestController {

    @RequestMapping("hello")
    public String hello(){
        return "demo for docker!   to  Azhu QQQQsssssssdfsdfsdfasdfdQQQ12ssss";
    }
}
