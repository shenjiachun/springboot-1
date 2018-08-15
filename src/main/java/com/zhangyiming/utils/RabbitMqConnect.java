package com.zhangyiming.utils;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author 张壹鸣
 * @Description: ${todo}
 * @date 2018\5\19 001914:14
 */
@Configuration
public class RabbitMqConnect {

    public static final String EXCHANGE   = "spring-boot-exchange";
    public static final String ROUTINGKEY = "spring-boot-routingKey";

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("localhost:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        //必须要设置
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     * 必须是prototype类型
     */
    @Bean(name = "rabbitTemplate")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }
}