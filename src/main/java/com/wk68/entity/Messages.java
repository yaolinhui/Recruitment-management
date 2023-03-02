package com.wk68.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Messages {
	private Integer mId;//ID自增主键
	private String userId;//UUID (发送者就是用户)
	private String ucName;//发送者姓名（用户姓名）
	private Integer studentId;//接收者ID（学生ID自增）
	private String sName;//接收者姓名（学生姓名可以一样）
	private String mContent;//聊天室内两个人的对话
	private Date mCreateTime;//发送时间
	private String mRead;//对方是否已读信息（0，已读  1，未读）
}
