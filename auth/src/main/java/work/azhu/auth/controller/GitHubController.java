package work.azhu.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import work.azhu.auth.conf.GitHubConfig;
import work.azhu.auth.util.HttpClientUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/12/17 21:50
 **/
@Controller
public class GitHubController {


    @RequestMapping("github/callback")
    public ModelAndView callback(String code, String state) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(state)) {
            //拿到我们的code,去请求token
            //发送一个请求到
            String token_url = GitHubConfig.TOKEN_URL.replace("CODE", code);
            //得到的responseStr是一个字符串需要将它解析放到map中
            String responseStr = HttpClientUtils.doGet(token_url);
            // 调用方法从map中获得返回的--》 令牌
            String token = HttpClientUtils.getMap(responseStr).get("access_token");

            //根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
            String userinfo_url = GitHubConfig.USER_INFO_URL.replace("TOKEN", token);
            //json
            responseStr = HttpClientUtils.doGet(userinfo_url);
            Map<String, String> responseMap = HttpClientUtils.getMapByJson(responseStr);
            //responseMap里面保存着用户登录信息
            System.out.println("登录用户信息:" + responseMap);
            System.out.println("用户信息头像:" + responseMap.get("avatar_url"));
            System.out.println("用户名:" + responseMap.get("login"));
            // 授权成功
            modelAndView.setViewName("success");
            modelAndView.addObject("userName", responseMap.get("login"));
            modelAndView.addObject("img", responseMap.get("avatar_url"));
        } else {
            //授权失败
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    //https://github.com/login/oauth/authorize?client_id=Iv1.44aef8a11f81a601&state=xx&redirect_uri=http://localhost:8080/github/callback
    @RequestMapping("github/toLogin")
    public String qq(HttpSession session){

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //Step1：获取Authorization Code
        String url = "https://github.com/login/oauth/authorize?"+
                "client_id=" + GitHubConfig.CLIENT_ID +
                "&state="+uuid+
                "&redirect_uri=" + GitHubConfig.CALLBACK;

        return "redirect:" + url;
    }
}
