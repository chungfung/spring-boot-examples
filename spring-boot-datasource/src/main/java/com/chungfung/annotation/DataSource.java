package com.chungfung.annotation;

import com.chungfung.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/20 13:58
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.DB1;
}