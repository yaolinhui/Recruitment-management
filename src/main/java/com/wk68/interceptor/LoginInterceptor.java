package com.wk68.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wk68.entity.User;
import com.wk68.util.TokenUtil;

/**
 * 验证Token 登录已经被前端放行 可以直接访问LoginController
 * 
 * 除了登录都会被默认进行验证Token
 * 
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return true;
//		// 如果不是映射到方法直接通过
//
//		if (!(handler instanceof HandlerMethod)) {
//			return true;
//		}
//		response.setCharacterEncoding("utf-8");
//		String tokenStr = request.getParameter("token");
//		if (tokenStr != null && tokenStr != "") {
//			try {
//				User u = TokenUtil.unsign(tokenStr, User.class);
//				if (u != null) {
//					return true;
//				}
//			} catch (Exception e) {
//
//			}
//		}
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json; charset=utf-8");
//		JSONObject json = new JSONObject();
//		json.put("success", "false");
//		json.put("msg", "认证失败");
//		json.put("code", "500");
//		response.getWriter().append(json.toString());
//		System.out.println("认证失败");
//		return false;

	}

}
