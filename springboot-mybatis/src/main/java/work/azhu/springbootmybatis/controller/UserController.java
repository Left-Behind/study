package work.azhu.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import work.azhu.springbootmybatis.pojo.UserInfo;
import work.azhu.springbootmybatis.service.UserService;

import java.util.List;

/**
 * @Author Azhu
 * @Date 2019/12/6 14:31
 * @Description
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/queryAllUserInfoList")
    @ResponseBody
    public String queryAllUserInfoList(){

        String s="";
        List<UserInfo> list=userService.queryAllUserInfoList();
        for (UserInfo userInfo : list) {
            System.out.println(userInfo.toString());
            s+=userInfo.toString();
        }
        return s;
    }
}
