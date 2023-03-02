package com.wk68.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFriend {
	private Integer id;
	private String afUserId;
	private String afToUserId;
	private String afMsg;
	private String afFriendOrGroup;
	private Integer afGroupId;
	private String afIsYes;
	private String afCreateTime;
}
