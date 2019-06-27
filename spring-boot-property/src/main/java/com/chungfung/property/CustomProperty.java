package com.chungfung.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/6 14:57
 * @Version 1.0
 */
@Component
@Data
public class CustomProperty {

    @Value("${com.test.name}")
    private String name;

    @Value("${com.test.password}")
    private String password;

    @Value("${com.test.value}")
    private String value;

    @Value("${com.test.number}")
    private String number;

    @Value("${com.test.bignumber}")
    private Long bignumber;

    @Value("${com.test.test1}")
    private int test1;

    @Value("${com.test.test2}")
    private int test2;

}
