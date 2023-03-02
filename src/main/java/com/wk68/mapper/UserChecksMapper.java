package com.wk68.mapper;

import java.util.List;

import com.wk68.entity.UserChecks;
import com.wk68.util.FenyeUtile;

public interface UserChecksMapper {

	List<UserChecks> getUserChecks(FenyeUtile<UserChecks> fenye);

	Integer getCount(FenyeUtile<UserChecks> fenye);

	Integer addUserChecks(UserChecks uc);

	Integer updateUserChecks(UserChecks uc);

	List<UserChecks> getTimelast(UserChecks uc);

	List<UserChecks> pd(String userId);

	Integer showSignOut(String userId);

	/**
	 * 多条件查询加分也
	 * 
	 * @param fenye
	 * @return
	 */
	Integer getCount1(FenyeUtile<UserChecks> fenye);

	List<UserChecks> getData(FenyeUtile<UserChecks> fenye);

	// 导出
	UserChecks findAllById(String uid);

	List<UserChecks> echarts(String uName, String ucCheckInTime, String ucCheckOutTime);

	// 补签退
	Integer upqiantui(UserChecks u);

	// 导出
	List<UserChecks> findById(String id);

	List<UserChecks> findAll();
}
