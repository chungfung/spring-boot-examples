//package com.chungfung.config;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.apache.kafka.streams.StreamsConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
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
//public class KafkaSetupConfig {
//
//    /** Kafka集群地址 */
//    @Value("${spring.k}")
//    private String bootstrapServers;
//
//    /** KafkaStreams applicationId */
//    @Value("${application.stream.applicationId}")
//    private String applicationId;
//
//    @Value("${kafka.replication.factor}")
//    private int kafkaReplicationFactor;
//
//    @Value("${kafkastream.state.dir}")
//    private String kafkaStreamStateDir;
//
//    @Value("${kafka.stream.threads.num:1}")
//    private int kafkaStreamThreadsNum;
//
//    @Value("${kafka.stream.retries}")
//    private int kafkaStreamRetries;
//    @Value("${kafka.num.standby.replicas:0}")
//    private int kafkaNumStandbyReplicas;
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.RETRIES_CONFIG,kafkaStreamRetries);
//        return props;
//    }
//
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
////    /**
////     * @description：KafkaStreams参数配置
////     * @author: LiangYe
////     * @DATE: 2018/11/27 15:06
////     */
////    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
////    public StreamsConfig streamsConfig() {
////        Map<String, Object> props = new HashMap<>();
////        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
////        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
////        //流处理程序创建更改日志topic和重新分配topic的副本数
////        props.put(StreamsConfig.REPLICATION_FACTOR_CONFIG, kafkaReplicationFactor);
////        //状态存储的目录地址
////        props.put(StreamsConfig.STATE_DIR_CONFIG, kafkaStreamStateDir);
////        //执行流处理的线程数
////        props.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, kafkaStreamThreadsNum);
////        props.put(StreamsConfig.NUM_STANDBY_REPLICAS_CONFIG, kafkaNumStandbyReplicas);
////        //props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG,StreamsConfig.EXACTLY_ONCE);
////        props.put(ProducerConfig.ACKS_CONFIG,String.valueOf(1));
////
////        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG,200 * 1024 * 1024);
////        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,10000);
////        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,10000);
////        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,300);
////        props.put(ProducerConfig.RETRIES_CONFIG,kafkaStreamRetries);
////        props.put(ProducerConfig.BATCH_SIZE_CONFIG,256 *1024);
////        props.put(ProducerConfig.LINGER_MS_CONFIG,300);
////
////        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,300000);
////        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,3000);
////        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
////        props.put(ConsumerConfig.GROUP_ID_CONFIG, applicationId);
////
////        return new StreamsConfig(props);
////    }
//
//}
