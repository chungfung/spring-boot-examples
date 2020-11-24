package com.chungfung.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 丰涌
 * @ClassName Producer
 * @Description 生产者测试
 * @Date 2020/10/20 15:00
 * @Version 1.0
 **/
@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void prod(String topic, String data, int start, int size){
        for (int i = start; i < start + size; i++) {
            kafkaTemplate.send(topic, data+i).addCallback(success->{
                System.out.println("发送成功：" + success);
            },fail->{
                System.out.println("发送失败:" + fail);
            });
        }
    }
}
