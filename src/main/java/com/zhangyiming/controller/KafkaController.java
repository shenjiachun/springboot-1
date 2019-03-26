package com.zhangyiming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    private static final String TPOIC = "zhangyiming-test";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/test1")
    public void test1(){
        for(int i=0;i<3;i++){
            kafkaTemplate.send(TPOIC,"test"+i);
            log.info("product: test"+i);
        }
    }

}