package com.chungfung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/23 11:29
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
