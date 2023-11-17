package com.observer.realtimestockchart;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   // 웹 소켓 메시지 브로커 : 클라이언트 간 메시지 교환 조정 및 중개
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // 메시지 브로커 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    // Stomp(웹 소켓 메시징 프로토콜) 엔드포인트 등록
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // "/ws" 엔드포인트에 SockJS(실시간 통신 라이브러리)를 사용하여 WebSocket 등록
        registry.addEndpoint("/ws").withSockJS();
    }
}
