package com.winter.pay;

import com.winter.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: winter-mall
 * @description: 支付服务启动类
 * @author: Mr.Ye
 * @create: 2023-12-21 07:03
 **/
@SpringBootApplication
@MapperScan("com.winter.pay.mapper")
@EnableFeignClients(basePackages = "com.winter.api.client", defaultConfiguration = DefaultFeignConfig.class)
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
