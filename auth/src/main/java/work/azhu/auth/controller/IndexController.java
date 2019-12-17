package work.azhu.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Azhu
 * @Description: 
 * @Date 2019/12/17 22:34
 **/
@Controller
public class IndexController {

    @RequestMapping(value = {"index","/"})
    public String index() {
        return "index";
    }
}
