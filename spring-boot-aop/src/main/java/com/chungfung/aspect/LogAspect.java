package com.chungfung.aspect;

import com.chungfung.annotation.UserAccess;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL :{} ",request.getRequestURL().toString());
        logger.info("HTTP_METHOD :{} " ,request.getMethod());
        logger.info("IP : {}" ,request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        UserAccess userAccess = getAnnotationLog(joinPoint);
        logger.info("LOG:" + userAccess.desc());
    }

    /**
     * 处理完请求，返回内容
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println("处理完请求！");
        logger.info("方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     * @param jp
     */
    @AfterThrowing("webLog()")
    public void afterThrowing(JoinPoint jp){
        logger.info(jp.getKind());
        logger.info("方法异常时执行.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("webLog()")
    public void after(JoinPoint jp){
        System.out.println("最终通知");
        logger.info("方法最后执行.....");
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("方法环绕start.....");
        try {
            Object o =  pjp.proceed();
            logger.info("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            logger.error("环绕通知发生异常！");
            throw e;
        }
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
