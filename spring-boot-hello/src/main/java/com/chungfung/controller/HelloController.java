package com.chungfung.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/6 14:22
 * @Version 1.0
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("/hi")
    public String hello(@RequestParam("name") String name){
        return "Hello, Welcome " + name;
    }
}
