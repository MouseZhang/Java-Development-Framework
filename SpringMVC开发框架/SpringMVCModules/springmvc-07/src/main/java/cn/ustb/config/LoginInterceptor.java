package cn.ustb.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 登录页面放行
        if (request.getRequestURI().contains("goLogin")) {
            return true;
        }
        // 说明在提交登录，也放行
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        // 放行：判断什么情况下登录
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }
        // 判断什么情况下未登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
