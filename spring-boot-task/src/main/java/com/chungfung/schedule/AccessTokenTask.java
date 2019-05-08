package com.chungfung.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/8 09:20
 * @Version 1.0
 */
@Component
public class AccessTokenTask {

    @Scheduled(fixedRate = 20000)
    public void test(){
        System.out.println("定时执行！");
    }
}
