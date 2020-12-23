package com.chungfung.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 丰涌
 * @version 1.0
 * @description TODO
 * @date 2020/12/7 14:36
 **/
@Data
@Component
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String dataGroupServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String dataGroupConsumerGroupId;

}