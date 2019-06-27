package com.chungfung.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/6 16:04
 * @Version 1.0
 */
@Component
@Data
public class EnvironmentProperty {

    @Value("${com.test.environment}")
    private String environment;
}
