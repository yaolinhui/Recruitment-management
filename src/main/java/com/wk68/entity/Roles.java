package com.wk68.entity;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
	private Integer roleId;// 用户角色编号
	private String roleName;// 角色（用户组）名称

	// Module集合
	private Set<Modules> moduleSet;
	// Permission集合
	private Set<Permission> permissionSet;
}
