package com.wk68.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission {
	
	private Integer rpId;//角色功能中间表
	private Integer roleId;//角色编号
	private Integer pId;//功能编号
}
