package com.wk68.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wk68.entity.User;
import com.wk68.service.LoginService;
import com.wk68.util.TokenUtil;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService us;

	@RequestMapping("/login")
	public Map<String, Object> login(String loginname, String password) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outTime = formatter.format(date);
		Map<String, Object> map = new HashMap<>();
		User UserName = us.getUserName(loginname);
		
		if (UserName == null) {
			map.put("code", 0);
			map.put("msg", "无此用户信息！");
			return map;
		}
		if (UserName.getULockOut() >= 1) {
			map.put("code", 0);
			map.put("msg", "账户已锁定，请联系管理人员！");
			return map;
		}
		if (UserName.getUPsdWrong() >= 3) {
			us.setLockOut(loginname);
			map.put("code", 0);
			map.put("msg", "密码错误以超过3次，账户已锁定，请联系管理人员！");
			return map;
		}

		String salt = UserName.getUIdNumber().substring(5, 13);
		String pwd = salt + password + salt;
		String MD5PWD = DigestUtils.md5DigestAsHex(pwd.getBytes());
		User u = us.getUser(loginname, MD5PWD);

		if (u == null) {
			us.setLockTime(loginname, outTime);
			map.put("code", 0);
			map.put("msg", "密码错误！");
			return map;
		}

		us.Lastlogintime(loginname, outTime);
		 //修改用户状态为在线
	    String uStatus = "online";
	    us.updateUStatus(loginname,uStatus);
		String token = null;
		try {
			// 工具类生成Token
			// eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ7XCJpZFwiOlwiMzAzNGViZTktZDg0OC00ZjQxLWFmMTEtMThmNTQzMWEzNmFiXCIsXCJsb2dpbm5hbWVcIjpcIuafr
			token = TokenUtil.sign(u, 1 * 60 * 60 * 1000); // 1 * 60 * 60 * 1000 = 1小时有效期
		} catch (UnsupportedEncodingException | JsonProcessingException e) {
			e.printStackTrace();
		}
		map.put("token", token);
		map.put("uid", u.getUserId());
		map.put("uname", u.getULoginName());
		map.put("code", 1);
		return map;
	}

	// 忘记密码
	@RequestMapping("/verificationCode")
	public Map<String, Object> verificationCode(String phone, String token) {
		return us.verificationCode(phone);
	}

	@RequestMapping("/affirmVerificationCode")
	public Map<String, Object> affirmVerificationCode(String yzm, String token) {
		System.out.println(yzm);
		return us.affirmVerificationCode(yzm);
	}

	@RequestMapping("/updatePassword")
	public Map<String, Object> updatePassword(User user, String token) {
		return us.updatePassword(user);
	}
	
	@RequestMapping("/phoneIsNull")
	public Integer phoneIsNull(String phone,String userId) {
		return us.phoneIsNull(phone,userId);
	}

	/**
	 * 获取用户个人信息
	 */
	@RequestMapping("/getPersonalInformation")
	public User getPersonalInformation(String userId) {
		return us.getPersonalInformation(userId);
	}

	/**
	 * 判断数据库里是否有此邮箱
	 */
	@RequestMapping("/emailIsNull")
	public Integer emailIsNull(String uProtectEmail,String userId) {
		return us.emailIsNull(uProtectEmail,userId);
	}

	// 测试token是否有效
	@RequestMapping("/testToken")
	public Boolean testToken() {
		return true;
	}

}
