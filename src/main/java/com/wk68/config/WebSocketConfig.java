package com.wk68.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	/**
	 * 报错：WebSocket handshake Unexpected response code 403 
	 * 原因：从Spring Framework 4.1.5开始，WebSocket和SockJS的默认行为是仅接受相同的原始请求。也可以允许所有或指定的来源列表。
	 * 解决：在WebSocketConfig中注册时可以设置允许访问的链接. setAllowedOrigins(String[]
	 * domains),允许指定的域名或IP(含端口号)建立长连接，domains允许的域名访问。
	 * 如果不限时使用"*"号，如果指定了域名，则必须要以http或https开头。
	 * 示例：setAllowedOrigins("http://127.0.0.1:8080")或者添加setAllowedOrigins("*")
	 */

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		registry.addHandler(myHandler(), "/myHandler").setAllowedOrigins("*");
	}

	@Bean
	public WebSocketHandler myHandler() {
		return new MyHandler();
	}
}
