package com.winter.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: winter-mall
 * @description: 用户服务OpenFeign客户端
 * @author: Mr.Ye
 * @create: 2023-12-21 07:01
 **/
@FeignClient("user-service")
public interface UserClient {
    @PutMapping("/users/money/deduct")
    public void deductMoney(@RequestParam("pw") String pw, @RequestParam("amount") Integer amount);
}
