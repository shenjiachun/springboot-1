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
public class RibbitMqUtils {

    /**
     * 必须是prototype类型
     * Server(Broker)：接收客户端连接，实现AMQP协议的消息队列和路由功能的进程；
     * Virtual Host：虚拟主机的概念，类似权限控制组，一个Virtual Host里可以有多个Exchange和Queue,权限控制的最小丽都是Virtual Host；
     * Exchange：交换机，接收生产者发送的消息，并根据Routing Key将消息路由到服务器中的队列Queue。
     * ExchangeType：交换机类型决定了路由消息行为，RabbitMQ中主要有三种类型Exchange，分别是fanout、direct、topic；
     * Message Queue：消息队列，用于存储还未被消费者消费的消息；
     * Message：由Header和body组成，Header是由生产者添加的各种属性的集合，包括Message是否被持久化、优先级是多少、由哪个Message Queue接收等；body是真正需要发送的数据内容；
     * BindingKey（RouteKey）：绑定关键字，将一个特定的Exchange和一个特定的Queue绑定起来。
     */



}