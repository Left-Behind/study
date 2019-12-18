package work.azhu.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import work.azhu.auth.conf.SinaConfig;
import work.azhu.auth.util.SinaHttpClient;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/12/17 21:50
 **/
@Controller
public class SinaController {



    @RequestMapping("sina/toLogin")
    public String qq(HttpSession session){
        //Step1：获取Authorization Code
        String url = "https://api.weibo.com/oauth2/authorize?"+
                "client_id=" + SinaConfig.CLIENT_ID +
                "&response_type=code"+
                "&redirect_uri=" + SinaConfig.CALLBACK; //这里和QQ的不同不需要URLEncoder.encode(backUrl)
        return "redirect:" + url;
    }

    @RequestMapping(value = "sina/callback")
    public String callback(String code, Model model) throws IOException {

        //不知道url填什么可以看文档：https://open.weibo.com/wiki/Oauth2/access_token
        //Step2：通过Authorization Code获取Access Token和uid
        String url = "https://api.weibo.com/oauth2/access_token?grant_type=authorization_code" +
                "&client_id="+SinaConfig.CLIENT_ID+
                "&client_secret="+SinaConfig.CLIENT_SECRET+
                "&code="+code+
                "&redirect_uri="+SinaConfig.CALLBACK;
        System.out.println("url"+url);
        JSONObject jsonObject = SinaHttpClient.getAccessTokenAndUid(url);
        //Step3：获取用户信息
        url="https://api.weibo.com/2/users/show.json?access_token="+jsonObject.get("access_token")+
                "&uid="+jsonObject.get("uid");
        JSONObject userInfo = SinaHttpClient.getUserInfo(url);
        System.out.println(JSON.toJSONString(userInfo, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        model.addAttribute("openid", "微博没有这个openId");
        model.addAttribute("nickname", userInfo.get("screen_name"));
        model.addAttribute("figureurl_qq_2", userInfo.get("profile_image_url"));
        return "success";
    }
}
