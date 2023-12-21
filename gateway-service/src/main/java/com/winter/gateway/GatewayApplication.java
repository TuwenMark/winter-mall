package com.winter.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @program: winter-mall
 * @description: 网关服务启动类
 * @author: Mr.Ye
 * @create: 2023-12-21 21:08
 **/
@SpringBootApplication
@ConfigurationPropertiesScan("com.winter.gateway.config")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
