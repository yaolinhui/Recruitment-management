package com.wk68.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesModules {
	
	private Integer rmId;//角色模块中间表编号
	private Integer roleId;//角色表编号
	private Integer moduleId;//功能模块编号
}
