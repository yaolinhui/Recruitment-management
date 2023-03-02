package com.wk68.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.Follows;
import com.wk68.entity.Student;
import com.wk68.entity.User;
import com.wk68.service.FollowService;
import com.wk68.util.TimeToSearch;

@RestController
@RequestMapping("/follow")
@CrossOrigin
public class FollowController {
	/***
	 * fId 回访记录编号 studentId;跟踪学生 sName跟踪学生姓名 userId访问者id fTime 跟踪时间 fContent沟通内容
	 * fNextTime下次跟踪时间 fFeedback跟踪反馈信息 fType'老客户' 老客户、新客户、休眠客户 fWay微信、电话等 fStatus
	 * 譬如：考虑中、准备报名
	 */
	@Autowired
	private FollowService fs;

	/***
	 * 添加跟踪访问记录
	 * 
	 * @param follow
	 * @return
	 */
	@RequestMapping("addFollow")
	public Integer addFollow(Follows follow) {
		return fs.addFollow(follow);

	}

	/***
	 * 删除
	 * 
	 * @param fId
	 * @return
	 */
	@RequestMapping("deleteFollow")
	public Integer deleteFollow(Integer fId) {
		return fs.deleteFollow(fId);
	}

	@RequestMapping("deleteFollows")
	public Integer deleteFollows(String fIds) {
		Integer num = 0;
		// 字符串转字符串数组
		String[] arr = fIds.split(",");
		// 循环取出fId（String类型）
		for (String string : arr) {
			// String转Integer
			Integer fId = Integer.parseInt(string);
			num = fs.deleteFollow(fId);
		}
		return num;
	}

	/***
	 * 修改
	 * 
	 * @param follow
	 * @return
	 */
	@RequestMapping("updateFollow")
	public Integer updateFollow(Follows follow) {
		return fs.updateFollow(follow);
	}

	/***
	 * 移除数据到回收站|还原数据
	 * 
	 * @param follow
	 * @return
	 */
	@RequestMapping("restoreFollow")
	public Integer restoreFollow(Follows follow, String fIds) {
		return fs.updateFollow(follow);
	}

	/****
	 * 批量移除数据到回收站|批量还原数据
	 * 
	 * @param follow
	 * @return
	 */
	@RequestMapping("restoreFollows")
	public Integer restoreFollows(Follows follow, String fIds) {
		Integer num = 0;
		// 字符串转字符串数组
		String[] arr = fIds.split(",");
		// 循环取出fId（String类型）
		for (String string : arr) {
			// String转Integer
			Integer fId = Integer.parseInt(string);
			// 指定数据
			follow.setFId(fId);
			num = fs.updateFollow(follow);
		}
		return num;
	}

	/***
	 * 客户(学生)的跟踪访问咨询师只能查看部分学生的跟踪回访 咨询经理可查看全部
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("getFollowsByUserId")
	public Map<String, Object> getFollowsByUserId(Follows follow, String uName, TimeToSearch tts, Integer page,
			Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 设置参数
		User user = new User();
		user.setUName(uName);
		follow.setUser(user);
		page = page == null ? 0 : page - 1;
		limit = limit == null ? 10 : limit;
		map.put("page", page);
		map.put("limit", limit);
		map.put("follow", follow);
		map.put("tts", tts);
		return fs.getFollowsByUserId(map);
	}
	/***
	 * 通过学生姓名获取学生信息（姓名可重复）
	 * @param sName
	 * @return
	 */
	@RequestMapping("getStudentsByVerifySName")
	public List<Student> getStudentsByVerifySName(String sName) {
		return fs.getStudentsByVerifySName(sName); 
	}
}
