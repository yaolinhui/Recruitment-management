package com.wk68.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wk68.entity.Modules;
import com.wk68.entity.Permission;
import com.wk68.entity.Roles;

@Repository
public interface RoleMapper {

	List<Roles> getAll(@Param("map") Map<String, Object> map);

	Integer getCount(@Param("map") Map<String, Object> map);

	Integer addRole(@Param("r") Roles role);

	Integer updateRole(@Param("r") Roles role);

	Integer deleteRoleByRoleId(Integer roleId);

	Roles getRoleByRoleId(Integer roleId);

	Roles getRoleByRoleName(String roleName);

	List<Integer> getModuleIdsByRoleId(@Param("roleId")Integer roleId);

	List<Integer> getPermissionIdsByRoleId(@Param("roleId")Integer roleId);
	//设置权限
	List<Modules> getAllModule();

	Integer deleteModuleByRoleId(@Param("roleId")Integer roleId);

	Integer addModuleByRoleId(@Param("roleId")Integer roleId, @Param("moduleId")Integer moduleId);

	Integer addPermissionByRoleId(@Param("roleId")Integer roleId, @Param("permissionId")Integer permissionId);

	Integer deletePermissionByRoleId(@Param("roleId")Integer roleId);

	List<Permission> getAllPermission();


}
