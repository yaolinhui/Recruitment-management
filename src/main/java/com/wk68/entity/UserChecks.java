package com.wk68.entity;


import com.wk68.util.PoiHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserChecks {
	
	/*
	 * private String ucId;// 用户打卡编号 private String userId;// 关联用户编号 private String
	 * uName;// 用户姓名 private String ucCheckStatue;//签到状态 private String
	 * ucCheckInTime;// 打卡进入时间 private String ucCheckOutTime;// 打卡离开时间 private
	 * String standby2;
	 */
	@PoiHandler(excelHeader="用户打卡编号")
	private String ucId;// 用户打卡编号
	
	@PoiHandler(excelHeader="关联用户编号")
	private String userId;// 关联用户编号
	
	@PoiHandler(excelHeader="用户姓名")
	private String uName;// 用户姓名
	
	@PoiHandler(excelHeader="签到状态")
	private String ucCheckStatue;//签到状态
	
	@PoiHandler(excelHeader="打卡进入时间")
	private String ucCheckInTime;// 打卡进入时间
	
	@PoiHandler(excelHeader="打卡离开时间")
	private String ucCheckOutTime;// 打卡离开时间
	
	@PoiHandler(excelHeader="备用")
	private String standby2;
}
