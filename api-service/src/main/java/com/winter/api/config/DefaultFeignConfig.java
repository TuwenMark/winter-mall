package com.winter.api.config;

import com.winter.common.constant.UserConstant;
import com.winter.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
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

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 1. 获取用户ID
                Long userId = UserContext.getUser();
                if (userId != null) {
                    // 2. 保存至请求头
                    template.header(UserConstant.USERINFO_HEADER, userId.toString());
                }
            }
        };
    }
}
