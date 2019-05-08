package com.chungfung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/8 10:40
 * @Version 1.0
 */
@RequestMapping("interceptor")
@Controller
public class InterceptorController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "SUCCESS";
    }
}
