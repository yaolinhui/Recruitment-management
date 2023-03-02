package com.wk68.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wk68.entity.Modules;
import com.wk68.entity.User;
import com.wk68.mapper.UserMapper;
import com.wk68.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;

	@Override
	public Set<Integer> getRoleIdsByUserId(String userId) {

		return um.getRoleIdsByUserId(userId);
	}

	@Override
	public Set<Modules> getModuleByRoleId(Integer roleId) {

		return um.getModuleByRoleId(roleId);
	}

	/**
	 * pand User UserList = us.getUserById(user.getUserId()); //
	 * 获取身份证后六位当做盐，获取出生年月日作为初始密码 // 412827200004284038 // 生成盐284038 String salt =
	 * UserList.getUIdNumber().substring(5, 13); // 获取用户名 String pwd = salt +
	 * user.getUPassword() + salt; // MD5加密 String MD5PWD =
	 * DigestUtils.md5DigestAsHex(pwd.getBytes()); // 设置MD5加密
	 * user.setUPassword(MD5PWD); user.setUProtectPhone(user.getUProtectPhone());
	 */
	@Override
	public Map<String, Object> getAllPwd(String uLoginName, String uPassword) {
		Map<String, Object> map = new HashMap<>();
		// 旧密码
		String passwrod = MD5PWD(uLoginName, uPassword);
		// 获得当前用户
		User user = um.getUserAll(uLoginName);
		// 获取当前密码
		String dqPsssword = user.getUPassword();
		// 如果当前密码包含老密码
		if (dqPsssword.equals(passwrod)) {
			map.put("code", 1);
			map.put("msg", "与原密码相同");
		} else {
			map.put("code", 0);
			map.put("msg", "与原密码不符合,请重试");
		}
		return map;
	}

	@Override
	public Map<String, Object> editPwd(String uLoginName, String newPwd) {
		Map<String, Object> map = new HashMap<>();
		// 获取从页面传过来的新密码
		String xinPwd = MD5PWD(uLoginName, newPwd);
		// 接收
		int num = um.editPwd(uLoginName, xinPwd);
		if (num > 0) {
			map.put("code", "1");
			map.put("msg", "密码修改成功，请使用新密码重新登录");
		} else {
			map.put("code", "0");
			map.put("msg", "密码修改失败");
		}
		return map;
	}

	// 加密方式工具类（用于修改密码的）
	public String MD5PWD(String userLoginName, String newPassword) {
		User user = um.getUserAll(userLoginName);
		if (user != null) {
			String idNumber = user.getUIdNumber();
			String salt = idNumber.substring(5, 13);
			// 获取用户名
			String pwd = salt + newPassword + salt;
			// MD5加密
			String MD5PWD = DigestUtils.md5DigestAsHex(pwd.getBytes());
			return MD5PWD;
		} else {
			return "无数据";
		}
	}

	@Override
	public Integer setHeadPortrait(User user) {
		// TODO Auto-generated method stub
		return um.setHeadPortrait(user);
	}
	
	/****
	   * 添加uLoginName uProtectEmail uProtectPhone uIdNumber不可重复
	   */
	  @Override
	  public Integer addUser(User user) {
	    //System.out.println(user);
	    // 手动生成UUID
	    String userId = UUID.randomUUID().toString();
	    user.setUserId(userId);
	    // 通过身份证号获取盐 MD5密码加密
	    String uIdNumber = user.getUIdNumber();
	    String salt = uIdNumber.substring(5, 13);
	    // 密码默认~+身份证后六位
	    String password = "~" + uIdNumber.substring(12, 18);
	    String pwd = salt + password + salt;
	    String MD5PWD = DigestUtils.md5DigestAsHex(pwd.getBytes());
	    user.setUPassword(MD5PWD);
	    // 默认密码错误次数为0，未锁定为1
	    user.setUPsdWrong(0);
	    // 默认未锁定0，锁定为1
	    user.setULockOut(0);
	    // 用户创建时间
	    Date uCreateTime = getDateTime();
	    user.setUCreateTime(uCreateTime);
	    // 通过用户登录名查询用户是否存在 uProtectEmail uProtectPhone uIdNumber
	    List<User> u = um.getUserByULoginNameOrUProtectEmailOrUProtectPhoneOrUIdNumber(user);
	    if (u.size() == 0) {
	      try {
	        return um.addUser(user);
	      } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	      }
	    } else {
	      return 0;
	    }
	  }



	/****
	 * 重置密码
	 */
	@RequestMapping("/resetPassword")
	public Integer resetPassword(User user) {
		// 通过身份证号获取盐 MD5密码加密
		String uIdNumber = user.getUIdNumber();
		// String salt = uIdNumber.substring(13, 18);
		String salt = uIdNumber.substring(5, 13);
		// 重置密码为：~+身份证后六位
		String password = "~" + uIdNumber.substring(12, 18);
		String pwd = salt + password + salt;
		String MD5PWD = DigestUtils.md5DigestAsHex(pwd.getBytes());
		user.setUPassword(MD5PWD);
		return um.resetPassword(user);
	}

	@Override
	public Integer deleteByUserId(String userId) {
		try {
			return um.deleteByUserId(userId);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public User getByUserId(String userId) {
		return um.getByUserId(userId);
	}

	@Override
	public Map<String, Object> getAll(Map<String, Object> map) {
		List<User> data = um.getAll(map);
		Integer count = um.getCount(map);
		if (data.size() > 0) {
			map.put("data", data);
			map.put("count", count);
			map.put("code", 0);
		} else {
			map.put("msg", "数据未找到");
		}
		return map;
	}


	/***
	 * 获取当前日期时间(年、月、日、时、分、秒)
	 * 
	 * @return
	 */
	public Date getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDateTime = sdf.format(new Date());
		Date datetime = null;
		try {
			datetime = sdf.parse(sDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datetime;
	}

	@Override
	public Integer addUserRole(String userId, Integer roleId) {
		return um.addUserRole(userId,roleId);
	}

	@Override
	public Integer removeUserRole(String userId, Integer roleId) {
		return um.removeUserRole(userId,roleId);
	}

	@Override
	public Integer invertULockOut(User user) {
		return um.invertULockOut(user);
	}
	/***
	   * uLoginName uIdNumber uProtectEmail uProtectPhone
	   */
	  @Override
	  public boolean verifyUniqueField(User user) {
	    boolean flag = false;
	    // operation为true代表添加、false代表修改
	    boolean operation = user.getUserId() == null;
	    List<User> u = um.getUserByULoginNameOrUProtectEmailOrUProtectPhoneOrUIdNumber(user);
	    if (operation) {// 添加验证
	      if (u.size() == 0) {
	        flag = true;
	      }
	    } else{// 修改验证
	      //String userId = user.getUserId();
	      if (u != null) {
	        if(user.getUserId().equals(u.get(0).getUserId())) {
	          flag = true;
	        }
	      }
	    }
	    return flag;
	  }

	  /****
	   * 修改uLoginName uProtectEmail uProtectPhone uIdNumber不可重复
	   */
	  public Integer updateUser(User user) {
		  
	    // 通过用户登录名查询用户是否存在
	    List<User> u = um.getUserByULoginNameOrUProtectEmailOrUProtectPhoneOrUIdNumber(user);
	    // System.out.println(user);
	    if (u != null) {
	      if (!u.get(0).getUserId().equals(user.getUserId())) {
	        return 0;
	      }
	    }
	    try {
	      return um.updateUser(user);
	    } catch (Exception e) {
	      return 0;
	    }
	  }

	/**
	 * 修改个人信息
	 */
	public Integer updateUserInfo(User user) {
		System.out.println(user);
		return um.updateUser(user);
	}

	public Integer updateRemarkById(User user) {
		return um.updateRemarkById(user);
	}

	@Override
	public boolean invertUAutoAllot(User user) {
		
		return um.invertUAutoAllot(user);
	}

	

}
