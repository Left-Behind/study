package work.azhu.alipay.controller;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.azhu.alipay.conf.AlipayConfig;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class PaymentController {

    @Autowired
    AlipayClient alipayClient;


    /**
     * 同步回调是显示给用户看的
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("alipay/callback/return")
    public String aliPayCallBackReturn(HttpServletRequest request, ModelMap modelMap){


        String responseResult=JSON.toJSONString(modelMap);

        // 回调请求中获取支付宝参数
        log.info("---------------打印支付宝(同步)回调参数(参数在请求头request中)-------------");
        String sign = request.getParameter("sign");
        log.info("sign: "+sign);
        String trade_no = request.getParameter("trade_no");
        log.info("trade_no: "+trade_no);
        String out_trade_no = request.getParameter("out_trade_no");
        log.info("out_trade_no: "+out_trade_no);
        String trade_status = request.getParameter("trade_status");
        log.info("trade_status: "+trade_status);
        String total_amount = request.getParameter("total_amount");
        log.info("total_amount: "+total_amount);
        String subject = request.getParameter("subject");
        log.info("subject: "+subject);
        String call_back_content = request.getQueryString();
        log.info("call_back_content: "+call_back_content);
        // 通过支付宝的paramsMap进行签名验证，2.0版本的接口将paramsMap参数去掉了，导致同步请求没法验签
        if(StringUtils.isNotBlank(sign)){
            // 验签成功
            // 更新用户的支付状态
            System.out.println("同步回调成功");
        }

        return "finish";
    }

    /**
     * 支付宝第三方支付异步回调
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("alipay/callback/notify")
    public String aliPayCallBackNotify(HttpServletRequest request, ModelMap modelMap){

        String responseResult=JSON.toJSONString(modelMap);

        // 回调请求中获取支付宝参数
        log.info("---------------打印支付宝(异步)回调参数(参数在请求头request中)-------------");
        String sign = request.getParameter("sign");
        log.info("sign: "+sign);
        String trade_no = request.getParameter("trade_no");
        log.info("trade_no: "+trade_no);
        String out_trade_no = request.getParameter("out_trade_no");
        log.info("out_trade_no: "+out_trade_no);
        String trade_status = request.getParameter("trade_status");
        log.info("trade_status: "+trade_status);
        String total_amount = request.getParameter("total_amount");
        log.info("total_amount: "+total_amount);
        String subject = request.getParameter("subject");
        log.info("subject: "+subject);
        String call_back_content = request.getQueryString();
        log.info("call_back_content: "+call_back_content);
        // 通过支付宝的paramsMap进行签名验证，2.0版本的接口将paramsMap参数去掉了，导致同步请求没法验签
        if(StringUtils.isNotBlank(sign)){
            // 验签成功
            // 更新用户的支付状态
            System.out.println("异步回调成功");
        }

        return "finish";
    }



    @RequestMapping("alipay/submit")
   // @LoginRequired(loginSuccess = true)
    @ResponseBody
    public String alipay(String outTradeNo, BigDecimal totalAmount, HttpServletRequest request, ModelMap modelMap){

        // 获得一个支付宝请求的客户端(它并不是一个链接，而是一个封装好的http的表单请求)
        String form = null;
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request

        // 回调函数
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        Map<String,Object> map = new HashMap<>();
        map.put("out_trade_no",outTradeNo);
        map.put("product_code","FAST_INSTANT_TRADE_PAY");
        map.put("total_amount",0.01);
        map.put("subject","尚硅谷感光徕卡Pro300瞎命名系列手机");

        String param = JSON.toJSONString(map);

        alipayRequest.setBizContent(param);

        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            System.out.println(form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        // 提交请求到支付宝
        return form;
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request, ModelMap modelMap){
        modelMap.put("nickname","Azhu");
        modelMap.put("outTradeNo","Azhu-123456"+System.currentTimeMillis());
        modelMap.put("totalAmount","0.1");

        return "index";
    }

    @RequestMapping("orderList")
    public String orderList(){

        return "finish";
    }

    /**
     * 微信支付
     * @param outTradeNo
     * @param totalAmount
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("mx/submit")
    //@LoginRequired(loginSuccess = true)
    public String mx(String outTradeNo, BigDecimal totalAmount, HttpServletRequest request, ModelMap modelMap){


        return null;
    }
}
