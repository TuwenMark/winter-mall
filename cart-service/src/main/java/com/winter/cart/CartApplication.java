package com.winter.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: winter-mall
 * @description: 购物车微服务
 * @author: Mr.Ye
 * @create: 2023-12-16 21:44
 **/
@MapperScan("com.winter.cart.mapper")
@SpringBootApplication
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
