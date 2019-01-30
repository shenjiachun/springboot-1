package com.zhangyiming.config;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Bean
    public Channel init() {
        return ManagedChannelBuilder.forAddress("127.0.0.1", 9898)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build();
    }

}