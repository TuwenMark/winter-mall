package com.winter.cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: winter-mall
 * @description: Spring需要自动注入的Bean
 * @author: Mr.Ye
 * @create: 2023-12-16 22:59
 **/
@Configuration
public class BeanConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
