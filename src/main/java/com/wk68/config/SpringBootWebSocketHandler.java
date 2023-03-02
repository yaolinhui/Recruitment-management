package com.wk68.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * WebSocket服务处理类
 * 
 * @author 姚林辉
 *
 */
@Component
public class SpringBootWebSocketHandler implements WebSocketHandler {
	// 存储所有客户端的会话 WebSocketSession,key 使用客户端的唯一标识方便存取

	private static Map<String, WebSocketSession> allWebSocketSession = new HashMap<String, WebSocketSession>();

	/**
	 * 1. 客户端成功建立连接时触发
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("客户端成功建立连接-->" + session.getId());
		// 在 ws 服务类中任何位置都可以使用以下取值

		System.out.println("WebSocketSession.getAttributes().get(\"param\")" + session.getAttributes().get("param"));

		System.out.println("WebSocketSession.getAttributes().get(\"user\")" + session.getAttributes().get("user"));

		System.out.println("WebSocketSession.getAttributes().get(\"token\")" + session.getAttributes().get("token"));

		// 存储所有客户端的 WebSocketSession
		allWebSocketSession.put((String) session.getAttributes().get("param"), session);
	}

	/**
	 * 2. 接收客户端数据时触发
	 * 
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

		System.out.println("接收客户端数据=>" + message.getPayload().toString());
		// 给客户端回一句话意思意思 , 随便给客户端发数据
		this.send(session, "&&&&&&服务器回复的&&&&&&" + message.getPayload().toString());

	}

	/**
	 * 3.通信异常时触发
	 */
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("通信异常=>" + session.getId());

	}

	/**
	 * 4. 客户端关闭连接时触发
	 * 
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("客户端关闭连接=>" + session.getId());
		
		// 移除通行关闭的客户端
		allWebSocketSession.remove((String) session.getAttributes().get("param"));
	}

	/**
	 * 是否支持分段传输
	 * 
	 */
	public boolean supportsPartialMessages() {

		// 一次传输完毕
		return false;
	}

	/**
	 * 5. 服务器主动发送数据
	 * 
	 * @param webSocketSession
	 * @param msg
	 */
	private void send(WebSocketSession webSocketSession, String msg) {
		try {
			webSocketSession.sendMessage(new TextMessage(msg));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 6. 服务器主动关闭通信
	 * 
	 * @param webSocketSession
	 * @param msg
	 */
	public void close(WebSocketSession webSocketSession, String msg) {
		try {
			webSocketSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
