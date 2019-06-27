package com.chungfung.property;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 嵌套属性注入
 * @Author chungfung
 * @Date 2019/5/6 14:57
 * @Version 1.0
 */
@Data
@ConfigurationProperties
@Component
public class NestProperty {

    private String name;

    private Jdbc jdbc;

    @Data
    class Jdbc {
        private String username;
        private String password;
    }
}
