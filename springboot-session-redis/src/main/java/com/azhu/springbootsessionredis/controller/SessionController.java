package com.azhu.springbootsessionredis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @Value("${server.port}")
    private Integer projectPort;// 项目端口

    @RequestMapping("/createSession")
    @ResponseBody
    public String createSession(HttpSession session, String name) {
        session.setAttribute("name", name);
        return "当前项目端口：" + projectPort + " 当前sessionId :" + session.getId() + "在Session中存入成功！";
    }

    @RequestMapping("/getSession")
    @ResponseBody
    public String getSession(HttpSession session) {
        return "当前项目端口：" + projectPort + " 当前sessionId :" + session.getId() + "  获取的姓名:" + session.getAttribute("name");
    }

    @PostMapping("/test")
    public String Test1(HttpServletRequest request/*,Model model*/){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        HttpSession session=request.getSession();
        session.setAttribute("userName",userName);
        session.setAttribute("passWord",passWord);
        return "redirect:home";
    }

    @GetMapping("/index")
    public String index(){
        System.out.println("sdfsdfd2");
        return "index";
    }
    @GetMapping("/")
    public String Test1(){
        System.out.println("sdfsdfd");
        return "index";
    }

    @RequestMapping("/home")
    public String Test2(HttpServletRequest request,Model model){
        Object userName = request.getSession().getAttribute("userName");
        Object passWord =  request.getSession().getAttribute("passWord");
        model.addAttribute("userName",userName);
        model.addAttribute("passWord",passWord);
        model.addAttribute("port",projectPort);
        return "home";
    }
}
