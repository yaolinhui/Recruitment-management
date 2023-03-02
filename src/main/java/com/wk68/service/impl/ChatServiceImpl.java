package com.wk68.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.ChatUser;
import com.wk68.entity.AddFriend;
import com.wk68.entity.ChatInfo;
import com.wk68.entity.EmpInfo;
import com.wk68.entity.FriendInfo;
import com.wk68.entity.GroupInfo;
import com.wk68.entity.User;
import com.wk68.mapper.ChatMapper;
import com.wk68.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatMapper cm;

	public List<FriendInfo> findFriendInfos(String currentUserId) {

		return cm.findFriendInfos(currentUserId);
	}

	public EmpInfo findOne(String currentUserId) {
		return cm.findOne(currentUserId);
	}

	public List<GroupInfo> findGroupInfo(String currentUserId) {
		return cm.findGroupInfo(currentUserId);
	}

	/**
	 * 获取该用户下的群组所有成员
	 */
	public List<ChatUser> getGroupMembers(Integer id) {
		return cm.getGroupMembers(id);
	}

	/**
	 * 添加一条聊天记录
	 */
	public Integer saveMsg(EmpInfo chatuser) {
		return cm.saveMsg(chatuser);
	}

	public List<EmpInfo> getUnreadMessage(String userId) {
		return cm.getUnreadMessage(userId);
	}

	public List<EmpInfo> getAllChattingRecords(String id, String type, String userId) {
		return cm.getAllChattingRecords(id, type, userId);
	}

	public Integer setUserOnlineOrOffline(User user) {
		return cm.setUserOnlineOrOffline(user);
	}

	/**
	 * 当前未读消息设置为已读
	 */
	public Integer setRead(String timestamp) {
		return cm.setRead(timestamp);
	}
	
	/**
	 * 获取所有好友
	 */
	public Map<String, Object> getAllFriend() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ChatUser> chatuser = cm.getAllFriend();
		if (chatuser.size() != 0) {
			map.put("title", "小明");
			map.put("list", chatuser);
		}else {
			map.put("code", 0);
			map.put("msg", "无数据");
		}
		return map;
	}

	public Integer AddFriend(AddFriend addFriend) {
		return cm.AddFriend(addFriend);
	}
	
	/**
	 * 获取好友添加请求
	 */
	public Map<String, Object> getAddFriend(String userId) {
		Map<String, Object> map = new HashMap<>();
		List<ChatUser> a = new ArrayList<>();
		List<AddFriend> friend = cm.getAddFriend(userId);
		for (int i = 0; i < friend.size(); i++) {
			String id = friend.get(i).getAfUserId();
			ChatUser user = cm.getAddFriendById(id);
			user.setGroupid(friend.get(i).getAfGroupId());
			user.setType(friend.get(i).getAfFriendOrGroup());
			a.add(user);	
		}
		map.put("list", a);
		System.out.println(a.toString());
		return map;
	}

	public Integer insertFriendUser(Integer fzId, String userId) {
		return cm.insertFriendUser(fzId,userId);
	}

	public Integer updateAddIsFriend(AddFriend addFriend) {
		return cm.updateAddIsFriend(addFriend);
	}

}
