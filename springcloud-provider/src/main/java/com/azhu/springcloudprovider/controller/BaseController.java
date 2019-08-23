package com.azhu.springcloudprovider.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Azhu
 * @date 2019/8/22 18:01
 */
@RestController
public class BaseController {

    @RequestMapping("/provider")
    public String get()
    {
        return "爷是提供者------------------------>";
    }


}
