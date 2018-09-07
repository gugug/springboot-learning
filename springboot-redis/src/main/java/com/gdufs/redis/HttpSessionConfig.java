//package com.gdufs.redis;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
///**
// * @author gucailiang
// * @date 2018/9/7
// */
//@EnableRedisHttpSession
//public class HttpSessionConfig {
//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
//        connectionFactory.setPort(6379);
//        connectionFactory.setHostName("localhost");
//        return connectionFactory;
//    }
//}
