package com.wk68.mapper;

import java.util.List;

import com.wk68.entity.Modules;

public interface ModuleMapper {

	


	List<Modules> getAll();

	Integer addModules(Modules modules);

	Integer UpModules(Modules modules);

	Integer delModules(Integer moduleId);


	List<Modules> ModuleByNameAndPath(Modules module);

}
