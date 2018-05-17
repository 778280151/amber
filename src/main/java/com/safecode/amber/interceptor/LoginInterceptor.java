package com.safecode.amber.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("Interceptor1 start work");
//        HttpSession session = request.getSession();
//        if (session.getAttribute("user") == null) {
//            System.out.println("这是request路径" + request.getRequestURL());
//            response.sendRedirect("/pages/Amberhtml/index.html");
//            return false;
//        } else {
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {
        System.out.println("Interceptor1 before return view");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
        System.out.println("Interceptor1 finish work");
    }
}
