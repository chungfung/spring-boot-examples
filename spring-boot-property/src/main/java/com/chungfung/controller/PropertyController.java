package com.chungfung.controller;

import com.chungfung.property.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/6 14:58
 * @Version 1.0
 */
@RestController
@RequestMapping("property")
public class PropertyController {

    @Autowired
    private CustomProperty customProperty;

    @Autowired
    private PlaceholderProperty placeholderProperty;

    @Autowired
    private ObjectProperty objectProperty;

    @Autowired
    private NestProperty nestProperty;

    @Autowired
    private EnvironmentProperty environmentProperty;

    @RequestMapping("getProperty")
    public Object getProperty(){
        CustomProperty cust = new CustomProperty();
        BeanUtils.copyProperties(customProperty,cust);
        return cust;
    }

    @RequestMapping("getPlaceholderProperty")
    public Object getPlaceholderProperty(){
        Map<String,String> map = new HashMap<>();
        map.put("name", placeholderProperty.getName());
        map.put("desc",placeholderProperty.getDescription());
        return map;
    }

    @RequestMapping("getObjectProperty")
    public Object getObjectProperty(){
        ObjectProperty obj = new ObjectProperty();
        BeanUtils.copyProperties(objectProperty,obj);
        return obj;
    }

    @RequestMapping("getNestProperty")
    public Object getNestProperty(){
        NestProperty nest = new NestProperty();
        BeanUtils.copyProperties(nestProperty,nest);
        return nest;
    }

    @RequestMapping("getEnvironmentProperty")
    public Object getEnvironmentProperty(){
        EnvironmentProperty evn = new EnvironmentProperty();
        BeanUtils.copyProperties(environmentProperty,evn);
        return evn;
    }
}
