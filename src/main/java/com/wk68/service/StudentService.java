package com.wk68.service;

import java.util.List;
import java.util.Map;

import com.wk68.entity.DynamicMessage;
import com.wk68.entity.Student;
import com.wk68.entity.User;
import com.wk68.util.UpdateStudent;

public interface StudentService {

	Map<String, Object> getStudentsByUserId(Map<String, Object> map);

	/**
	 * 网络咨询师添加学生客户信息
	 * 
	 * @param student
	 * @return 添加时受影响行数
	 */
	Integer addStudentInfo(Student student);

	Integer verifyUniqueField(Student student);

	/**
	 * 修改一条学生信息
	 * 
	 * @param student
	 * @return update更新受影响行数
	 */
	Integer updateStudent(UpdateStudent student);

	/**
	 * 删除一条学生信息
	 * 
	 * @param student
	 * @return delete 返回一条受影响行数
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
	 * 多条件分页显示回收站
	 * 
	 * @param student
	 * @param user
	 * @param dfs
	 * @param page
	 * @param limit
	 * @return c_student_copy表中所有数据
	 */
	Map<String, Object> getStudentsByUserIdRecyleBin(Map<String, Object> map);

	/**
	 * 删除回收站一条学生信息
	 */
	Integer deleteStudentRecycleBin(String studentId);

	/**
	 * 在回收站里还原一名学生客户信息
	 * 
	 * @param studentId
	 * @return 把c_student_copy表中某一条数据复制到c_student中，并删掉此学生客户的信息
	 */
	Integer huanyuanStudentRecycleBin(String studentId);

	User getUserByUserId(String userId);

	boolean pushMessage(DynamicMessage dm);

	List<User> getAllCounselorUser(String roleName);

	boolean allotCounselor(Student student);

	Map<String, Object> getFollowAllStudentByUserId(String userId, String studentName, Integer page, Integer limit);

	// 导出
	List<Student> findById(String id);

	List<Student> findAll();
}
