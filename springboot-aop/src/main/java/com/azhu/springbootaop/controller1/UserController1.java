package com.azhu.springbootaop.controller1;

import com.azhu.springbootaop.aspect.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 */
@RestController
public class UserController1 {

    @RequestMapping("/test")
    public Object first() {
        return "Azhuaaaaaaaaaaaaaaaaaaaaa";
    }

}
