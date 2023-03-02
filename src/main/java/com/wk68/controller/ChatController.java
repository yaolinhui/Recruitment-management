package com.wk68.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.AddFriend;
import com.wk68.entity.ChatInfo;
import com.wk68.entity.ChatUser;
import com.wk68.entity.EmpInfo;
import com.wk68.entity.FriendInfo;
import com.wk68.entity.GroupInfo;
import com.wk68.entity.User;
import com.wk68.service.ChatService;
import com.wk68.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private ChatService cs;

	@Autowired
	private UserService us;

	@RequestMapping("/getGroupData")
	public ChatInfo findChatInfo(String currentUserId) {

		User user = us.getByUserId(currentUserId);
		// 获取所有分组
		List<FriendInfo> friendInfos = cs.findFriendInfos(currentUserId);
		// EmpInfo mine = cs.findOne(currentUserId);
	
		ChatUser mine = new ChatUser();
		mine.setId(user.getUserId());
		mine.setUsername(user.getUName());
		mine.setAvatar(user.getUHeadPortrait());
		mine.setSign(user.getURemark());
		mine.setStatus(user.getUStatus());
		mine.setToId("");
		ChatInfo chatInfo = new ChatInfo();
		chatInfo.setCode(0);
		chatInfo.setMsg("ok");
		Map<String, Object> map = chatInfo.getData();
		map.put("mine", mine);
		map.put("friend", friendInfos);
		List<GroupInfo> list = cs.findGroupInfo(currentUserId);
		map.put("group", list);
		return chatInfo;
	}

	@RequestMapping("/getMembers")
	public ChatInfo getMembers(Integer id) {

		ChatInfo chatInfo = new ChatInfo();
		chatInfo.setCode(0);
		chatInfo.setMsg("ok");
		Map<String, Object> map = chatInfo.getData();

		List<ChatUser> list = cs.getGroupMembers(id);

		map.put("list", list);

		return chatInfo;
	}

	@RequestMapping("/saveMsg")
	public Integer saveMsg(EmpInfo chatuser) {
		chatuser.setIsLogin(1);
		chatuser.setSign("你好");
		chatuser.setStatus(1);
		chatuser.setTimestamp(new Date().getTime());
		return cs.saveMsg(chatuser);
	}

	@RequestMapping("/getUnreadMessage")
	public List<EmpInfo> getUnreadMessage(String userId) {
		return cs.getUnreadMessage(userId);
	}

	@RequestMapping("/getAllChattingRecords")
	public Map<String, Object> getAllChattingRecords(String id, String type, String userId) {
		List<EmpInfo> emp = cs.getAllChattingRecords(id, type, userId);
		Map<String, Object> map = new HashMap<>();
		map.put("code",1);
		map.put("msg", "测试");
		map.put("data", emp);
		return map;
	}
	
	@RequestMapping("/setUserOnlineOrOffline")
	public Integer setUserOnlineOrOffline(User user) {
		return cs.setUserOnlineOrOffline(user);
	}
	
	//当前未读信息设置为已读
	@RequestMapping("/setRead")
	public Integer setRead(String str) {
		String[] arr = str.split(",");
		Integer a = 0;
		for (int i = 0; i < arr.length; i++) {
			String timestamp = arr[i];
			a  += cs.setRead(timestamp);
		}
		return arr.length == a ? 1 : 0;
	}
	
	@RequestMapping("/getAllFriend")
	public Map<String, Object> getAllFriend(){
		return cs.getAllFriend();
	}
	
	@RequestMapping("/addFriend")
	public Integer addFriend(AddFriend addFriend) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式 HH:mm:ss
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		addFriend.setAfCreateTime(date);
		System.out.println(addFriend);
		return cs.AddFriend(addFriend);
	} 
	@RequestMapping("/getAddFriend")
	public Map<String, Object> getAddFriend(String userId){
		return cs.getAddFriend(userId);
	}
	
	@RequestMapping("/insertFriendUser")
	public Integer insertFriendUser(Integer fzId,String userId) {
		return cs.insertFriendUser(fzId,userId);
	}
	
	/**
	 * 
	 * @param addFriend
	 * @return
	 */
	@RequestMapping("/updateAddIsFriend")
	public Integer updateAddIsFriend(AddFriend addFriend) {
		return cs.updateAddIsFriend(addFriend);
	}

}
