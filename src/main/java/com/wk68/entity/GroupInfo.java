package com.wk68.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo {
	// 群id(部门id)
	private Integer id;
	// 群名
	private String groupname;
	// 群头像
	private String avatar;
}
