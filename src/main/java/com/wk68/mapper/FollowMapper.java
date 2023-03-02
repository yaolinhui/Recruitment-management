package com.wk68.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wk68.entity.Follows;
import com.wk68.entity.Student;

@Repository
public interface FollowMapper {

	Integer addFollow(@Param("f")Follows follow);

	Integer deleteFollow(@Param("fId")Integer fId);

	Integer updateFollow(@Param("f")Follows follow);

	List<Follows> getAllFollowByUserId(@Param("map")Map<String, Object> map);

	Integer getCountFollowByUserId(@Param("map")Map<String, Object> map);

	List<Student> getStudentsByVerifySName(@Param("sName")String sName);

	Student getStudentBySPhone(@Param("sPhone")String sPhone);

}
