package com.chungfung.aop;

import com.chungfung.annotation.DataSource;
import com.chungfung.multiple.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/20 13:59
 * @Version 1.0
 */
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@within(com.chungfung.annotation.DataSource) || @annotation(com.chungfung.annotation.DataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource){
        log.info("选择数据源---"+dataSource.value().getValue());
        DataSourceContextHolder.setDataSource(dataSource.value().getValue());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }
}