package com.wk68.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.Permission;
import com.wk68.mapper.PermissionMapper;
import com.wk68.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	private PermissionMapper pm;
	
	
	@Override
	public List<Object> findPermissionTree() {
		List<Object> list = new ArrayList<Object>();
		List<Permission> findAll = pm.findAll();
		for (int i = 0; i < findAll.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (findAll.get(i).getPParent() == 0) {
				map.put("title", findAll.get(i).getPModuleName());
				map.put("id", findAll.get(i).getPId());
				list.add(map);
			}
		}
		return list;
	}
	@Override
	public Map<String, Object> getPermissionAll() {
		Map<String, Object> map = new HashMap<>();
		// data
		List<Permission> data =	pm.findAll();
		// count 数据总条数（long返回类型）
		Integer count = pm.getCount();
		if (data.size() > 0) {
			map.put("code", 0);
			map.put("data", data);
			map.put("count", count);
		} else {
			map.put("code", 1);
			map.put("msg", "没有数据");
		}
		return map;
	}

	
	public Integer updatePermissionByName(Permission permission) {
		return pm.updatePermissionByName(permission) != null ? 1 : 0;
	}
	
	
	public Integer updatePermissionByValue(Permission permission) {
		return pm.updatePermissionByName(permission) != null ? 1 : 0;
	}
	
	public Integer updatePermission(Permission permission) {
		return pm.updatePermission(permission);
	}
	
	public Integer deleteBypid(Integer pId) {
		return pm.deleteBypid(pId);
	}
	
	public Integer addPermission(Permission permission) {
		return pm.addPermission(permission);
	}

	
	public Map<String, Object> getAllPermissionNameByUserId(String userId) {
		Map<String, Object> map = new HashMap<>();
		List<Permission> permission = pm.getAllPermissionNameByUserId(userId);
		if (permission.size() != 0) {
			map.put("code", 1);
			map.put("data", permission);
		}else {
			map.put("code", 0);
			map.put("msg", "无数据");
		}
		return map;
	}
	
	
	public Map<String, Object> getAllPermissionName() {
		Map<String, Object> map = new HashMap<>();
		List<Permission> permission = pm.getAllPermissionName();
		if (permission.size() != 0) {
			map.put("code", 1);
			map.put("data", permission);
		}else {
			map.put("code", 0);
			map.put("msg", "无数据");
		}
		return map;
	}
	
}
