package com.wk68.service;

import java.util.List;
import java.util.Map;

import com.wk68.entity.AddFriend;
import com.wk68.entity.ChatUser;
import com.wk68.entity.EmpInfo;
import com.wk68.entity.FriendInfo;
import com.wk68.entity.GroupInfo;
import com.wk68.entity.User;

public interface ChatService {

	List<FriendInfo> findFriendInfos(String currentUserId);

	EmpInfo findOne(String currentUserId);

	List<GroupInfo> findGroupInfo(String currentUserId);

	List<ChatUser> getGroupMembers(Integer id);

	Integer saveMsg(EmpInfo chatuser);

	List<EmpInfo> getUnreadMessage(String userId);

	List<EmpInfo> getAllChattingRecords(String id, String type,String userId);

	Integer setUserOnlineOrOffline(User user);

	Integer setRead(String timestamp);
	
	Map<String, Object> getAllFriend();

	Integer AddFriend(AddFriend addFriend);

	Map<String, Object> getAddFriend(String userId);
	
	Integer insertFriendUser(Integer fzId, String userId);

	Integer updateAddIsFriend(com.wk68.entity.AddFriend addFriend);


}
