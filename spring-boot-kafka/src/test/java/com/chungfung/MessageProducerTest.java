package com.chungfung;

import com.chungfung.producer.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 丰涌
 * @ClassName ProducerTest
 * @Description 生产者测试
 * @Date 2020/10/20 14:25
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerTest {

    @Autowired
    private MessageProducer messageProducer;

    @Test
    public void test(){
        messageProducer.prod("first","new data for test",0,10);
    }
}