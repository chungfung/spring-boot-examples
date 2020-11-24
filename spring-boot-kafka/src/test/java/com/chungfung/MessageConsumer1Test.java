package com.chungfung;

import com.chungfung.consumer.MessageConsumer1;
import com.chungfung.consumer.MessageConsumer2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 丰涌
 * @ClassName ProducerTest
 * @Description 消费者测试
 * @Date 2020/10/20 14:25
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConsumer1Test {

    @Autowired
    private MessageConsumer1 messageConsumer1;

    @Autowired
    private MessageConsumer2 messageConsumer2;

    @Test
    public void consumTest(){

    }
}