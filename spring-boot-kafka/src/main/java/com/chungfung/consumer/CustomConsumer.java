package com.chungfung.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author liubo
 */
public class CustomConsumer {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka01:9092,kafka02:9092,kafka03:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        props.put(ConsumerConfig.GROUP_ID_CONFIG, "user-log-group");

        //1.创建1个消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList("first"));

        //2.调用poll
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10L));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("消费：topic = " + record.topic() + " offset = " + record.offset() + " value = " + record.value());
            }
            consumer.commitAsync();
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // consumer.close();
    }
}
