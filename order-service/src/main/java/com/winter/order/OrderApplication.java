package com.winter.order;

import com.winter.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: winter-mall
 * @description: 订单服务启动类
 * @author: Mr.Ye
 * @create: 2023-12-20 06:34
 **/
@SpringBootApplication
@MapperScan("com.winter.order.mapper")
@EnableFeignClients(basePackages = "com.winter.api.client", defaultConfiguration = DefaultFeignConfig.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
