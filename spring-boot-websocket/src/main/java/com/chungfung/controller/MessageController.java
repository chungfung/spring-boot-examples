package com.chungfung.controller;

import com.chungfung.vo.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Random;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/23 11:19
 **/
@Controller
public class MessageController {

    /** 消息发送工具对象 */
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    /** 广播发送消息，将消息发送到指定的目标地址 */
    @MessageMapping("/test")
    public void sendTopicMessage(MessageBody messageBody) {
        // 将消息发送到 WebSocket 配置类中配置的代理中（/topic）进行消息转发
        simpMessageSendingOperations.convertAndSend(messageBody.getDestination(), messageBody);
    }

    @Scheduled(fixedRate = 5000L)
    public void sendMessage(){
        MessageBody messageBody = new MessageBody();
        int i = new Random().nextInt(3);
        messageBody.setDestination("/topic" + (i+1));
        messageBody.setContent("随机产生值：" + new Random().nextInt(1000));
        System.out.println(messageBody);
        simpMessageSendingOperations.convertAndSend(messageBody.getDestination(), messageBody);
    }

    @EventListener
    public void onDisconnectEvent(SessionConnectedEvent event) {
        System.out.println("连接用户：" + event.getUser());
    }
}