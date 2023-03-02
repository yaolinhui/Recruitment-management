package com.wk68.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wk68.entity.Modules;
import com.wk68.entity.User;
import com.wk68.service.UserService;
import com.wk68.util.BASE64;
import com.wk68.util.BaiDuOCR;
import com.wk68.util.MultipartToFile;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService us;

	/***
	 * 通过userId获取该用户下的所有模块
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getAllModuleByUserId")
	public Map<String, Object> getAllModuleByUserId(String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 存储user的module
		Set<Modules> moduleSet = new HashSet<Modules>();
		// 通过UserId获取RoleId
		Set<Integer> roleIdSet = us.getRoleIdsByUserId(userId);
		// a|b合并set集合
		// 循环角色，进而获取模块
		for (Integer roleId : roleIdSet) {
			// 通过roleId获取Module
			Set<Modules> moduleSetChild = us.getModuleByRoleId(roleId);
			// 并集 添加set集合到另一个set集合
			moduleSet.addAll(moduleSetChild);
		}
		map.put("moduleSet", moduleSet);
		return map;
	}

	/**
	 * 查询原密码是否正确
	 */
	@RequestMapping("/getAPwd")
	public Map<String, Object> getAllPwd(String uLoginName, String uPassword) {
		System.out.println("这是用户名" + uLoginName);
		System.out.println("这是原密码" + uPassword);
		return us.getAllPwd(uLoginName, uPassword);

	}

	/**
	 * 修改密码
	 */
	@RequestMapping("/editPwd")
	public Map<String, Object> editPwd(String uLoginName, String newPwd) {
		System.out.println("这是用户名" + uLoginName);
		System.out.println("这是新密码" + newPwd);
		return us.editPwd(uLoginName, newPwd);

	}
	
	

	/*
	 * 用户资料中当前登录者上传图片或者修改图片
	 */
	@RequestMapping("/upload")
	public HashMap<String, Object> upload(String uId, String token, MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException {

		HashMap<String, Object> res = new HashMap<>();
		// 用户图片储存到本地路径下
		String path = "D:\\crmweb\\images\\";
		UUID uuid = UUID.randomUUID();
		String originalFilename = file.getOriginalFilename();
		// String fileName = uuid.toString() + originalFilename;
		String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		String fileName = uuid.toString() + extendName;
		File dir = new File(path + fileName);
		File filepath = new File(path);
		System.out.println("路径==" + filepath.getParentFile());
		if (!filepath.getParentFile().exists()) {
			filepath.getParentFile().mkdirs();
		} else {
			System.out.println(filepath.getParentFile());
		}
		// if(!filepath.exists()) {
		file.transferTo(dir);
		// 获得当前项目所在路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		System.out.println("当前项目所在路径：" + pathRoot);
		// 保存到数据库里图片的路径名称
		String sqlFile = "../../../images/" + fileName;
		User user = new User();
		if(uId == null) {
			res.put("code", 0);
			res.put("msg", "上传成功");
			res.put("sqlFile", sqlFile);
			return res;
		}
		user.setUHeadPortrait(sqlFile);
		user.setUserId(uId);
		System.out.println(user);
		Integer i = us.setHeadPortrait(user);
		if (i > 0) {
			res.put("code", 0);
			res.put("msg", "上传成功");
			return res;
		}
		res.put("code", 1);
		res.put("msg", "上传失败");
		return res;

	}

	/***
	 * 添加
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("addUser")
	public Integer addUser(User user) {
		return us.addUser(user);
	}

	/***
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	public Integer updateUser(User user) {
		return us.updateUser(user);
	}

	@RequestMapping("invertULockOut")
	public Integer invertULockOut(User user) {

		return us.invertULockOut(user);
	}

	/***
	 * 重置密码为：~+身份证后六位
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("resetPassword")
	public Integer resetPassword(User user) {
		System.out.println(user);
		return us.resetPassword(user);
	}

	/***
	 * 删除
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("deleteByUserId")
	public Integer deleteByUserId(String userId) {
		return us.deleteByUserId(userId);
	}

	/**
	 * 批量删除
	 * 
	 * @param userIds
	 * @return
	 */
	@RequestMapping("deleteByUserIds")
	public Map<String, Object> deleteByUserIds(String userIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] arr = userIds.split(",");
		// 判断是否删除成功
		Integer num = 0;
		// 成功删除数据条数
		Integer deleteNum = 0;
		// 批量删除的提示语
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			String userId = arr[i];
			num = us.deleteByUserId(userId);
			deleteNum += num;
			if (num == 0) {
				User user = us.getByUserId(userId);
				String uLoginName = user.getULoginName();
				if (sb != null) {
					sb.append("、");
				}
				sb.append(uLoginName);
			}
		}
		String msg = null;
		if (deleteNum == 0) {
			msg = "批量删除失败，已分配角色的用户不能删除";
		} else if (deleteNum == arr.length) {
			msg = "批量删除成功，已全部删除";
		} else if (deleteNum > 0) {
			msg = "已删除" + deleteNum + "个用户数据," + sb + "已分配角色不能删除";
		}
		map.put("msg", msg);
		return map;
	}

	/***
	 * userId uLoginName uName uPassword uLockOut uLastLoginTime uCreateTime
	 * uPsdWrong uLockTime uProtectEmail uProtectPhone uIdNumber
	 * 
	 * @param user
	 * @param uCreateTimeEnd
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("getAll")
	public Map<String, Object> getAll(User user, @DateTimeFormat(pattern = "yyyy-MM-dd") String ucreateTime,
			@DateTimeFormat(pattern = "yyyy-MM-dd") String ucreateTimeEnd, Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("uCreateTime", ucreateTime);
		map.put("uCreateTimeEnd", ucreateTimeEnd);
		page = page == null ? 0 : (page - 1)*limit;
		limit = limit == null ? 10 : limit;
		map.put("page", page);
		map.put("limit", limit);
		return us.getAll(map);
	}

	/***
	 * 设置角色
	 * 
	 * @param userid
	 * @param roleids
	 * @param index
	 * @return
	 */
	@RequestMapping("setRole")
	public Integer setRole(String userId, String roleIds, Integer index) {
		// System.out.println(userId);
		// System.out.println(roleIds);
		Integer num = 0;
		String[] arr = roleIds.split(",");
		if (index == 0) {// 添加角色
			for (int i = 0; i < arr.length; i++) {
				Integer roleId = Integer.parseInt(arr[i]);
				num = us.addUserRole(userId, roleId);
			}
		} else {// 移除角色
			for (int i = 0; i < arr.length; i++) {
				Integer roleId = Integer.parseInt(arr[i]);
				num = us.removeUserRole(userId, roleId);
			}
		}
		return num;
	}

	/****
	 * 
	 * layui文件上传必须使用file作为形参接收
	 * 
	 * @param file
	 * @throws IOException
	 */
	@RequestMapping("uploadIdNumberPicture")
	public Map<String, String> uploadIdNumberPicture(MultipartFile file) throws IOException {
		HashMap<String, String> map = null;
		try {
			File f = MultipartToFile.multipartFileToFile(file);
			// 进行BASE64位编码
			String imageBase = BASE64.encodeImgageToBase64(f);
			imageBase = imageBase.replaceAll("\r\n", "");
			imageBase = imageBase.replaceAll("\\+", "%2B");
			// 百度云的文字识别接口,后面参数为获取到的token
			String httpUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=" + BaiDuOCR.getAuth();
			// id_card_side=front 识别正面 id_card_side=back 识别背面
			String httpArg = "detect_direction=true&id_card_side=front&image=" + imageBase;
			String jsonResult = BaiDuOCR.request(httpUrl, httpArg);
			// System.out.println("返回的结果--------->" + jsonResult);
			map = BaiDuOCR.getHashMapByJson(jsonResult);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "图片文件过大或非身份证正面图片");
			return map;
		}
	}

	/***
	 * 添加、修改输入框失去焦点验证
	 */
	@RequestMapping("verifyUniqueField")
	public boolean verifyUniqueField(User user) {
		boolean flag = false;
		flag = us.verifyUniqueField(user);
		return flag;
	}

	/**
	 * 修改个人用户信息
	 */
	@RequestMapping("/updateUserInfo")
	public Integer updateUserInfo(User user) {
		return us.updateUserInfo(user);
	}

	@RequestMapping("/updateRemarkById")
	public Integer updateRemarkById(User user) {
		return us.updateRemarkById(user);
	}

	/***
	 * 开启|关闭咨询师用户自动分量
	 */
	@RequestMapping("invertUAutoAllot")
	public boolean invertUAutoAllot(User user) {
		boolean flag = false;
		flag = us.invertUAutoAllot(user);
		return flag;
	}

	/***
	 * 全部开启|关闭咨询师用户自动分量
	 */
	@RequestMapping("invertUAutoAllotAll")
	public boolean invertUAutoAllotAll(User user, String userIds) {
		boolean flag = false;
		// 字符串转数组
		String[] arr = userIds.split(",");
		for (int i = 0; i < arr.length; i++) {
			String userId = arr[i];
			user.setUserId(userId);
			flag = us.invertUAutoAllot(user);
		}
		return flag;
	}
	
	@RequestMapping("/abc")
	public String abc(String a) {
		System.out.println(a);
		return a;
	}

	
}
