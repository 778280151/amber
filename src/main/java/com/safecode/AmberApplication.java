package com.safecode;

import com.safecode.amber.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan(value = "com.safecode.amber.dao") // 扫描mybatis的mapper接口
public class AmberApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmberApplication.class, args);
    }
}
