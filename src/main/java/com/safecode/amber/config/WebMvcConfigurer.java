package com.safecode.amber.config;

import com.safecode.amber.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/pages/Amberhtml/login.html","classpath:/static/"  );//PathPatterns为过滤的url路径,excludePathPatterns不拦截的url路径多个路径用逗号隔开
        super.addInterceptors(registry);
    }
}
