package com.wk68.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.wk68.entity.UserChecks;
import com.wk68.util.FenyeUtile;

public interface UserChecksService {

	FenyeUtile<UserChecks> getUserChecks(FenyeUtile<UserChecks> fenye);

	Integer addUserChecks(UserChecks uc);

	Integer updateUserChecks(UserChecks uc);

	List<UserChecks> getTimelast(UserChecks uc);

	Map<String, Object> pd(String userId);

	Integer showSignOut(String userId);

	// 多条件查询加分页
	FenyeUtile<UserChecks> getAll(FenyeUtile<UserChecks> fenye);


	// 补签退
	Integer upqiantui(UserChecks u);

	// 导出
	List<UserChecks> findById(String id);

	// 导出
	List<UserChecks> findAll();
}
