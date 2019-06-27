package com.chungfung.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/6 15:29
 * @Version 1.0
 */
@Component
@Data
public class PlaceholderProperty {

    @Value("${app.name}")
    private String name;

    @Value("${app.description}")
    private String description;
}
