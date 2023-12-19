package com.winter.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: winter-mall
 * @description: 用户微服务启动类
 * @author: Mr.Ye
 * @create: 2023-12-17 22:04
 **/
@MapperScan("com.winter.user.mapper")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
