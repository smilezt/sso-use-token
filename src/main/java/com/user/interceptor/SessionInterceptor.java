package com.user.interceptor;

import com.user.util.HttpUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");

        System.out.println(token);
        //验证token
        if (token != null) {
            String reqUrl = "http://www.xiaozhao.com:8090/checkToken";
            String content = "token=" + token;
            String result = HttpUtil.sendReq(reqUrl, content);
            if ("correct".equals(result)) {
                return true;
            }
        }
        return false;
    }
}
