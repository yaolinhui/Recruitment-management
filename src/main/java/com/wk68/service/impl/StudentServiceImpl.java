package com.wk68.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.DynamicMessage;
import com.wk68.entity.Roles;
import com.wk68.entity.Student;
import com.wk68.entity.User;
import com.wk68.mapper.StudentMapper;
import com.wk68.service.StudentService;
import com.wk68.util.UpdateStudent;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper sm;

	@Override
	public Map<String, Object> getStudentsByUserId(Map<String, Object> map) {
		Student student = (Student) map.get("student");
		// 网络学生管理---网络咨询师|咨询师经理
		String userId = student.getUserId();
		// 我的学生管理----咨询师|咨询师经理
		if (userId == null) {
			userId = student.getUserId2();
		}
		List<Roles> roleList = sm.getRolesByUserId(userId);
		for (Roles roles : roleList) {
			// 判断当前用户拥有角色是网络咨询角色|咨询师角色（部分学生）、咨询师经理角色(全部学生)
			if ("咨询师经理".equals(roles.getRoleName())) {
				// 查询所有学生
				student.setUserId(null);
				student.setUserId2(null);
			}
		}
		map.put("student", student);
		List<Student> data = sm.getAllByUserId(map);
		Integer count = sm.getCountByUserId(map);
		map.put("data", data);
		map.put("count", count);
		map.put("code", 0);
		return map;
	}

	/**
	 * 添加一条学生客户信息
	 */
	public Integer addStudentInfo(Student student) {
		return sm.addStudentInfo(student);
	}

	/**
	 * 根据参数在数据库中找值
	 */
	public Integer verifyUniqueField(Student student) {
		System.out.println("失去焦点-----" + student.getStudnetId());
		// 返回值1为没有重复 0代表重复
		Integer num = 1;
		List<Student> stuList = sm.verifyUniqueField(student);
		System.out.println("stuList ---- " + stuList);
		// 验证数据是否在数据库已查到
		if (stuList.size() > 0) {
			num = 0;// 添加验证
			String ajaxStudnetId = student.getStudnetId();
			if (ajaxStudnetId != null) {// 修改验证
				// 输入框值可能没有变化失去焦点验证
				if (ajaxStudnetId.equals(stuList.get(0).getStudnetId())) {
					num = 1;
				}
			}
		}
		return num;
	}

	/**
	 * 修改一条学生信息
	 * 
	 * @param student
	 * @return update更新受影响行数
	 */
	public Integer updateStudent(UpdateStudent student) {
		return sm.updateStudent(student);
	}

	/**
	 * 删除一条学生信息
	 * 
	 * @param studentId
	 * @return delete删除后返回受影响行数
	 */
	public Integer deleteStudent(String studentId) {
		return sm.deleteStudent(studentId);
	}

	/**
	 * 根据学生编号把所有信息转移到学生回收站表中
	 * 
	 * @param studentId
	 * @return 添加的一条学生信息返回Integer类型的受影响行数
	 */
	public Integer batchDelectStudent(String studentId) {
		return sm.batchDelectStudent(studentId);
	}

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
	public Map<String, Object> getStudentsByUserIdRecyleBin(Map<String, Object> map) {
		Student student = (Student) map.get("student");
		map.put("student", student);
		List<Student> data = sm.getAllByUserIdRecyleBin(map);
		Integer count = sm.getCountByUserIdRecyleBin(map);
		map.put("data", data);
		map.put("count", count);
		map.put("code", 0);
		return map;
	}

	/**
	 * 删除一条回收站学生信息
	 * 
	 * @param studentId
	 * @return delete删除后返回受影响行数
	 */
	public Integer deleteStudentRecycleBin(String studentId) {
		return sm.deleteStudentRecycleBin(studentId);
	}

	/**
	 * 在回收站里还原一名学生客户信息
	 * 
	 * @param studentId
	 * @return 把c_student_copy表中某一条数据复制到c_student中，并删掉此学生客户的信息
	 */
	public Integer huanyuanStudentRecycleBin(String studentId) {
		return sm.huanyuanStudentRecycleBin(studentId);
	}

	@Override
	public User getUserByUserId(String userId) {
		return sm.getUserByUserId(userId);
	}

	@Override
	public boolean pushMessage(DynamicMessage dm) {
		// 推送信息默认未读
		dm.setDmRead("未读");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currDate = null;
		try {
			currDate = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dm.setDmCreateTime(currDate);
		Integer num = sm.pushMessage(dm);
		boolean flag = false;
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<User> getAllCounselorUser(String roleName) {
		return sm.getAllCounselorUser(roleName);
	}

	@Override
	public boolean allotCounselor(Student student) {
		student.setSAllot("true");
		Integer num = 0;
		boolean flag = false;
		num = sm.allotCounselor(student);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public Map<String, Object> getFollowAllStudentByUserId(String userId, String studentName, Integer page,
			Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> student = sm.getFollowAllStudentByUserId(userId, studentName, page, limit);
		Integer count = sm.getCountFollowAllStudentByUserId(userId, studentName);
		if (student.size() > 0) {
			map.put("data", student);
			map.put("count", count);
			map.put("code", 0);
		} else {
			map.put("msg", "数据未找到");
		}
		return map;
	}

	// 导出
	@Override
	public List<Student> findById(String id) {

		return sm.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return sm.findAll();
	}

}
