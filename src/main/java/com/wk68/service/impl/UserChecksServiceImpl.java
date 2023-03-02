package com.wk68.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wk68.entity.UserChecks;
import com.wk68.mapper.UserChecksMapper;
import com.wk68.service.UserChecksService;
import com.wk68.util.FenyeUtile;

@Service
public class UserChecksServiceImpl implements UserChecksService {
	@Autowired
	private UserChecksMapper ucm;
	
	@Override
	public FenyeUtile<UserChecks> getUserChecks(FenyeUtile<UserChecks> fenye) {
		List<UserChecks> sList = ucm.getUserChecks(fenye);
		Integer count = ucm.getCount(fenye);
		fenye.setData(sList);
		fenye.setCount(count);
		return fenye;
	}

	@Override
	public Integer addUserChecks(UserChecks uc) {
		// TODO Auto-generated method stub
		Integer a =  ucm.addUserChecks(uc);
		System.out.println(a);
		return a;
	}

	@Override
	public Integer updateUserChecks(UserChecks uc) {
		// TODO Auto-generated method stub
		return ucm.updateUserChecks(uc);
	}

	@Override
	public List<UserChecks> getTimelast(UserChecks uc) {
		// TODO Auto-generated method stub
		return ucm.getTimelast(uc);
	}

	@Override
	public Map<String, Object> pd(String userId) {
		HashMap<String, Object> map = new HashMap<>();
		List<UserChecks> userChecks = ucm.pd(userId);
		if (userChecks.size() == 0) {
			map.put("code", 0);
			map.put("msg", "当天没有打卡");
			return map;
		}
		if(userChecks.get(0).getUcCheckStatue().equals("1")) {
			map.put("code", 1);
			map.put("msg", "签到了还未签退！");
			return map;
		}
		if(userChecks.get(0).getUcCheckStatue().equals("2")) {
			map.put("code", 2);
			map.put("msg", "签到了也签退！");
			return map;
		}
		return map;
	}

	@Override
	public Integer showSignOut(String userId) {
		// TODO Auto-generated method stub
		return ucm.showSignOut(userId);
	}
	
	/**
	 * 多条件查询加分页
	 */
	@Override
	public FenyeUtile<UserChecks> getAll(FenyeUtile<UserChecks> fenye) {
        Integer count = ucm.getCount1(fenye);
        List<UserChecks> data = ucm.getData(fenye);     
        if(data.size() > 0) {
        	fenye.setCount(count);
        	fenye.setData(data);
        }else {
        	fenye.setCode(0);
        	fenye.setMsg("未知错误查找失败");
        }
		return fenye;
	}
    
	//补签退
	@Override
	public Integer upqiantui(UserChecks u) {
		u.setUcCheckStatue("2");
		return ucm.upqiantui(u);
	}
	
	
	//导出
	  @Override
	  public List<UserChecks> findById(String id) {
	        
	    return ucm.findById(id);
	  }
	    //导出
	  @Override
	  public List<UserChecks> findAll() {
	    
	    return ucm.findAll();
	  }
}
