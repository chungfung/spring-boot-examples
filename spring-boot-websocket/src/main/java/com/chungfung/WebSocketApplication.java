package com.chungfung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/23 11:19
 **/
@SpringBootApplication
@EnableScheduling
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }

}
