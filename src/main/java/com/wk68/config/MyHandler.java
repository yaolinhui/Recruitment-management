package com.wk68.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wk68.entity.EmpInfo;
import com.wk68.entity.User;
import com.wk68.service.ChatService;

//消息处理类
@Component
public class MyHandler extends TextWebSocketHandler {
	@Autowired
	private ChatService cs;
	// 在线用户列表
	public static final Map<String, WebSocketSession> userSocketSessionMap = new HashMap<String, WebSocketSession>();
	
	String newId = "";
	// 用户连接成功 就被调用
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 获取传来的登录用户的id
		System.out.println(session);
		newId = session.getUri().toString().split("[=\\&]")[1];
		String id =  (String) session.getAttributes().get("myid");
		System.out.println(newId);
		//int id = Integer.parseInt(idstr);
		System.err.println("用户连接成功");
		// 保存对应的WebSocketSession
		userSocketSessionMap.put(id, session);
	}

	// 消息处理方法
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			EmpInfo friendInfo = objectMapper.readValue(message.getPayload(), EmpInfo.class);
			// session.sendMessage(message);//发送给当前人
			if (friendInfo.getType().equals("friend")) {
				sendMessageToUser(message, friendInfo);
			} else if (friendInfo.getType().equals("group")) {
				sendMessagesToUsers(message, friendInfo);// 给所有的用户发送消息
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 给所有的用户发送消息
	 */
	public void sendMessagesToUsers(TextMessage message, EmpInfo friendInfo) {

		Set<String> clientIds = userSocketSessionMap.keySet();
		WebSocketSession session = null;
		for (String clientId : clientIds) {
			session = userSocketSessionMap.get(clientId);
			System.out.println(clientId);
			try {
				if (session.isOpen() && !friendInfo.getId().equals(clientId)) {
					session.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 给所有的用户发送消息
	 */
	public void sendMessageToUser(TextMessage message, EmpInfo friendInfo) throws IOException {

		Set<String> clientIds = userSocketSessionMap.keySet();
		WebSocketSession session = null;
		for (String clientId : clientIds) {
			session = userSocketSessionMap.get(clientId);
			System.out.println(session);
			try {
				if (session.isOpen() && friendInfo.getToId().equals(clientId)) {

					System.out.println("回复消息");
					session.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 用户退出后的处理，退出之后，要将用户信息从websocket的session中remove掉，这样用户就处于离线状态了，也不会占用系统资源
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
		try {
			if (session.isOpen()) {
				session.close();
			}
			userSocketSessionMap.remove(session.getId());
			System.out.println("退出系统");
			if (newId != null) {
				User user = new User();
				user.setUStatus("offline");
				user.setUserId(newId);
				System.out.println(newId);
				cs.setUserOnlineOrOffline(user);
			}
		} catch (Exception e) {
			System.out.println("用户非正常关闭");
		}

	}
}
