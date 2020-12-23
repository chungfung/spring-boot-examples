package com.chungfung.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/7 14:34
 **/
@Configuration
public class KafkaProducerConfig {

    /**
     * 主要配置kafka的 servers 和 groupId
     */
    @Autowired
    private KafkaConfig kafkaConfig;

    @Bean
    public ProducerFactory<String, String> dataGroupProducerFactory(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getDataGroupServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean(name = "kafkaTemplate4DataGroup")
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(dataGroupProducerFactory());
    }
}