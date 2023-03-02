package com.wk68.config;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 聊天室服务端 标注为端点： @ServerEndpoint ，其中 "/chat-room/{username}" 为访问路径
 */
@ServerEndpoint("/SpringBootWebSocket/{username}")
public class ChatRoomServerEndpoint {
	/**
	 * 存储所有存活的用户 * 我们需要周期性的去检查用户是否还处于活跃状态，不活跃的，移除该用户的 session
	 */
	private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

	/**
	 * 前端一旦启用 WebSocket, 就 会调用 @OnOpen 注解标注的方法
	 * 
	 * @param username 路径参数 *
	 * @param session  会话，每个访问对象都会有一个单独的会话
	 */
	@OnOpen
	public void openSession(@PathParam("username") String username, Session session) {
		livingSessions.put(session.getId(), session);
		sendTextAll("欢迎用户【" + username + "】来到聊天室！");
	}

	/**
	 * 服务端发送消息给前端时调用 *
	 * 
	 * @param username 路径参数 *
	 * @param session  会话，每个访问对象都会有一个单独的会话
	 * @param message  待发送 的消息
	 * 
	 */
	@OnMessage
	public void onMessage(@PathParam("username") String username, Session session, String message) {
		sendTextAll("用户【" + username + "】：" + message);
	}

	/**
	 * * 客户端关闭 WebSocket 连接时，调用标注 @OnClose 的方法 *
	 * 
	 * @param username 路径参数
	 * @param session  会话，每个访问对象都会有一个单独的会话
	 */
	@OnClose
	public void onClose(@PathParam("username") String username, Session session) {
		// 将当前用户移除
		livingSessions.remove(session.getId());
		// 给所有存活的用户发送消息
		sendTextAll("用户【" + username + "】离开聊天室！");
	}

	/**
	 * * 向指定 Session( 用户 ) 发送 message
	 */
	private void sendText(Session session, String message) {
		// 发送消息对象
		RemoteEndpoint.Basic basicRemote = session.getBasicRemote();
		try {
			// 发送消息

			basicRemote.sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * * 遍历所有存活的用户，并发送消息（ PS ：就是广播消息） *
	 */
	private void sendTextAll(String message) {
		Iterator<String> sids = livingSessions.keySet().iterator();
		while (sids.hasNext()) {
			String sid = sids.next();
			Session session = livingSessions.get(sid);
			this.sendText(session, message);
		}
	}
}
