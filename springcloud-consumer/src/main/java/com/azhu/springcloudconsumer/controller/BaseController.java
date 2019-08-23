package com.azhu.springcloudconsumer.controller;

import com.azhu.springcloudconsumer.service.TestImp;
import com.azhu.springcloudconsumer.service.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Azhu
 * @date 2019/8/22 17:57
 */

@RestController
public class BaseController {

    @Resource
    private TestImp testImp;

    @RequestMapping("/comsumer")
     public String get()
    {
        return testImp.getString()+"我是消费者";
    }
}
