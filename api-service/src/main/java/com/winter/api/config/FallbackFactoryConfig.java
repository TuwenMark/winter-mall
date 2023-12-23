package com.winter.api.config;

import com.winter.api.client.fallback.ItemClientFallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: winter-mall
 * @description: 异常失败工厂配置类
 * @author: Mr.Ye
 * @create: 2023-12-23 21:00
 **/
@Configuration
public class FallbackFactoryConfig {
    @Bean
    public ItemClientFallbackFactory itemClientFallbackFactory() {
       return new ItemClientFallbackFactory();
    }
}
