package com.chungfung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/7 10:56
 * @Version 1.0
 */
@RequestMapping("exception")
@Controller
public class ExceptionController {

    @RequestMapping("/test")
    public String test(){
        return "page/test";
    }

    @RequestMapping("/jsonError")
    @ResponseBody
    public Object jsonError(){
        int i = 0;
        int j = 0;
        int k = i/j;
        return null;
    }

    @RequestMapping("/pageError")
    @ResponseBody
    public String pageError(){
        int i = 0;
        int j = 0;
        int k = i/j;
        return "page/test";
    }
}
