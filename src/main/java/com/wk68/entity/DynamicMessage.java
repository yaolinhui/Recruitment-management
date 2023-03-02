package com.wk68.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicMessage {
	private Integer dmId;// 动态信息的编号id
	private String userId;// 推动信息的员工编号(关联User表的uid、推送人|网络咨询师)
	private String studentId;// 推送目标关联Studnet表的sid
	private String sName;// 学生姓名(哪个学生的信息)
	private String dmRead;// 是否已读（判断）
	private Date dmCreateTime;// 发送时间
	private String dmMessage;// 推送信息
	// 2020-02-24
	private String userId2;// 接收信息的员工编号（即被推送人|咨询师）

	// 2020-05-25
	private User user;// 存储网络咨询师信息
}
