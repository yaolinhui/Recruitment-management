package com.wk68.service;

import java.util.List;
import java.util.Map;

import com.wk68.entity.Modules;


public interface ModuleService {





	Map<String, Object> getAll(Map<String, Object> map);

	Integer addModules(Modules modules);

	Integer UpModules(Modules modules);

	Integer delModules(Integer moduleId);

	Integer ModuleByNameAndPath(Modules module);

	List<Object> findTree();

	



}
