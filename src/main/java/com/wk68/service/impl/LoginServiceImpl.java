package com.wk68.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.wk68.entity.User;
import com.wk68.mapper.LoginMapper;
import com.wk68.mapper.UserMapper;
import com.wk68.service.LoginService;
import com.wk68.util.SendMsg;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper lm;

	@Autowired
	private UserMapper um;

	public User getUserName(String loginname) {
		return lm.getUserName(loginname);
	}

	public User getUser(String loginname, String mD5PWD) {
		return lm.getUser(loginname, mD5PWD);
	}

	public Integer setLockTime(String loginname, String outTime) {
		return lm.setLockTime(loginname, outTime);
	}

	public Integer Lastlogintime(String loginname, String outTime) {
		return lm.Lastlogintime(loginname, outTime);
	}

	public Integer setLockOut(String loginname) {
		return lm.setLockOut(loginname);
	}

	// verificationCode：验证码全局变量
	// phoneNumber：手机号码全部变量
	public static String verificationCode = "";
	public static String phoneNumber = "";

	@Override
	public Map<String, Object> verificationCode(String phone) {
		Map<String, Object> map = new HashMap<>();
		User user = lm.findPhoneNumber(phone);
		if (user != null) {
			map.put("code", 1);
			map.put("msg", "验证码已发送，请注意查收。");
		} else {
			map.put("code", 0);
			map.put("msg", "错误！请重试。");
		}
		phoneNumber = phone;
		verificationCode = SendMsg.getCode();
		SendMsg.sendMessage(phoneNumber, verificationCode);
		return map;
	}

	public Map<String, Object> affirmVerificationCode(String yzm) {
		Map<String, Object> map = new HashMap<>();
		if (verificationCode.equals(yzm)) {
			map.put("code", 1);
			map.put("msg", "验证码通过！");
		} else {
			map.put("code", 0);
			map.put("msg", "验证码填写错误！");
		}
		return map;
	}

	public Map<String, Object> updatePassword(User user) {
		String password = user.getUPassword();
		String phone = user.getUProtectPhone();
		String idnumber = lm.findPhoneNumber(phone).getUIdNumber();
		// 获取身份证出生年月日作为当做盐，获取身份证后六位加~作为初始密码
		// 412827200004284038
		// 生成盐284038
		String salt = idnumber.substring(5, 13);
		String pwd = salt + password + salt;
		// MD5加密
		String MD5PWD = DigestUtils.md5DigestAsHex(pwd.getBytes());
		user.setUPassword(MD5PWD);
		Map<String, Object> map = new HashMap<>();
		Integer userupdate = lm.updatePassword(user);
		if (userupdate > 0) {
			map.put("code", 1);
			map.put("msg", "更改密码成功，正在跳转登录页面！");
		} else {
			map.put("code", 0);
			map.put("msg", "更改密码失败，请重试！");
		}
		return map;
	}

	/**
	 * 判断数据库里是否有此手机号
	 */
	public Integer phoneIsNull(String phone, String userId) {
		// 根据userId查找当前用户信息
		User user = um.getByUserId(userId);
		// 获取当前用户的旧手机号
		String phoneOld = user.getUProtectPhone();
		// 此用户的手机号为空时
		if (phoneOld.isEmpty()) {
			return 0;
		}
		// 当前用户输入的手机号与旧手机号相同时
		if (phone.equals(phoneOld)) {
			return 0;
		}
		return lm.findPhoneNumber(phone) != null ? 1 : 0;
	}

	public User getPersonalInformation(String userId) {
		return lm.getPersonalInformation(userId);
	}

	/**
	 * 判断当前用户输入的邮箱在数据库中是否已经存在
	 */
	public Integer emailIsNull(String uProtectEmail, String userId) {
		// 根据userId查找当前用户信息
		User user = um.getByUserId(userId);
		// 获取当前用户的旧邮箱
		String emailOld = user.getUProtectEmail();
		// 当前用户邮箱为空时
		if (emailOld.isEmpty()) {
			return 0;
		}
		// 当前用户输入邮箱与旧邮箱相同时
		if (uProtectEmail.equals(emailOld)) {
			return 0;
		}
		return lm.findEmailIsNull(uProtectEmail) != null ? 1 : 0;
	}

	@Override
	public Integer updateUStatus(String loginname, String uStatus) {
		return lm.updateUStatus(loginname, uStatus);
	}

}
