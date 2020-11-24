package com.chungfung.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author 丰涌
 * @ClassName MessageConsumer
 * @Description 消费者测试
 * @Date 2020/10/20 15:14
 * @Version 1.0
 **/
@Component
public class MessageConsumer1 {

    @KafkaListener(topics = {"first"},groupId = "user-group-3")
    public void consumer(ConsumerRecord consumerRecord){
        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if(kafkaMassage.isPresent()){
            System.out.println("MessageConsumer1获取消息：" + kafkaMassage.get());
        }
    }
}
