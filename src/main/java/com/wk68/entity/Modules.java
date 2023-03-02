package com.wk68.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modules {



	private Integer moduleId;//模块编号
	private String mName;//模块名称
	private Integer mParentId;//父模块编号顶级父模块为0
	private String mPath;//模块路径
	private Integer mWeight;//权重（数字越大，越优先显示）
	//moduleId mName mParentId mPath mWeight
	 private List<Modules> children = new ArrayList<>();
}
