package com.wk68;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.wk68.config.ChatRoomServerEndpoint;

/**
 * 
 * 启动类
 *
 */
@SpringBootApplication
@MapperScan("com.wk68.mapper")
@EnableWebSocket
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	/**
	 * * 注册 ServerEndpointExporter Bean 对象（因为 Springboot 没有自动注册，所以得手动注册）
	 * 
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	/**
	 * * 注册 端点对象
	 * 
	 */
	@Bean
	public ChatRoomServerEndpoint chatRoomServerEndpoint() {
		return new ChatRoomServerEndpoint();
	}

}
