package com.wk68.service;

import java.util.Map;
import java.util.Set;

import com.wk68.entity.Modules;
import com.wk68.entity.User;

public interface UserService {

	

	Map<String, Object> getAllPwd(String uLoginName, String uPassword);

	Map<String, Object> editPwd(String uLoginName, String newPwd);

	Integer setHeadPortrait(User user);
	
	
	
	Integer addUser(User user);
	
	Integer updateUser(User user);

	Integer deleteByUserId(String userId);
	
	User getByUserId(String userId);

	Set<Integer> getRoleIdsByUserId(String userId);

	Set<Modules> getModuleByRoleId(Integer roleId);

	Map<String, Object> getAll(Map<String, Object> map);

	Integer resetPassword(User user);

	Integer addUserRole(String userId, Integer roleId);

	Integer removeUserRole(String userId, Integer roleId);

	Integer invertULockOut(User user);
	
	boolean verifyUniqueField(User user);

	Integer updateUserInfo(User user);

	Integer updateRemarkById(User user);

	boolean invertUAutoAllot(User user);	
}
