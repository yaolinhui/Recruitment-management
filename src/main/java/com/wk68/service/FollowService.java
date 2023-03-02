package com.wk68.service;

import java.util.List;
import java.util.Map;

import com.wk68.entity.Follows;
import com.wk68.entity.Student;

public interface FollowService {

	Integer addFollow(Follows follow);

	Integer deleteFollow(Integer fId);

	Integer updateFollow(Follows follow);
	
	Map<String, Object> getFollowsByUserId(Map<String, Object> map);

	List<Student> getStudentsByVerifySName(String sName);

}
