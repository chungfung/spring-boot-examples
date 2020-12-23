package com.chungfung.aspect;

import com.chungfung.annotation.UserAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/8 11:04
 * @Version 1.0
 */
@Component
@Aspect
@Order(1)
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /** 定义一个切面表达式 */
    @Pointcut(value = "@annotation(com.chungfung.annotation.UserAccess)")
    public void webLog(){}

    /**
     * 接收到请求，记录请求内容
      */
    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        Map<String,Object> param = (Map<String, Object>) joinPoint.getArgs()[joinPoint.getArgs().length-1];
        param.put("id","1");

        UserAccess userAccess = getAnnotationLog(joinPoint);
        logger.info("LOG:" + userAccess.desc());
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private UserAccess getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(UserAccess.class);
        }
        return null;
    }
}
