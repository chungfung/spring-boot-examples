package com.chungfung.controller;

import com.chungfung.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/9 11:50
 * @Version 1.0
 */
@Controller
@RequestMapping("mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("sendSimpleMail")
    @ResponseBody
    public String sentSimpleMail(){
        mailService.sendSimpleMail("815388964@qq.com","test","test....");
        return "SUCCESS";
    }
}
