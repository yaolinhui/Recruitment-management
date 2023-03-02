package com.wk68.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendInfo {

	// 群名
	private String groupname;
	// 群id
	private Integer id;
	
	// list集合接收多个群
	private List<ChatUser> list;
}
