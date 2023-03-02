package com.wk68.service;

import java.util.List;
import java.util.Map;

import com.wk68.entity.Permission;

public interface PermissionService {

	
	List<Object> findPermissionTree();

	Map<String, Object> getPermissionAll();

	Integer updatePermissionByName(Permission permission);

	Integer updatePermissionByValue(Permission permission);

	Integer updatePermission(Permission permission);

	Integer deleteBypid(Integer pId);

	Integer addPermission(Permission permission);

	Map<String, Object> getAllPermissionNameByUserId(String userId);

	Map<String, Object> getAllPermissionName();

}
