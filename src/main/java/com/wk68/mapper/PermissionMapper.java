package com.wk68.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wk68.entity.Permission;

@Repository
public interface PermissionMapper {

	List<Permission> findAll();
	
	Integer getCount();

	Permission updatePermissionByName(Permission permission);

	Integer updatePermission(Permission permission);

	Integer deleteBypid(Integer pId);

	Integer addPermission(Permission permission);

	List<Permission> getAllPermissionNameByUserId(String userId);

	List<Permission> getAllPermissionName();




}
