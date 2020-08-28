package com.user.controller;

import com.user.service.UserService;
import com.user.util.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * user系统入口
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/wel")
    public String wel(HttpServletRequest request, Model model,String token){

        String userName = CryptoUtil.decode(token);
        //传回username
        model.addAttribute("userName",userName);
        return "wel";
    }

}













