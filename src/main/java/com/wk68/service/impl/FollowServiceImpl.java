package com.wk68.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.Follows;
import com.wk68.entity.Roles;
import com.wk68.entity.Student;
import com.wk68.mapper.FollowMapper;
import com.wk68.mapper.StudentMapper;
import com.wk68.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	private StudentMapper sm;
	@Autowired
	private FollowMapper fm;

	@Override
	public Integer addFollow(Follows follow) {
		Integer num = 0;
		//默认true（显示） false（进入回收站）
		follow.setFShow("true");
		try {
			num = fm.addFollow(follow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Integer deleteFollow(Integer fId) {
		Integer num = 0;
		try {
			num = fm.deleteFollow(fId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Integer updateFollow(Follows follow) {
		Integer num = 0;
		try {
			num = fm.updateFollow(follow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Map<String, Object> getFollowsByUserId(Map<String, Object> map) {
		Follows follow = (Follows) map.get("follow");
		String userId = follow.getUserId();
		List<Roles> roleList = sm.getRolesByUserId(userId);
		for (Roles roles : roleList) {
			// 判断当前用户拥有角色是网络咨询角色|咨询师角色（部分学生）、咨询师经理角色(全部学生)
			if ("咨询师经理".equals(roles.getRoleName())) {
				follow.setUserId(null);
			}
		}
		map.put("follow", follow);
		List<Follows> data = fm.getAllFollowByUserId(map);
		Integer count = fm.getCountFollowByUserId(map);
		map.put("data", data);
		map.put("count", count);
		map.put("code", 0);
		return map;
	}

	@Override
	public List<Student> getStudentsByVerifySName(String sName) {
		
		return fm.getStudentsByVerifySName(sName);
	}

}
