package com.wk68.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatUser {
	
	// 聊天室用户id
	private String id;
	// 聊天室用户真实姓名
	private String username;
	// 聊天室用户状态
	private String status;
	// 签名
	private String sign;
	// 头像
	private String avatar;
	// 对方id
	private String toId;
	
	private String type;
	
	private Integer groupid;
	

}
