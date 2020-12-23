//package com.chungfung.config;
//
//import org.apache.kafka.streams.StreamsConfig;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
//import org.springframework.kafka.config.KafkaStreamsConfiguration;
//import org.springframework.kafka.config.StreamsBuilderFactoryBean;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @description：Kafka相关应用程序配置类
// * @author: LiangYe
// * @DATE: 2018/11/22 16:16
// */
//@Configuration
//@EnableKafka
//public class KafkaSetupConfigHigh {
//
//    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//    public KafkaStreamsConfiguration kStreamsConfigs(){
//        Map< String,Object> props = new HashMap<>();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG," myappId1000");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG," kafka01:9092");
//        return new KafkaStreamsConfiguration(props);
//    }
//
//    @Bean(name ="myConfig1")
//    public KafkaStreamsConfiguration myKafkaAppIdConfiguration(){
//        Map< String,Object> props = new HashMap<>();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG," myappId9999");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG," kafka01:9092");
//        return new KafkaStreamsConfiguration(props);
//    }
//
//    @Bean(name ="myConfigStreamBuilder1")
//    public StreamsBuilderFactoryBean myAppStreamBuilder(
//    @Qualifier("myConfig1")KafkaStreamsConfiguration myKafkaAppIdConfiguration){
//        return new StreamsBuilderFactoryBean(myKafkaAppIdConfiguration);
//    }
//
//    @Bean(name ="myConfig2")
//    public KafkaStreamsConfiguration myKafkaAppIdConfiguration2(){
//        Map< String,Object> props = new HashMap<>();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG," myappId8888");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG," kafka01:9092");
//        return new KafkaStreamsConfiguration(props);
//    }
//
//    @Bean(name ="myConfigStreamBuilder2")
//    public StreamsBuilderFactoryBean myAppStreamBuilder2(
//            @Qualifier("myConfig2")KafkaStreamsConfiguration myKafkaAppIdConfiguration){
//        return new StreamsBuilderFactoryBean(myKafkaAppIdConfiguration);
//    }
//}