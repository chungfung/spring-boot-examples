package com.chungfung.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/8 10:36
 * @Version 1.0
 */
public class LogInterceptor extends HandlerInterceptorAdapter{

    private Log logger = LogFactory.getLog(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("参数日志结束！");
        return true;
    }
}
