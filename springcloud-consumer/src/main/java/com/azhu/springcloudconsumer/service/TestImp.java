package com.azhu.springcloudconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Azhu
 * @date 2019/8/22 18:56
 */
@Service
public class TestImp {
    @Autowired
    private TestInterface testInterface;

    public String getString(){
        return testInterface.getTtest();
    }
}
