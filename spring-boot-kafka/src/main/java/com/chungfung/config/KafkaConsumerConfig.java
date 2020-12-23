package com.chungfung.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/7 14:35
 **/
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private KafkaConfig kafkaConfig;


    /**
     * 默认的，只能固定配置一个消费组，若多个消费组，需要 指定配置 @ConditionalOnMissingBean
     */
    /*****************************************************************************************************
     * *********  实现kafka默认的 consumerFactory 和 kafkaListenerContainerFactory bean注入 ****************
     * ***************************************************************************************************
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getDataGroupServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test_1");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 50);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(3);
        factory.setConsumerFactory(dataGroupConsumerFactory());
        return factory;
    }


    /**********************************************************************************************
     * ***********************  自定义配置 多个监听 和  多group **************************************
     * ********************************************************************************************
     */

    @Bean
    @ConditionalOnMissingBean(name = "dataGroupConsumerFactory")
    public ConsumerFactory<String, String> dataGroupConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getDataGroupServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfig.getDataGroupConsumerGroupId());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 50);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    @ConditionalOnMissingBean(name = "dataGroupKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, String> dataGroupKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(3);
        factory.setConsumerFactory(dataGroupConsumerFactory());
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean(name = "dataGroupConsumerFactory2")
    public ConsumerFactory<String, String> dataGroupConsumerFactory2() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getDataGroupServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfig.getDataGroupConsumerGroupId());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 50);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    @ConditionalOnMissingBean(name = "dataGroupKafkaListenerContainerFactory2")
    public ConcurrentKafkaListenerContainerFactory<String, String> dataGroupKafkaListenerContainerFactory2() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(3);
        factory.setConsumerFactory(dataGroupConsumerFactory());
        return factory;
    }
}