package com.wk68.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatInfo {

	// 响应码
	private Integer code;

	// 响应消息
	private String msg;

	// 数据集合：接收mine（我的信息），friend（好友的信息）
	private Map<String, Object> data = new HashMap<String, Object>();

}
