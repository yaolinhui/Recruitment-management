package com.wk68.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.wk68.util.PoiHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	/*
	 * private String studnetId;// 学生编号 private String userId;// 用户员工id private
	 * String sName;// 学生姓名 private Integer sAge;// 学生的年龄 private String sGender;//
	 * 学生性别 private String sPhone;// 学生电话 private String sPerstate;// 国籍 private
	 * String sAddress;// 家庭地址 private String sSource;//
	 * 来源渠道：学生是通过百度、必应、360等等搜索器了解学校并来到的 private String sSourceUrl;//
	 * “www.bing.com”、“www.baidu.com”等等 private String sSourceKeyword;//
	 * “新乡职业”、“新乡技术学校”等等 private String sDegree;// 学生学历 private String sQq;// 学生qq号码
	 * private String sWeixin;// 学生微信号码 private String sStatus;//
	 * 当前状态（还在考虑中，已录入，已进入别的学校 等等 private String sCounselorRemark;// 当前咨询师对这个学生写的备注信息
	 * private Integer sScore;// 咨询师对学生打分，是否符合招生标准(对学生初步了解，学生什么时候可以报名) private
	 * String sCurriculum;// 学生想报什么课程 private String sIsValia;// 是：继续填写，无效原因不能填写
	 * 否：只能填写无效原因，其他信息全部禁止填写 private String sInvalidCause;// 无效原因 private String
	 * sIsCallback;// 是否首次回访 private String sStandby1;// 备注
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") private Date
	 * sCallbackTime;// 首次回访时间 private String sIsVisit;// 是否上门
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private Date sVisitTime;// 上门时间
	 * private BigDecimal sHandsel;// 定金
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private String sHandselTime;// 定金时间
	 * private String sIsPay;// 是否完成缴费
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private Date sPayTime;// 缴费时间 private
	 * BigDecimal sPayHandsel;// 缴费金额 private String sIsReturnPremium;// 是否退费
	 * private String sReturnPremiumCase;// 是否退费
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private Date sIsReturnPremiumTime;//
	 * 退费时间 private String sIsInClass;// 该生是否分配班级
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private Date sInClassTime;// 进入班级时间
	 * // 2020-05-19新增
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private Date sCreateTime;// 创建时间
	 * private User user;//网络咨询师
	 * 
	 * //2020-05-24 private String userId2;// 咨询师的员工id private String sAllot;//
	 * 是否分配咨询师 true已分配 false未分配 private User user2;// 存储咨询师信息
	 */	
	@PoiHandler(excelHeader="学生编号")
	private String studnetId;// 学生编号
	
	@PoiHandler(excelHeader="用户员工id")
	private String userId;// 用户员工id
	
	@PoiHandler(excelHeader="学生姓名")
	private String sName;// 学生姓名
	
	@PoiHandler(excelHeader="学生的年龄")
	private Integer sAge;// 学生的年龄
	
	@PoiHandler(excelHeader="学生性别")
	private String sGender;// 学生性别
	
	@PoiHandler(excelHeader="学生电话")
	private String sPhone;// 学生电话
	
	@PoiHandler(excelHeader="国籍")
	private String sPerstate;// 国籍
	
	@PoiHandler(excelHeader="家庭地址")
	private String sAddress;// 家庭地址
	
	@PoiHandler(excelHeader="来源渠道")
	private String sSource;// 来源渠道：学生是通过百度、必应、360等等搜索器了解学校并来到的
	
	@PoiHandler(excelHeader="网址")
	private String sSourceUrl;// “www.bing.com”、“www.baidu.com”等等
	
	@PoiHandler(excelHeader="学校名称")
	private String sSourceKeyword;// “新乡职业”、“新乡技术学校”等等
	
	@PoiHandler(excelHeader="学生学历")
	private String sDegree;// 学生学历
	
	@PoiHandler(excelHeader="学生qq号码")
	private String sQq;// 学生qq号码
	
	@PoiHandler(excelHeader="学生微信号码")
	private String sWeixin;// 学生微信号码
	
	@PoiHandler(excelHeader="当前状态")
	private String sStatus;// 当前状态（还在考虑中，已录入，已进入别的学校 等等
	
	@PoiHandler(excelHeader="学生的备注")
	private String sCounselorRemark;// 当前咨询师对这个学生写的备注信息
	
	@PoiHandler(excelHeader="咨询师对学生打分")
	private Integer sScore;// 咨询师对学生打分，是否符合招生标准(对学生初步了解，学生什么时候可以报名)
	
	@PoiHandler(excelHeader="学生想报什么课程")
	private String sCurriculum;// 学生想报什么课程
	
	@PoiHandler(excelHeader="是否继续填写")
	private String sIsValia;// 是：继续填写，无效原因不能填写 否：只能填写无效原因，其他信息全部禁止填写
	
	@PoiHandler(excelHeader="无效原因")
	private String sInvalidCause;// 无效原因
	
	@PoiHandler(excelHeader="是否首次回访")
	private String sIsCallback;// 是否首次回访
	
	@PoiHandler(excelHeader="备注")
	private String sStandby1;// 备注
	
	@PoiHandler(excelHeader="首次回访时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sCallbackTime;// 首次回访时间
	
	@PoiHandler(excelHeader="是否上门")
	private String sIsVisit;// 是否上门
	
	@PoiHandler(excelHeader="上门时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sVisitTime;// 上门时间
	
	@PoiHandler(excelHeader="定金")
	private BigDecimal sHandsel;// 定金
	
	@PoiHandler(excelHeader="定金时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String sHandselTime;// 定金时间
	
	@PoiHandler(excelHeader="是否完成缴费")
	private String sIsPay;// 是否完成缴费
	
	@PoiHandler(excelHeader="缴费时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sPayTime;// 缴费时间
	
	@PoiHandler(excelHeader="缴费金额")
	private BigDecimal sPayHandsel;// 缴费金额
	
	@PoiHandler(excelHeader="是否退费")
	private String sIsReturnPremium;// 是否退费
	
	@PoiHandler(excelHeader="是否退费")
	private String sReturnPremiumCase;// 是否退费
	
	@PoiHandler(excelHeader="退费时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sIsReturnPremiumTime;// 退费时间
	
	@PoiHandler(excelHeader="否分配班级")
	private String sIsInClass;// 该生是否分配班级
	
	@PoiHandler(excelHeader="进入班级时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sInClassTime;// 进入班级时间
	// 2020-05-19新增
	@PoiHandler(excelHeader="创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sCreateTime;// 创建时间
	
	@PoiHandler(excelHeader="网络咨询师")
	private User user;//网络咨询师

	//2020-05-24
	@PoiHandler(excelHeader="咨询师的员工id")
	private String userId2;// 咨询师的员工id
	
	@PoiHandler(excelHeader="是否分配咨询师")
	private String sAllot;// 是否分配咨询师 true已分配 false未分配
	
	@PoiHandler(excelHeader="存储咨询师信息")
	private User user2;// 存储咨询师信息
}
