package work.azhu.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import work.azhu.auth.conf.GitHubConfig;
import work.azhu.auth.util.GithubHttpClient;
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
    public String callback(String code, Model model) throws Exception {

        //step2 :使用code获取access_Token
        String url="https://github.com/login/oauth/access_token?client_id=" + GitHubConfig.CLIENT_ID +
                "&client_secret=" + GitHubConfig.CLIENT_SECRET +
                "&code=" +code+
                "&redirect_uri=" + GitHubConfig.CALLBACK ;
        String entity = GithubHttpClient.getAccessToken(url);

        //step2 :使用access_Token换取用户信息
        Map<String,String> map=GithubHttpClient.getMap(entity);
            url="https://api.github.com/user?access_token="+map.get("access_token");
        //获取到的全部信息
        JSONObject jsonObject = GithubHttpClient.getUserInfo(url);
        System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
            model.addAttribute("openid","github没有个OpenId");  //openid,用来唯一标识qq用户
            model.addAttribute("nickname",(String)jsonObject.get("login")); //用户名
            model.addAttribute("figureurl_qq_2",(String)jsonObject.get("avatar_url")); //头像URL
        return "success";
    }

    //https://github.com/login/oauth/authorize?client_id=Iv1.44aef8a11f81a601&state=xx&redirect_uri=http://localhost:8080/github/callback
    @RequestMapping("github/toLogin")
    public String qq(HttpSession session){

        String url = "https://github.com/login/oauth/authorize?"+
                "client_id=" + GitHubConfig.CLIENT_ID +
                "&redirect_uri=" + GitHubConfig.CALLBACK;

        return "redirect:" + url;
    }
}
