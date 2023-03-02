package com.wk68.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.wk68.entity.AddFriend;
import com.wk68.entity.ChatInfo;
import com.wk68.entity.ChatUser;
import com.wk68.entity.EmpInfo;
import com.wk68.entity.FriendInfo;
import com.wk68.entity.GroupInfo;
import com.wk68.entity.User;

@Repository
public interface ChatMapper {

	// 获取所有群名
	List<FriendInfo> findFriendInfos(String currentUserId);

	EmpInfo findOne(String currentUserId);

	List<GroupInfo> findGroupInfo(String currentUserId);

	/**
	 * 获取该用户下的群组所有成员
	 */
	List<ChatUser> getGroupMembers(Integer id);

	/**
	 * 添加一条聊天记录
	 * 
	 * @param chatuser
	 * @return
	 */
	Integer saveMsg(EmpInfo chatuser);

	List<EmpInfo> getUnreadMessage(String userId);

	List<EmpInfo> getAllChattingRecords(String id, String type, String userId);

	/**
	 * 当前用户设置在线隐身模式，根据用户编号修改表中status字段属性值
	 * 
	 * @param user
	 * @return Integer
	 */
	/*
	 * 在Mapper接口之上，通过注解快速简单直接构建SQL语句，适用于不太复杂的语句
	 */
	@Update(value = { "update c_user set u_status = #{uStatus} where user_id = #{userId}" })
	Integer setUserOnlineOrOffline(User user);

	@Update(value = { "update c_emp set e_is_read = '1' where e_time_stamp = #{timestamp}" })
	Integer setRead(String timestamp);
	
	List<ChatUser> getAllFriend();
	
	Integer AddFriend(AddFriend addFriend);

	List<AddFriend> getAddFriend(String userId);

	ChatUser getAddFriendById(String userId);
	
	@Insert(value = { "insert into c_friend_user(fz_id,user_id) values(#{fzId},#{userId})" })
	Integer insertFriendUser(Integer fzId, String userId);
	
	
	@Update(value = { "update c_add_friend_group set af_is_yes = '1' where af_user_id = #{afUserId} and af_to_user_id = #{afToUserId} " })
	Integer updateAddIsFriend(AddFriend addFriend);
	
	List<ChatUser> getAllUserByroleId(Integer roleId);

}
