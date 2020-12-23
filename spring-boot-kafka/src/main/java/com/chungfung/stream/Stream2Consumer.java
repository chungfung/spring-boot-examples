package com.chungfung.stream;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liubo
 */
@Configuration
@EnableKafkaStreams
public class Stream2Consumer {


    @Bean
    public KStream<String, String> heartbeatStream(StreamsBuilder builder){
        KStream<String, String> textLines = builder.stream("first");
        //根据kafka传来的KeyValue（文件名:文件内容）转换为多条KeyValue（流水号:流水对象json字符串）
                        textLines.flatMap((key, value) -> {
            //根据文件内容获取BeanList
            if (value.isEmpty()) {
                return Collections.emptyList();
            }
            List<KeyValue<String, String>> result = new ArrayList<>();
                            System.out.println("读取值：" + value);

            return result;
        });
        return textLines;
    }
}
