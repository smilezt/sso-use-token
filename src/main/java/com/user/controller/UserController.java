package com.user.controller;

import com.user.pojo.User;
import com.user.service.UserService;
import com.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/wel")
    public String wel(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        String token = (String)session.getAttribute("token");
        long useId = JwtUtil.getAppUID(token);
        System.out.println("**********************************"+useId);
        User user = userService.queryById(useId);
        System.out.println("**********************************"+useId);
        model.addAttribute("userName",user.getUserName());
        return "wel";
    }

}













