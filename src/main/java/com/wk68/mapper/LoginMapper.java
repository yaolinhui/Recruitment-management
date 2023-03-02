package com.wk68.mapper;



import org.springframework.stereotype.Repository;

import com.wk68.entity.User;

@Repository
public interface LoginMapper {

	User getUserName(String loginname);

	User getUser(String loginname, String mD5PWD);

	Integer setLockTime(String loginname, String outTime);

	Integer Lastlogintime(String loginname, String outTime);

	Integer setLockOut(String loginname);

	User findPhoneNumber(String phone);

	Integer updatePassword(User user);

	User getPersonalInformation(String userId);

	User findEmailIsNull(String uProtectEmail);
	
	Integer updateUStatus(String loginname,String uStatus);

}
