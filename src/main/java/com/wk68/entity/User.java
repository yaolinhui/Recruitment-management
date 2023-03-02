package com.wk68.entity;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String userId;// 32位唯一UUID
	private String uLoginName;// 登录用户名
	private String uName;// 用户真实姓名
	private String uPassword;// MD5加密
	private Integer uLockOut;// 0锁定，1未锁定
	private Date uLastLoginTime;// 最后登录时间
	private Date uCreateTime;// 账户创建时间
	private Integer uPsdWrong;// 密码错误次数
	private Date uLockTime;// 账号锁定时间
	private String uProtectEmail;// 密保邮箱
	private String uProtectPhone;// 密保手机号
	private String uIdNumber;// 身份证号码
	private String uGender;// 性别
	private String uHeadPortrait;// 头像
	private String uRemark;// 备注
	

	// 用户实体类
	private Set<Roles> roleSet;

	// 2020-05-27 分量状态（是否开启自动分配）"true"开启 "false"默认不开启(针对于咨询师)
	private String uAutoAllot;
	
	// 2020-5-28 用户状态 online：代表在线 offline：隐藏
	private String uStatus;
	
	// 2020-6-2 用户备注
	private String uStandby2;
}
