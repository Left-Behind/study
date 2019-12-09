package work.azhu.springbootsecurity.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello spring security";
    }

    @GetMapping("index")
    @ResponseBody
    public Object index(Authentication authentication) {
        // return SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
}
