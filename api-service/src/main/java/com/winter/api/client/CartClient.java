package com.winter.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * @program: winter-mall
 * @description: 购物车服务Feign客户端
 * @author: Mr.Ye
 * @create: 2023-12-20 06:42
 **/
@FeignClient("cart-service")
public interface CartClient {
    @DeleteMapping("/carts")
    public void deleteCartItemByIds(@RequestParam("ids") Collection<Long> ids);
}
