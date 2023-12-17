package com.winter.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: winter-mall
 * @description: 商品微服务启动类
 * @author: Mr.Ye
 * @create: 2023-12-16 21:21
 **/
@MapperScan("com.winter.item.mapper")
@SpringBootApplication
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class, args);
    }
}
