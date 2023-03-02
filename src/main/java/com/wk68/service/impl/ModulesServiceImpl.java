package com.wk68.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.Modules;
import com.wk68.mapper.ModuleMapper;
import com.wk68.mapper.RoleMapper;
import com.wk68.service.ModuleService;
@Service
public class ModulesServiceImpl implements ModuleService {
	@Autowired
	private ModuleMapper mm;
	@Autowired
	private RoleMapper rm;
	//moduleId mName mParentId mPath mWeight


	@Override
	public Map<String, Object> getAll(Map<String, Object> map) {
		Map<String,Object> map1 = new HashMap<String,Object>();
		List<Modules> data = mm.getAll();
		System.out.println(data);
		map1.put("data", data);
		map1.put("code", 0);
		map1.put("count", data.size());
		return map1;
	}


	@Override
	public Integer addModules(Modules modules) {
		//当添加一个新模块时，权限表中也应该添加一个父权限模块
		
		return mm.addModules(modules);
	}


	@Override
	public Integer UpModules(Modules modules) {
		return mm.UpModules(modules);
	}


	@Override
	public Integer delModules(Integer moduleId) {
		return mm.delModules(moduleId);
	}


	/**
	 * 根据模块名查询数据，用于查重数据名称
	 */
	public Integer ModuleByNameAndPath(Modules module) {
		return mm.ModuleByNameAndPath(module).size() != 0 ? 1 : 0;
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
				//map.put("children", getChilden(modules.get(i).getModuleId(), modules));
				list.add(map);
			}
		}
		return list;
	}	




	
}










