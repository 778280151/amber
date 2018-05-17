package com.safecode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.safecode.amber.dao") // 扫描mybatis的mapper接口
public class AmberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmberApplication.class, args);
    }
}
