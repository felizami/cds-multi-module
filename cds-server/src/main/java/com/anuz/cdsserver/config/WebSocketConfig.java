package com.anuz.cdsserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-websocket").setAllowedOrigins("http://localhost:8383");
//            .setStreamBytesLimit(512 * 1024)
//            .setHttpMessageCacheSize(1000)
//            .setDisconnectDelay(30 * 1000);;
    }

//    @Override
//    protected void configureStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws-websocket").setAllowedOrigins("http://localhost:8383");
//
//    }

}