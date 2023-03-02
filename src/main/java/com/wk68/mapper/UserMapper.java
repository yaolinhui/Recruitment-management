package com.wk68.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wk68.entity.Modules;
import com.wk68.entity.User;

@Repository
public interface UserMapper {

	//加密工具类
	User getUserAll(String userLoginName);
    //修改密码

	int editPwd(String uLoginName, String newPwd);

	Integer setHeadPortrait(User user);
	
	Integer addUser(@Param("u") User user);

	Integer deleteByUserId(String userId);

	Integer updateUser(User user);

	List<User> getAll(@Param("map") Map<String, Object> map);

	Integer getCount(@Param("map") Map<String, Object> map);

	List<User> getUserByULoginNameOrUProtectEmailOrUProtectPhoneOrUIdNumber(@Param("u")User user);

	Set<Integer> getRoleIdsByUserId(String userId);

	Set<Modules> getModuleByRoleId(Integer roleId);

	User getByUserId(String userId);


	Integer resetPassword(@Param("u")User user);

	Integer addUserRole(@Param("userId")String userId, @Param("roleId")Integer roleId);

	Integer removeUserRole(@Param("userId")String userId, @Param("roleId")Integer roleId);

	Integer invertULockOut(@Param("u")User user);

	/* Integer updateUserInfo(User user); */

	Integer updateRemarkById(User user);

	boolean invertUAutoAllot(@Param("u")User user);


}
