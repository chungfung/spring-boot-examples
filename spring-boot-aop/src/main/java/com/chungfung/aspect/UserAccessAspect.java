package com.chungfung.aspect;

import com.chungfung.annotation.UserAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/8 11:21
 * @Version 1.0
 */
@Component
@Aspect
public class UserAccessAspect {

    @Pointcut(value = "@annotation(com.chungfung.annotation.UserAccess)")
    public void access() {

    }

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("second before");
    }

    // 异常通知

    @AfterThrowing(value = "@annotation(com.chungfung.annotation.UserAccess)", throwing = "e")
    public void doThrow(JoinPoint jp, Throwable e) {
        System.out.println("出错啦");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint pjp, UserAccess userAccess) throws Throwable {
        //获取注解里的值
        System.out.println("second around:" + userAccess.desc());
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
    }
}
