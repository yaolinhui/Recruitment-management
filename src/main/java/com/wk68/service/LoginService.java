package com.wk68.service;


import java.util.Map;

import org.springframework.stereotype.Service;

import com.wk68.entity.User;


public interface LoginService {


	User getUserName(String loginname);

	User getUser(String loginname, String mD5PWD);

	Integer setLockTime(String loginname, String outTime);

	Integer Lastlogintime(String loginname, String outTime);

	Integer setLockOut(String loginname);

	Map<String, Object> verificationCode(String phone);

	Map<String, Object> affirmVerificationCode(String yzm);

	Map<String, Object> updatePassword(User user);
	
	Integer phoneIsNull(String phone,String userId);

	User getPersonalInformation(String userId);

	Integer emailIsNull(String uProtectEmail,String userId);
	
	Integer updateUStatus(String loginname,String uStatus);
}
