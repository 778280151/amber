package com.safecode.amber.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    LoginInterceptor kk() {
        return new LoginInterceptor();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("Interceptor1 start work");
        System.out.println("ddddd" + request.getRequestURI());
        if (request.getRequestURI().equals("/error")) {
            response.sendRedirect("/pages/Amberhtml/login.html");
            return false;
        }
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {
//        System.out.println("Interceptor1 before return view");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
//        System.out.println("Interceptor1 finish work");
//    }
}
