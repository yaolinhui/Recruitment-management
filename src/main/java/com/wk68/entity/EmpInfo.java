package com.wk68.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpInfo {
	// 消息的来源id
	 
	private String id;
	// 消息接收方的id
	private String toId;
	
	private String username;

	private Integer status;
	// 签名
	private String sign;
	// 头像
	private String avatar;
	// 登陆状态
	private Integer isLogin;

	// 消息内容
	private String content;

	// 消息的来源类型
	private String type;

	// 是否是本人
	private Boolean mine = false;
	
	// 发送消息的时间
	private Long timestamp;

	// 历史消息时间
	private Date historyTime = new Date();
	
	//2020-5-28新增
	//是否已读 0为未读 1为已读
	private Integer isRead;
}
