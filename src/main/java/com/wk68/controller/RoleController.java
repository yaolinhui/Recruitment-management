package com.wk68.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.Roles;
import com.wk68.service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService rs;

	/***
	 * 添加
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/addRole")
	public Integer addRole(Roles role) {

		return rs.addRole(role);
	}

	/***
	 * 删除
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/deleteRoleByRoleId")
	public Integer deleteRoleByRoleId(Integer roleId) {
		return rs.deleteRoleByRoleId(roleId);
	}

	/***
	 * 批量删除
	 * 
	 * @param roleIds
	 * @return
	 */
	@RequestMapping("/deleteRoleByRoleIds")
	public Map<String, Object> deleteRoleByRoleIds(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 数组化
		String[] arr = ids.split(",");
		Integer num = 0;
		for (int i = 0; i < arr.length; i++) {
			// String转Integer
			Integer roleId = Integer.parseInt(arr[i]);
			num += rs.deleteRoleByRoleId(roleId);
		}
		if (num == arr.length) {
			map.put("msg", "批量删除成功");
		} else {
			Integer notdeleteNum = arr.length - num;
			map.put("msg", "已删除" + num + "名角色，" + notdeleteNum + "已分配模块权限不能删除");
		}
		return map;
	}

	/***
	 * 修改
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping("/updateRole")
	public Integer updateRole(Roles role) {
		return rs.updateRole(role);
	}

	/***
	 * 获取所有角色
	 * 
	 * @param role
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getAll")
	public Map<String, Object> getAll(Roles role, Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		page = page == null ? 0 : (page - 1) * limit;
		limit = limit == null ? 10 : limit;
		map.put("page", page);
		map.put("limit", limit);
		map.put("role", role);
		return rs.getAll(map);
	}

	/***
	 * 获取所有模块
	 * 
	 * @return
	 */
	@RequestMapping("/getAllModule")
	public List<Object> getAllModule() {
		return rs.findTree();
	}

	/***
	 * 设置角色模块
	 * 
	 * @param roleId
	 * @param moduleIds
	 * @return
	 */
	@RequestMapping("setRoleModule")
	public Integer setRoleModule(Integer roleId, String moduleIds) {
		return rs.setRoleModule(roleId, moduleIds);
	}

	/***
	 * 获取所有权限
	 * 
	 * @return
	 */
	@RequestMapping("/getAllPermission")
	public List<Object> getAllPermission() {
		System.out.println(rs.findPermissionTree());
		return rs.findPermissionTree();
	}

	/***
	 * 设置角色权限
	 * 
	 * @param roleId
	 * @param permissionIds
	 * @param index
	 * @return
	 */
	@RequestMapping("setRolePermission")
	public Integer setRolePermission(Integer roleId, String permissionIds) {
		return rs.setRolePermission(roleId,permissionIds);
	}
	
	
	/**
	 * 判断角色名称是否在数据库中存在
	 */
	@RequestMapping("/verifyUniqueRole")
	public Integer verifyUniqueRole(String roleName,Integer roleId) {
		return rs.verifyUniqueRole(roleName,roleId);
	}
	
	/**
	 * 根据角色Id
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/getAllUserByroleId")
	public Map<String, Object> getAllUserByroleId(Integer roleId){
		return rs.getAllUserByroleId(roleId);
	}
	
	
	
	
	
	
}
