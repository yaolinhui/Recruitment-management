package com.wk68.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follows {
	// @JsonProperty解决后台传到前台数据实体类首、次字母大写变小写
	@JsonProperty("fId")
	private Integer fId;// 回访记录编号
	@JsonProperty("studentId")
	private String studentId;// 跟踪学生
	@JsonProperty("sName")
	private String sName;// 跟踪学生姓名
	@JsonProperty("userId")
	private String userId;// UUID 访问者id
	@JsonProperty("fTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fTime;// 跟踪时间
	@JsonProperty("fContent")
	private String fContent;// 沟通内容
	@JsonProperty("fNextTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fNextTime;// 下次跟踪时间
	@JsonProperty("fFeedback")
	private String fFeedback;// 跟踪反馈信息
	@JsonProperty("fType")
	private String fType;// '老客户' 老客户、新客户、休眠客户
	@JsonProperty("fWay")
	private String fWay;// 微信、电话等
	@JsonProperty("fStatus")
	private String fStatus;// 譬如：考虑中、准备报名
	// 2020-05-20
	@JsonProperty("user")
	private User user;
	// 2020-05-21
	@JsonProperty("fShow")
	private String fShow;// 是否展示该条数据（回收站） true false
	// 2020-05-21
	@JsonProperty("sPhone")
	private String sPhone;// 学生手机号 用于学生跟踪访问的唯一标识

}
