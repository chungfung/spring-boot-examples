package com.chungfung.controller;

import com.chungfung.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/8 11:37
 * @Version 1.0
 */
@RequestMapping("redis")
@Controller
public class RedisController {

    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        redisUtils.set("chungfung","aaa");
        return redisUtils.get("chungfung");
    }
}
