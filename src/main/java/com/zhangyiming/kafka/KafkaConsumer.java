package com.zhangyiming.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {

    private static final String TPOIC = "zhangyiming-test";

    @KafkaListener(topics = {TPOIC}, containerFactory = "batchFactory")
    public void listen (List<ConsumerRecord<String, String>> records) {
        records.forEach(r -> log.info("consumer: topic = {}, offset = {}, value = {} ", r.topic(), r.offset(), r.value()));
    }

}