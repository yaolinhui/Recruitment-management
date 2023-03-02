package com.wk68.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeToSearch {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateEndA;// 创建时间结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateEndB;// 上门回访时间结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateEndC;// 首次回访时间结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateEndD;// 缴费时间结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateEndE;// 进班时间结束时间

}