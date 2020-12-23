package com.chungfung.config;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.core.StreamsBuilderFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 丰涌
 * @DATE: 2018/11/22 16:16
 */
@Configuration
@EnableKafka
public class KafkaSetupConfig {

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public StreamsConfig kStreamsConfigs(){
        Map< String,Object> props = new HashMap<String, Object>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG,"myappId1001");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka01:9092");
        return new StreamsConfig(props);
    }

    @Bean(name ="myKappConfig")
    public StreamsConfig myKafkaAppIdConfiguration(){
        Map< String,Object> props = new HashMap<String, Object>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG,"myappId1002");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka01:9092");
        props.put(StreamsConfig.STATE_DIR_CONFIG,"d://kafkastate");
        props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG,StreamsConfig.EXACTLY_ONCE);
        return new StreamsConfig(props);
    }

    @Bean(name ="myKappConfigStreamBuilder")
    public StreamsBuilderFactoryBean myAppStreamBuilder(
    @Qualifier("myKappConfig")StreamsConfig myKafkaAppIdConfiguration){
        return new StreamsBuilderFactoryBean(myKafkaAppIdConfiguration);
    }
}