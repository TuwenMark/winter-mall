package com.winter.cart;

import com.winter.api.config.DefaultFeignConfig;
import com.winter.api.config.FallbackFactoryConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: winter-mall
 * @description: 购物车微服务
 * @author: Mr.Ye
 * @create: 2023-12-16 21:44
 **/
@EnableFeignClients(basePackages = "com.winter.api.client", defaultConfiguration = {DefaultFeignConfig.class, FallbackFactoryConfig.class})
@MapperScan("com.winter.cart.mapper")
@ConfigurationPropertiesScan("com.winter.cart.config")
@SpringBootApplication
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
