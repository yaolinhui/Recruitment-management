package com.wk68.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wk68.entity.DynamicMessage;
import com.wk68.entity.Roles;
import com.wk68.entity.Student;
import com.wk68.entity.User;
import com.wk68.util.UpdateStudent;

@Repository
public interface StudentMapper {

	List<Student> getAllByUserId(@Param("map") Map<String, Object> map);

	Integer getCountByUserId(@Param("map") Map<String, Object> map);

	List<Roles> getRolesByUserId(@Param("userId") String userId);

	Integer addStudentInfo(Student student);

	List<Student> verifyUniqueField(Student student);

	/**
	 * 修改一条学生信息
	 * 
	 * @param student
	 * @return update 更新操作时返回一条Integer类型的受影响行数
	 */
	Integer updateStudent(UpdateStudent student);

	/**
	 * 删除一条学生信息
	 * 
	 * @param student StudentId
	 * @return delete 删除操作时返回一条Integer类型的受影响行数
	 */
	Integer deleteStudent(String studentId);

	/**
	 * 根据学生编号把所有信息转移到学生回收站表中
	 * 
	 * @param studentId
	 * @return 添加的一条学生信息返回Integer类型的受影响行数
	 */
	Integer batchDelectStudent(String studentId);

	/**
	 * 回收站模块中多条件查询显示所有
	 * 
	 * @param map
	 * @return c_student_copy表中的所有数据
	 */
	List<Student> getAllByUserIdRecyleBin(@Param("map") Map<String, Object> map);

	/**
	 * 回收站模块中查询数据总条数，用于分页
	 * 
	 * @param map
	 * @return Integer类型的总条数
	 */
	Integer getCountByUserIdRecyleBin(@Param("map") Map<String, Object> map);

	/**
	 * 删除一条回收站学生信息
	 * 
	 * @param studentId
	 * @return 返回一条Integer类型的受影响行数
	 */
	Integer deleteStudentRecycleBin(String studentId);

	/**
	 * 在回收站里还原一名学生客户信息
	 * 
	 * @param studentId
	 * @return 把c_student_copy表中某一条数据复制到c_student中，并删掉此学生客户的信息
	 */
	Integer huanyuanStudentRecycleBin(String studentId);

	User getUserByUserId(@Param("userId") String userId);

	Integer pushMessage(@Param("dm") DynamicMessage dm);

	List<User> getAllCounselorUser(@Param("roleName") String roleName);

	Integer allotCounselor(@Param("s") Student student);

	List<Student> getFollowAllStudentByUserId(String userId, String studentName, Integer page, Integer limit);

	Integer getCountFollowAllStudentByUserId(String userId, String studentName);

	List<Student> findById(String id);

	List<Student> findAll();
}
