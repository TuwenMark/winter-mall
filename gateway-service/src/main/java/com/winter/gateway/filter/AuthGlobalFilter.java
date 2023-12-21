package com.winter.gateway.filter;

import com.winter.gateway.config.AuthProperties;
import com.winter.gateway.util.JwtTool;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @program: winter-mall
 * @description: 全局过滤器类
 * @author: Mr.Ye
 * @create: 2023-12-21 21:56
 **/
@Component
@RequiredArgsConstructor
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private final JwtTool jwtTool;

    private final AuthProperties authProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 2. 判断是否拦截
        if (isExclude(request.getPath().toString())) {
            return chain.filter(exchange);
        }
        // 3. 获取token
        List<String> tokenList = request.getHeaders().get("authorization");
        if (tokenList == null || tokenList.isEmpty()) {
            // 拦截并设置响应状态码401
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        // 4. 解析token
        Long userId = jwtTool.parseToken(tokenList.get(0));
        // 5. TODO 传递token
        System.out.println(userId);
        // 放行
        return chain.filter(exchange);
    }

    private boolean isExclude(String path) {
        // 获取exclude路径
        AntPathMatcher matcher = new AntPathMatcher();
        for (String excludePath : authProperties.getExcludePaths()) {
            if (matcher.match(excludePath, path)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
