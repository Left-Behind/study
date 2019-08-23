package com.azhu.springcloudconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Azhu
 * @date 2019/8/22 18:39
 */
@FeignClient(value="CLOUD-PROVIDER")
public interface TestInterface {

    @GetMapping("provider")
    public String getTtest();
}
