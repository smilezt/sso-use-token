package com.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    /**
     * 登出
     * @param request
     * @param url
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, String url){
        HttpSession session = request.getSession(false);
        //清除局部token
        session.removeAttribute("token");
        //重定向到sso登出
        return "redirect:http://www.xiaozhao.com:8090/logout?url="+url;
    }
}
