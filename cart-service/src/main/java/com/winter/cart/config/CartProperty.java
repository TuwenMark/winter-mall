package com.winter.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: winter-mall
 * @description: 购物车相关配置
 * @author: Mr.Ye
 * @create: 2023-12-23 07:57
 **/
@Data
@ConfigurationProperties("wm.cart")
public class CartProperty {
    private Integer maxItems;
}
