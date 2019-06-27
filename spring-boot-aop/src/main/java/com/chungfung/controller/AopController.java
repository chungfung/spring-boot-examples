package com.chungfung.controller;

import com.chungfung.annotation.UserAccess;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/8 11:11
 * @Version 1.0
 */
@RequestMapping("aop")
@Controller
public class AopController {

    @RequestMapping("test")
    @ResponseBody
    @UserAccess(desc = "自定义注解")
    public String test(){
        return "SUCCESS";
    }
}
