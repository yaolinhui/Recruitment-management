package com.wk68.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoles {

	private Integer urId;// 用户角色中间表
	private String userId;// 用户编号
	private Integer roleId;// 角色编号
}
