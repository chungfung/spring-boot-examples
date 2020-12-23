package com.chungfung.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

/**
 * @author 丰涌
 */
@Configuration
@EnableKafkaStreams
public class StreamConsumer {

    @Bean("StreamConsumer")
    public KStream<String, String> heartbeatStream(@Qualifier("myKappConfigStreamBuilder") StreamsBuilder builder){
        KStream<String, String> textLines = builder.stream("first", Consumed.with(Serdes.String(),Serdes.String()));
        textLines.foreach((key,value)->{
            System.out.println("获取的值【myKappConfigStreamBuilder】：" + value);
        });
        return textLines;
    }
}
