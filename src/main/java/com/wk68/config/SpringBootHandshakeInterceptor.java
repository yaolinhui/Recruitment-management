package com.wk68.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * 通信握手拦截器 在连接前和成功连接后做一些额外的功能
 * 
 * @author 姚林辉 握手： 通过浏览器发送请求，然后服务器再进行回应
 */
@Component
public class SpringBootHandshakeInterceptor implements HandshakeInterceptor {

	/**
	 * 握手之前
	 */
	public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse response,
			WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) serverHttpRequest;

		// 得到Http协议的请求对象
		HttpServletRequest request = servletServerHttpRequest.getServletRequest();
		HttpSession session = request.getSession(true);
		System.out.println("----握手之前----");
		System.out.println("握手拦截器request.getParameter(\"param\")==>" + request.getParameter("param"));
		System.out.println("握手拦截器request.getParameter(\"token\")==>" + request.getParameter("token"));
		System.out.println("握手拦截器request.getParameter(\"user\")==>" + session.getAttribute("user"));

		// 数据中转，可以把Http协议的会话对象数据中转到ws协议的会话对象中
		attributes.put("param", request.getParameter("param"));

		// 非前后端分离架构 : 把 HttpSession 中的数据中转到 WebSocketSession 中
		if (session.getAttribute("user") != null) {

			attributes.put("user", session.getAttribute("user"));

			// 如果是前后端分离架构 : 把 Http 协议中的 token 令牌中转到 ws 协议的 WebSocketSession 中
			attributes.put("token", request.getAttribute("token"));

			return true;

		}

		return true;
	}

	/**
	 * 握手之后
	 */
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		System.out.println("-----握手之后-----");
	}

}
