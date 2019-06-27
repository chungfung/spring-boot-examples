package com.chungfung.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/6 14:57
 * @Version 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "com.test")
public class ObjectProperty {

    private String desc;

    private Integer port;

    private List<String> servers = new ArrayList<String>();
}
