package com.anuz.cdsserver.config;//package com.anuz.tddspringboot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//@EnableRedisHttpSession
//public class RedisConfig {
//
//
//
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//        return new JedisConnectionFactory();
//    }
//    //This configuration is responsible for creating a Servlet Filter that replaces
//    // the HttpSession implementation with an implementation backed by Spring Session
//
//    @Bean
//    public LettuceConnectionFactory connectionFactory() {
//        return new LettuceConnectionFactory();
//    }
//}
//
//
//
////https://docs.spring.io/spring-session/docs/current/reference/html5/guides/httpsession.html