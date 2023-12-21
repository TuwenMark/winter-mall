package com.winter.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @program: winter-mall
 * @description: 订单服务OpenFeign客户端
 * @author: Mr.Ye
 * @create: 2023-12-21 07:07
 **/
@FeignClient("order-service")
public interface OrderClient {
    @PutMapping("/orders/{orderId}")
    public void markOrderPaySuccess(@PathVariable("orderId") Long orderId);
}
