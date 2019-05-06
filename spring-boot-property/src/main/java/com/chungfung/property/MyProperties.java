package com.chungfung.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/6 14:57
 * @Version 1.0
 */
@Component
public class MyProperties {

    @Value("com.test.name")
    private String name;

    @Value("com.test.password")
    private String password;
}
