package com.wk68.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

	private Integer pId;// 权限编号
	private Integer pParent;
	private String pValue;// 权限值
	private String pModuleName;// 权限模块名称
	private String pName;// 权限名称
	private String pUpdateTime;//权限更新时间
	
	private List<Permission> children = new ArrayList<>();
}
