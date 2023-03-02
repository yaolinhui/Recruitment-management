package com.wk68.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.ChatUser;
import com.wk68.entity.Modules;
import com.wk68.entity.Permission;
import com.wk68.entity.Roles;
import com.wk68.mapper.ChatMapper;
import com.wk68.mapper.RoleMapper;
import com.wk68.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper rm;
	
	@Autowired
	private ChatMapper cm;

	@Override
	public Integer addRole(Roles role) {
		// 角色名不允许重复
		Roles r = rm.getRoleByRoleName(role.getRoleName());
		if (r != null) {
			return 0;
		}
		return rm.addRole(role);
	}

	@Override
	public Integer updateRole(Roles role) {
		// 角色名不允许修改为已存在的roleName
		Roles r = rm.getRoleByRoleName(role.getRoleName());
		if (r != null) {
			if (!r.getRoleId().equals(role.getRoleId())) {
				return 0;
			}
		}
		return rm.updateRole(role);
	}

	@Override
	public Integer deleteRoleByRoleId(Integer roleId) {
		List<Integer> moduleIds = rm.getModuleIdsByRoleId(roleId);
		List<Integer> permissionIds = rm.getPermissionIdsByRoleId(roleId);
		if (moduleIds.size() > 0 || permissionIds.size() > 0) {
			return 0;
		}
		return rm.deleteRoleByRoleId(roleId);
	}

	@Override
	public Roles getRoleByRoleId(Integer roleId) {

		return rm.getRoleByRoleId(roleId);
	}

	@Override
	public Map<String, Object> getAll(Map<String, Object> map) {
		List<Roles> data = rm.getAll(map);
		Integer count = rm.getCount(map);
		if (data.size() > 0) {
			map.put("data", data);
			map.put("count", count);
			map.put("code", 0);
			// 移除原map集合的参数
			map.remove("role");
			map.remove("page");
			map.remove("limit");

		} else {
			map.put("msg", "数据未找到");
		}
		return map;
	}

	public List<Object> findTree() {
		List<Object> list = new ArrayList<Object>();
		// 获取模块的所有数据
		List<Modules> modules = rm.getAllModule();
		for (int i = 0; i < modules.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (modules.get(i).getMParentId() == 0) {
				map.put("title", modules.get(i).getMName());
				map.put("id", modules.get(i).getModuleId());
				map.put("children", getChilden(modules.get(i).getModuleId(), modules));
				list.add(map);
			}
		}
		return list;
	}

	private List<Object> getChilden(Integer Id, List<Modules> modules) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < modules.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (Id.equals(modules.get(i).getMParentId())) {
				map.put("title", modules.get(i).getMName());
				map.put("id", modules.get(i).getModuleId());
				map.put("children", getChilden(modules.get(i).getModuleId(), modules));
				list.add(map);
			}

		}
		return list;
	}

	public Modules findChildrens(Modules treeNode, List<Modules> treeList) {
		// 遍历集合
		for (Modules item : treeList) {
			if (treeNode.getModuleId() == item.getMParentId()) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<Modules>());
				}
				treeNode.getChildren().add(findChildrens(item, treeList));
			}
		}
		// System.out.println(treeNode.getChildren());
		return treeNode;
	}

	/***
	 * 权限tree
	 */
	public List<Object> findPermissionTree() {
		List<Object> list = new ArrayList<Object>();
		// 获取模块的所有数据
		List<Permission> permissions = rm.getAllPermission();
		for (int i = 0; i < permissions.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (permissions.get(i).getPParent() == 0) {
				map.put("title", permissions.get(i).getPName());
				map.put("id", permissions.get(i).getPId());
				map.put("children", getPermissionChilden(permissions.get(i).getPId(), permissions));
				list.add(map);
			}
		}
		// System.out.println("findTree----" + list);
		return list;
	}

	private List<Object> getPermissionChilden(Integer Id, List<Permission> permissions) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < permissions.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (Id.equals(permissions.get(i).getPParent())) {
				map.put("title", permissions.get(i).getPName());
				map.put("id", permissions.get(i).getPId());
				map.put("children", getPermissionChilden(permissions.get(i).getPId(), permissions));
				list.add(map);
			}
		}
		return list;
	}

	public Permission findPermissionChildrens(Permission treeNode, List<Permission> treeList) {
		// 遍历集合
		for (Permission item : treeList) {
			if (treeNode.getPId() == item.getPParent()) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<Permission>());
				}
				treeNode.getChildren().add(findPermissionChildrens(item, treeList));
			}
		}
		// System.out.println(treeNode.getChildren());
		return treeNode;
	}

	/***
	 * 先清除该用户下所有Module，再添加获取到的前台数据
	 */
	@Override
	public Integer setRoleModule(Integer roleId, String moduleIds) {
		Integer num = 0;
		try {
			// 删除module
			num = rm.deleteModuleByRoleId(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return num;
		}
		if (moduleIds == null || moduleIds == "") {
			return num;
		}
		// 数组化
		String[] arr = moduleIds.split(",");
		for (int i = 0; i < arr.length; i++) {
			// String转Integer
			Integer moduleId = Integer.parseInt(arr[i]);
			// 逐步添加Module
			num = rm.addModuleByRoleId(roleId, moduleId);
		}
		return num;
	}

	/****
	 * 设置权限
	 */
	@Override
	public Integer setRolePermission(Integer roleId, String permissionIds) {
		Integer num = 0;
		try {
			// 删除permission
			num = rm.deletePermissionByRoleId(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return num;
		}
		if (permissionIds == null || permissionIds == "") {
			return num;
		}
		// 数组化
		String[] arr = permissionIds.split(",");
		for (int i = 0; i < arr.length; i++) {
			// String转Integer
			Integer permissionId = Integer.parseInt(arr[i]);
			// 逐步添加Module
			num = rm.addPermissionByRoleId(roleId, permissionId);
		}
		return num;
	}

	@Override
	public Integer verifyUniqueRole(String roleName, Integer roleId) {
		// roleId == null代表着添加角色 相反为修改
		if (roleId != null) {
			Roles r = rm.getRoleByRoleId(roleId);
			if (roleName.equals(r.getRoleName())) {
				return 1;
			}
		}
		Roles roles = rm.getRoleByRoleName(roleName);
		if (roles != null) {
			return 0;
		}
		return 1;
	}
	
	/**
	 * 根据角色Id查找所有用户
	 */
	@Override
	public Map<String, Object> getAllUserByroleId(Integer roleId) {
		Map<String, Object> map = new HashMap<>();
		List<ChatUser> chatUser = cm.getAllUserByroleId(roleId);
		System.out.println("---------"+chatUser);
		if (chatUser.size() >= 1) {
			map.put("list", chatUser);
			map.put("code", 1);
		}else {
			map.put("list", chatUser);
			map.put("msg", "无用户信息");
			map.put("code", 0);
		}
		return map;
	}

}
