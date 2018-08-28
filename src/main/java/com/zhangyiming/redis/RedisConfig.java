package com.zhangyiming.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.*;

@Slf4j
@Configuration
@EnableAutoConfiguration
public class RedisConfig {

//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private Integer port;
//
//    @Value("${spring.redis.database}")
//    private Integer database;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

//    @Value("${spring.redis.password}")
//    private String password;

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    /**
     * @Bean 和 @ConfigurationProperties
     * 该功能在官方文档是没有提到的，我们可以把@ConfigurationProperties和@Bean和在一起使用。
     * 举个例子，我们需要用@Bean配置一个Config对象，Config对象有a，b，c成员变量需要配置，
     * 那么我们只要在yml或properties中定义了a=1,b=2,c=3，
     * 然后通过@ConfigurationProperties就能把值注入进Config对象中
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.jedis.pool")
    public JedisPoolConfig getRedisConfig() {
        return new JedisPoolConfig();
    }

    @Bean
    public RedisClusterConfiguration redisClusterConfiguration(){
        String[] cNodes = clusterNodes.split(",");
        return new RedisClusterConfiguration(Arrays.asList(cNodes));
    }

    @Bean
//    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setUsePool(true);
//        JedisPoolConfig config = getRedisConfig();
//        factory.setPoolConfig(config);
//        return factory;

        RedisClusterConfiguration redisClusterConfiguration = redisClusterConfiguration();
        redisClusterConfiguration.setPassword(RedisPassword.of(""));

        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        //  connection timeout
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));

        return new JedisConnectionFactory(redisClusterConfiguration, jedisClientConfiguration.build());
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        log.info(factory.getHostName()+","+factory.getDatabase());
        log.info(factory.getPassword());
        log.info(String.valueOf(factory.getPoolConfig().getMaxIdle()));
        return new StringRedisTemplate(getConnectionFactory());
    }

}