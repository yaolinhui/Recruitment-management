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

import com.wk68.entity.Modules;
import com.wk68.entity.Permission;
import com.wk68.service.ModuleService;
import com.wk68.service.PermissionService;

@RestController
//跨域访问
@CrossOrigin
@RequestMapping("/module")
public class ModuleController {
	
	@Autowired
	private PermissionService ps;
	@Autowired
	private ModuleService ms;
	/**
	 * 获取所有模块
	 * @param module
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getAll")
	public Map<String, Object> getAll(Modules module, Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("module", module);
		page = page == null ? 0 : page - 1;
		limit = limit == null ? 10 : limit;
		map.put("page", page);
		map.put("limit", limit);
		return ms.getAll(map);
	}
	/**
	 * 添加
	 * @param modules
	 * @return
	 */
	@RequestMapping("/addModules")
	public Integer addModules(Modules modules){
		Permission permission = new Permission();
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		permission.setPUpdateTime(dateString);
		permission.setPParent(0);
		permission.setPValue(modules.getMPath());
		permission.setPModuleName(modules.getMName());
		permission.setPName(modules.getMName());
		ps.addPermission(permission);
		return ms.addModules(modules);
	}
	/**
	 * 修改模块信息内容
	 * */
	@RequestMapping("/UpModules")
	public Integer UpModules(Modules modules) {
		System.out.println(modules);
		return ms.UpModules(modules);
	}
	
	/**
	 * 删除模块信息  后期要判断改模块下面如果有角色不能进行删除
	 * */
	@RequestMapping("/delModules")
	public Integer delModules(Integer moduleId) {
		System.out.println("我是模块传的要删除ID:"+moduleId);
		return ms.delModules(moduleId);
	}
	
	@RequestMapping("/deleteByIds")
	public Integer deleteByIds(String ids) {
		Integer num = 0;
		String[] arr = ids.split(",");
		for (int i = 0; i < arr.length; i++) {
			Integer moduleId = Integer.parseInt(arr[i]);
			num = ms.delModules(moduleId);
		}
		return num;
	}
	
	/**
	 * 查询模块名
	 * @return
	 */
	@RequestMapping("/ModuleByNameAndPath")
	public Integer ModuleByNameAndPath(Modules module) {
		System.out.println(module.getMName());
		return ms.ModuleByNameAndPath(module);
	}
	/**
	 * 获取所有模块
	 * @return
	 */
	@RequestMapping("/getAllModule")
	public List<Object> getAllModule() {
		return ms.findTree();
	}
}
