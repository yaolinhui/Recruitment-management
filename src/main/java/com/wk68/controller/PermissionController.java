package com.wk68.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.Permission;
import com.wk68.service.PermissionService;

@RequestMapping("/permission")
@CrossOrigin
@RestController
public class PermissionController {

	@Autowired
	private PermissionService ps;

	@RequestMapping("/getAll")
	public List<Object> getAll() {
		return ps.findPermissionTree();
	}

	@RequestMapping("/getPermissionAll")
	public Map<String, Object> getPermissionAll() {
		return ps.getPermissionAll();
	}

	@RequestMapping("/updatePermission")
	public Integer updatePermission(Permission permission) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		permission.setPUpdateTime(dateString);
		return ps.updatePermission(permission);
	}

	@RequestMapping("/updatePermissionByName")
	public Integer updatePermissionByName(Permission permission) {
		return ps.updatePermissionByName(permission);
	}

	@RequestMapping("/updatePermissionByValue")
	public Integer updatePermissionByValue(Permission permission) {
		return ps.updatePermissionByValue(permission);
	}

	@RequestMapping("/deleteBypid")
	public Integer deleteBypid(Integer pId) {
		return ps.deleteBypid(pId);
	}
	
	@RequestMapping("/deleteByIds")
	public Integer deleteBypid(String ids) {
		Integer num = 0;
		String[] arr = ids.split(",");
		for (int i = 0; i < arr.length; i++) {
			Integer pId = Integer.parseInt(arr[i]);
			num = ps.deleteBypid(pId);
		}
		return num;
	}

	@RequestMapping("/addPermission")
	public Integer addPermission(Permission permission) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		permission.setPUpdateTime(dateString);
		return ps.addPermission(permission);
	}
	
	
	@RequestMapping("/getAllPermissionNameByUserId")
	public Map<String, Object> getAllPermissionNameByUserId(String userId){
		return ps.getAllPermissionNameByUserId(userId);
	}
	
	@RequestMapping("/getAllPermissionName")
	public Map<String, Object> getAllPermissionName(){
		return ps.getAllPermissionName();
	}

}
