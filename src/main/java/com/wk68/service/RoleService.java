package com.wk68.service;

import java.util.List;
import java.util.Map;

import com.wk68.entity.Roles;

public interface RoleService {

	Map<String, Object> getAll(Map<String, Object> map);

	Integer addRole(Roles role);

	Integer updateRole(Roles role);

	Integer deleteRoleByRoleId(Integer roleId);

	Roles getRoleByRoleId(Integer roleId);

	List<Object> findTree();

	Integer setRoleModule(Integer roleId, String moduleIds);

	Integer setRolePermission(Integer roleId, String permissionIds);

	List<Object> findPermissionTree();
	
	Integer verifyUniqueRole(String roleName, Integer roleId);

	Map<String, Object> getAllUserByroleId(Integer roleId);

}
