package com.wk68.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket 服务配置类
 * 
 * @author 姚林辉
 *
 */

//单列模式bean
@Configuration

//启动WebSocket服务器
@EnableWebSocket
public class SpringBootWebSocketConfigurer implements WebMvcConfigurer, WebSocketConfigurer {

	@Autowired
	private SpringBootWebSocketHandler handler;

	@Autowired
	private SpringBootHandshakeInterceptor handshakeInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		String[] allowsOrigins = { "*" };// 允许连接的域 , 只能以 http 或 https 开头
		registry.addHandler(handler, "/SpringBootWebSocket/{username}").addInterceptors(handshakeInterceptor).setAllowedOrigins(allowsOrigins);  
		
	}

}
