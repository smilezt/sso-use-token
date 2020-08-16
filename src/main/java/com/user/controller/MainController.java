package com.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, String url){
        HttpSession session = request.getSession(false);
        session.removeAttribute("token");
        return "redirect:http://www.xiaozhao.com:8090/logout?url="+url;
    }
}
