package com.wk68.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudent {
	private String studnetId;// 学生编号
	private String userId;// 用户员工id
	private String sname;// 学生姓名
	private Integer sage;// 学生的年龄
	private String sgender;// 学生性别
	private String sphone;// 学生电话
	private String sperstate;// 国籍
	private String saddress;// 家庭地址
	private String ssource;// 来源渠道：学生是通过百度、必应、360等等搜索器了解学校并来到的
	private String ssourceUrl;// “www.bing.com”、“www.baidu.com”等等
	private String ssourceKeyword;// “新乡职业”、“新乡技术学校”等等
	private String sdegree;// 学生学历
	private String sqq;// 学生qq号码
	private String sweixin;// 学生微信号码
	private String sstatus;// 当前状态（还在考虑中，已录入，已进入别的学校 等等
	private String scounselorRemark;// 当前咨询师对这个学生写的备注信息
	private Integer sscore;// 咨询师对学生打分，是否符合招生标准(对学生初步了解，学生什么时候可以报名)
	private String scurriculum;// 学生想报什么课程
	private String sisValia;// 是：继续填写，无效原因不能填写 否：只能填写无效原因，其他信息全部禁止填写
	private String sinvalidCause;// 无效原因
	private String sisCallback;// 是否首次回访
	private String sstandby1;// 备注
	private String scallbackTime;// 首次回访时间
	private String sisVisit;// 是否上门
	private String svisitTime;// 上门时间
	private String shandsel;// 定金
	private String shandselTime;// 定金时间
	private String sisPay;// 是否完成缴费
	private String spayTime;// 缴费时间
	private String spayHandsel;// 缴费金额
	private String sisReturnPremium;// 是否退费
	private String sreturnPremiumCase;// 是否退费
	private String sisReturnPremiumTime;// 退费时间
	private String sisInClass;// 该生是否分配班级
	private String sinClassTime;// 进入班级时间
	// 2020-05-19新增
	private String screateTime;// 创建时间
}
