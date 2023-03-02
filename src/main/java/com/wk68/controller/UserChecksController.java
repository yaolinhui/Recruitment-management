package com.wk68.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.UserChecks;
import com.wk68.service.UserChecksService;
import com.wk68.util.FenyeUtile;
@RequestMapping("/userchecks")
@RestController
@CrossOrigin
public class UserChecksController {
	
	@Autowired
	private UserChecksService ucs;
	
	@GetMapping
	public FenyeUtile<UserChecks> getUserChecks(UserChecks uc,Integer page){
		FenyeUtile<UserChecks> fenye = new FenyeUtile<UserChecks>();
		fenye.setPage(page);
		fenye.setT(uc);
		return ucs.getUserChecks(fenye);
	}
	
	@RequestMapping("/isLeaveEarly")
	public Map<String, Object> isLeaveEarly(UserChecks uc) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
		Date now = null;
		Date beginTime = null;
		Date endTime = null;
		try {
			now = df.parse(df.format(new Date()));
			beginTime = df.parse("13:00");
			endTime = df.parse("18:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Boolean flag = belongCalendar(now, beginTime, endTime);
		if (flag) {
			map.put("code", 0);
			map.put("msg", "早退！");
			return map;
		}else {
			map.put("code", 1);
			map.put("msg", "没有早退！");
			return map;
		}
	}
	@RequestMapping("/UserCheckssb")
	public Map<String, Object> addUserChecks(UserChecks uc) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
		Date now = null;
		Date beginTime = null;
		Date endTime = null;
		try {
			now = df.parse(df.format(new Date()));
			beginTime = df.parse("09:00");
			endTime = df.parse("13:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Boolean flag = belongCalendar(now, beginTime, endTime);
		System.out.println(flag);
		if (flag) {
			map.put("code", 0);
			map.put("msg", "迟到！");
			return map;
		}else {
			Qiandao(uc);
			map.put("code", 1);
			map.put("msg", "没有迟到！");
			return map;
		}
	}
	
	@RequestMapping("/qanDao")
	public Integer Qiandao(UserChecks uc) {
	    UUID.randomUUID().toString();
	    uc.setUcId(UUID.randomUUID().toString());
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		uc.setUcCheckInTime(dateFormat.format(date));
	    uc.setUcCheckStatue("1");
	    uc.setUserId(uc.getUserId());
	    uc.setUName(uc.getUName());
	    uc.setStandby2(uc.getStandby2());
	    return ucs.addUserChecks(uc);
	}
	
	@RequestMapping("/updateUserChecks")
	public Integer updateUserChecks(UserChecks uc,String userId,String standby2) {
		
		List<UserChecks> ucList = ucs.getTimelast(uc);
		UserChecks u = ucList.get(0);
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		uc.setUcCheckOutTime(dateFormat.format(date));
		uc.setUcCheckStatue("2");
		uc.setUserId(userId);
		uc.setUcId(u.getUcId());
		uc.setStandby2(standby2);
		return ucs.updateUserChecks(uc);
	}
	public static boolean belongCalendar(Date nowTime, Date beginTime,
			Date endTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
 
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
 
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
 
		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/pd")
	public Map<String, Object> pd(String userId){
		return ucs.pd(userId);
	}
	
	@RequestMapping("/showSignOut")
	public Integer showSignOut(String userId) {
		return ucs.showSignOut(userId);
	}
	/**
	 * 显示所有加多条件查询
	 */
	@RequestMapping("/getAll")
	public FenyeUtile<UserChecks> getAll(FenyeUtile<UserChecks> fenye,UserChecks userchecks){
		fenye.setT(userchecks);
		System.out.println(userchecks);
		return ucs.getAll(fenye);
	}

	
	/**
	 * 补签
	 */
	@RequestMapping("/upqiantui")
	public Integer upqiantui(UserChecks u) {
		System.out.println("==================");
		return ucs.upqiantui(u);
	}
}
