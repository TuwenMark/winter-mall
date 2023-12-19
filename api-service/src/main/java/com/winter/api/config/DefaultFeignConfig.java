package com.winter.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @program: winter-mall
 * @description: Feign的默认配置类
 * @author: Mr.Ye
 * @create: 2023-12-17 21:57
 **/
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
