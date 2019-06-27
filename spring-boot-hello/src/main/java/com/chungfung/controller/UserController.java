package com.chungfung.controller;

import com.chungfung.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/6 14:34
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){

        User user = new User();
        user.setName("张三");
        user.setAge(30);
        user.setBirthday(new Date());
        user.setAddress("广州市天河区");

        return user;
    }
}
