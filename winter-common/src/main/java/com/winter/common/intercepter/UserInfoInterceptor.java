package com.winter.common.intercepter;

import cn.hutool.core.util.StrUtil;
import com.winter.common.constant.UserConstant;
import com.winter.common.utils.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: winter-mall
 * @description: 获取用户信息拦截器
 * @author: Mr.Ye
 * @create: 2023-12-22 22:09
 **/
public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取请求头的用户信息
        String userInfo = request.getHeader(UserConstant.USERINFO_HEADER);
        // 2. 设置线程上下文
        if (StrUtil.isNotBlank(userInfo)) {
            UserContext.setUser(Long.valueOf(userInfo));
        }
        // 3. 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除线程上下文对象
        UserContext.removeUser();
    }
}
