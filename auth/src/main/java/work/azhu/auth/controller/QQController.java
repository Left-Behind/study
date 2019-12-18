package work.azhu.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.text.normalizer.NormalizerBase;
import work.azhu.auth.conf.QQConfig;
import work.azhu.auth.util.HttpClientUtils;
import work.azhu.auth.util.QQHttpClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/12/17 21:50
 **/
@Controller
public class QQController {


    /**
     * QQ 调起接口
     * @return
     */
    @RequestMapping("/qq/toLogin")
    public String qq(){
        //Step1：获取Authorization Code
        String url = "https://graph.qq.com/oauth2.0/authorize?response_type=code"+
                "&client_id=" + QQConfig.APPID +
                "&redirect_uri=" + URLEncoder.encode(QQConfig.CALLBACK_URL);//这里需要地址加密
        return "redirect:" + url;
    }

    /**
     * {
     "ret":0,
     "msg":"",
     "is_lost":0,
     "gender":"男",
     "is_yellow_vip":"0",
     "city":"丽水",
     "year":"1996",
     "level":"0",
     "figureurl_2":"http://qzapp.qlogo.cn/qzapp/101774548/A0CD1B42B38BB4B455C6AFC2119201B8/100",
     "figureurl_1":"http://qzapp.qlogo.cn/qzapp/101774548/A0CD1B42B38BB4B455C6AFC2119201B8/50",
     "gender_type":1,
     "is_yellow_year_vip":"0",
     "province":"浙江",
     "constellation":"",
     "figureurl":"http://qzapp.qlogo.cn/qzapp/101774548/A0CD1B42B38BB4B455C6AFC2119201B8/30",
     "figureurl_type":"1",
     "figureurl_qq":"http://thirdqq.qlogo.cn/g?b=oidb&k=V5YKmcO6loiaAgGrOjXRl7A&s=640&t=1557093782",
     "nickname":"阿朱",
     "yellow_vip_level":"0",
     "figureurl_qq_1":"http://thirdqq.qlogo.cn/g?b=oidb&k=V5YKmcO6loiaAgGrOjXRl7A&s=40&t=1557093782",
     "vip":"0",
     "figureurl_qq_2":"http://thirdqq.qlogo.cn/g?b=oidb&k=V5YKmcO6loiaAgGrOjXRl7A&s=100&t=1557093782"
     }
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/qq/callback")
    public String qqcallback(HttpServletRequest request,Model model) throws Exception {
        //qq返回的信息：http://graph.qq.com/demo/index.jsp?code=9A5F************************06AF&state=test
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        //Step2：通过Authorization Code获取Access Token
        String backUrl = QQConfig.CALLBACK_URL;
        String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code"+
                "&client_id=" + QQConfig.APPID +
                "&client_secret=" + QQConfig.APPKEY +
                "&code=" + code +
                "&redirect_uri=" + backUrl;

        String access_token = QQHttpClient.getAccessToken(url);

        //Step3: 获取回调后的 openid 值
        url = "https://graph.qq.com/oauth2.0/me?access_token=" + access_token;
        String openid = QQHttpClient.getOpenID(url);

        //Step4：获取QQ用户信息
        url = "https://graph.qq.com/user/get_user_info?access_token=" + access_token +
                "&oauth_consumer_key="+ QQConfig.APPID +
                "&openid=" + openid;

        JSONObject jsonObject = QQHttpClient.getUserInfo(url);
        System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        model.addAttribute("openid",openid);  //openid,用来唯一标识qq用户
        model.addAttribute("nickname",(String)jsonObject.get("nickname")); //QQ名
        model.addAttribute("figureurl_qq_2",(String)jsonObject.get("figureurl_qq_2")); //大小为100*100像素的QQ头像URL

        //跳转登录成功页
        return "success";
    }

}
