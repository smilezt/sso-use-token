package com.user.interceptor;

import com.user.util.HttpUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=null;
        HttpSession session = request.getSession(false);
        token = request.getParameter("token");
        if(token==null && session != null && session.getAttribute("token") != null){
            token = (String)session.getAttribute("token");
        }
        System.out.println(token);
        if (token != null) {
            String reqUrl = "http://www.xiaozhao.com:8090/checkToken";
            String content = "token=" + token;
            String result = HttpUtil.sendReq(reqUrl, content);
            if ("correct".equals(result)) {
                //user.com中创建局部session会话
                request.getSession().setAttribute("token", token);
                return true;
            }
        }
        //表示当你需要访问某个user.com下面的保护资源时，既没有session会话信息，又没有其他系统已经登录过的token信息的，sso.com认证
        response.sendRedirect("http://www.xiaozhao.com:8090/preLogin?url=www.user.com:8081/user/wel");
        return false;
    }
}
