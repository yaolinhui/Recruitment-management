package com.wk68.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.DynamicMessage;
import com.wk68.entity.Student;
import com.wk68.entity.User;
import com.wk68.service.StudentService;
import com.wk68.util.TimeToSearch;
import com.wk68.util.UpdateStudent;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService ss;

	/***
	 * 拥有咨询师角色的用户查询该用户下负责的所有学生
	 * 
	 * @param student
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("getStudentsByUserId")
	public Map<String, Object> getStudentsByUserId(Student student, User user, TimeToSearch dfs, Integer page,
			Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		page = page == null ? 0 : (page - 1) * limit;
		limit = limit == null ? 10 : limit;
		map.put("page", page);
		map.put("limit", limit);
		map.put("student", student);
		map.put("user", user);
		map.put("dfs", dfs);
		return ss.getStudentsByUserId(map);
	}

	/**
	 * 网络咨询师添加学生客户信息
	 * 
	 * @param student
	 * @return 添加时受影响行数
	 */
	@RequestMapping("/addStudentInfo")
	public Integer addStudentInfo(Student student) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		student.setStudnetId(uuid);
		return ss.addStudentInfo(student);
	}

	/**
	 * 验证学生姓名，手机号，微信号，QQ号是否与数据库重复
	 * 
	 * @param student
	 * @return 1:没有重复 0:重复
	 */
	@RequestMapping("/verifyUniqueField")
	public Integer verifyUniqueField(Student student) {
		return ss.verifyUniqueField(student);
	}

	/**
	 * 修改一条学生信息
	 */
	@RequestMapping("/updateStudent")
	public Integer updateStudent(UpdateStudent student) {
		System.out.println(student);
		return ss.updateStudent(student);
	}

	/**
	 * 删除一条学生信息
	 */
	@RequestMapping("/deleteStudent")
	public Integer deleteStudent(String studentId) {
		return ss.deleteStudent(studentId);
	}

	/**
	 * 根据学生编号把所有信息转移到学生回收站表中
	 * 
	 * @param studentId
	 * @return 添加的一条学生信息返回Integer类型的受影响行数
	 */
	@RequestMapping("/batchDelectStudent")
	public Map<String, Object> batchDelectStudent(String studentIdIds) {
		Map<String, Object> map = new HashMap<>();
		String[] arr = studentIdIds.split(",");
		// 判断是否删除成功
		Integer num = 0;
		// 成功删除数据条数
		Integer deleteNum = 0;
		Integer cuoWuNum = 0;
		for (int i = 0; i < arr.length; i++) {
			String studentId = arr[i];
			deleteNum = ss.batchDelectStudent(studentId);
			num += deleteNum;
			if (num > 0) {
				ss.deleteStudent(studentId);
			} else {
				cuoWuNum++;
			}
		}
		String msg = null;
		if (deleteNum == 0) {
			msg = "批量转移回收站失败，请联系管理人员！";
		} else if (deleteNum == arr.length) {
			msg = "成功，已全部批量转移回收站！";
		} else if (deleteNum > 0) {
			msg = "已回收" + deleteNum + "个用户数据," + cuoWuNum + "个客户不能转移回收站。";
		}
		map.put("msg", msg);
		return map;
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
	@RequestMapping("/getStudentsByUserIdRecyleBin")
	public Map<String, Object> getStudentsByUserIdRecyleBin(Student student, User user, TimeToSearch dfs, Integer page,
			Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		page = page == null ? 0 : page - 1;
		limit = limit == null ? 10 : limit;
		map.put("page", page);
		map.put("limit", limit);
		map.put("student", student);
		map.put("user", user);
		map.put("dfs", dfs);
		return ss.getStudentsByUserIdRecyleBin(map);
	}

	/**
	 * 删除回收站一条学生信息
	 */
	@RequestMapping("/deleteStudentRecycleBin")
	public Integer deleteStudentRecycleBin(String studentId) {
		return ss.deleteStudentRecycleBin(studentId);
	}

	/**
	 * 批量删除回收站学生信息
	 * 
	 * @param studentIdIds
	 * @return
	 */
	@RequestMapping("/batchDelectStudentRecycleBin")
	public Map<String, Object> batchDelectStudentRecycleBin(String studentIdIds) {
		Map<String, Object> map = new HashMap<>();
		String[] arr = studentIdIds.split(",");
		// 判断是否删除成功
		Integer num = 0;
		// 成功删除数据条数
		Integer deleteNum = 0;
		Integer cuoWuNum = 0;
		Integer yihuishou = 0;
		for (int i = 0; i < arr.length; i++) {
			String studentId = arr[i];
			deleteNum = ss.deleteStudentRecycleBin(studentId);
			num += deleteNum;
			if (num > 0) {
				yihuishou++;
			} else {
				cuoWuNum++;
			}
		}
		String msg = null;
		if (deleteNum == 0) {
			msg = "批量转移回收站失败，请联系管理人员！";
		} else if (deleteNum == arr.length) {
			msg = "成功，已全部批量转移回收站！";
		} else if (deleteNum > 0) {
			msg = "已回收" + yihuishou + "个用户数据," + cuoWuNum + "个客户不能转移回收站。";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 在回收站里还原一名学生客户信息
	 * 
	 * @param studentId
	 * @return 把c_student_copy表中某一条数据复制到c_student中，并删掉此学生客户的信息
	 */
	@RequestMapping("/huanyuanStudentRecycleBin")
	public Integer huanyuanStudentRecycleBin(String studentId) {
		return ss.huanyuanStudentRecycleBin(studentId) == 1 ? ss.deleteStudentRecycleBin(studentId) : 0;
	}

	/**
	 * 批量地还原学生用户
	 * 
	 * @param studentIdIds
	 * @return
	 */
	@RequestMapping("/batchHuanYuanStudentRecycleBin")
	public Map<String, Object> batchHuanYuanStudentRecycleBin(String studentIdIds) {
		Map<String, Object> map = new HashMap<>();
		String[] arr = studentIdIds.split(",");
		// 判断是否删除成功
		Integer num = 0;
		// 成功删除数据条数
		Integer deleteNum = 0;
		Integer cuoWuNum = 0;
		Integer yihuishou = 0;
		for (int i = 0; i < arr.length; i++) {
			String studentId = arr[i];
			deleteNum = ss.huanyuanStudentRecycleBin(studentId);
			num += deleteNum;
			if (num > 0) {
				ss.deleteStudentRecycleBin(studentId);
			} else {
				cuoWuNum++;
			}
		}
		String msg = null;
		if (deleteNum == 0) {
			msg = "批量转移回收站失败，请联系管理人员！";
		} else if (deleteNum == arr.length) {
			msg = "成功，已全部批量转移回收站！";
		} else if (deleteNum > 0) {
			msg = "已回收" + yihuishou + "个用户数据," + cuoWuNum + "个客户不能转移回收站。";
		}
		map.put("msg", msg);
		return map;
	}

	/***
	 * 根据userId获取User
	 */
	@RequestMapping("getUserByUserId")
	public User getUserByUserId(String userId) {
		return ss.getUserByUserId(userId);
	}

	/***
	 * 推送信息
	 */
	@RequestMapping("pushMessage")
	public boolean pushMessage(DynamicMessage dm) {
		boolean flag = false;
		flag = ss.pushMessage(dm);
		return flag;
	}

	/***
	 * 获取所有咨询师用户
	 */
	@RequestMapping("getAllCounselorUser")
	public Map<String, Object> getAllCounselorUser(String roleName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> data = ss.getAllCounselorUser(roleName);
		if (data.size() > 0) {
			map.put("code", 0);
		} else {
			map.put("code", 1);
			map.put("msg", "无数据");
		}
		map.put("data", data);
		return map;
	}

	/****
	 * 给学生分配咨询师
	 */
	@RequestMapping("allotCounselor")
	public boolean allotCounselor(Student student) {
		return ss.allotCounselor(student);
	}

	/****
	 * 批量手动分配咨询师
	 */
	@RequestMapping("allotManyToCounselor")
	public boolean allotManyToCounselor(Student student, String studentIds) {
		boolean flag = false;
		// 数组化
		String[] arr = studentIds.split(",");
		for (int i = 0; i < arr.length; i++) {
			// 设置学生id
			student.setStudnetId(arr[i]);
			flag = ss.allotCounselor(student);
		}
		return flag;
	}

	/***
	 * 自动分配咨询师（依次平均分配）
	 */
	@RequestMapping("autoAllotCounselor")
	public boolean autoAllotCounselor(Student student, String studentIds) {
		boolean flag = false;
		// 获取所有咨询师用户
		List<User> counselors = ss.getAllCounselorUser("咨询师");
		// 数组化
		String[] arr = studentIds.split(",");
		// 移除未开启自动分量的咨询师用户
		for (int i = 0; i < counselors.size(); i++) {
			if ("false".equals(counselors.get(i).getUAutoAllot())) {
				counselors.remove(counselors.get(i));
				/**
				 * 一旦集合移除某个元素，集合size减一，
				 * (移除元素后的集合)的下标为i的元素被原集合的小标为i+1的元素替代
				 * 所以需要再次遍历下标为i的元素
				 */
				i-=1;
			}
		}
		// 咨询师集合的下标
		int c = 0;
		for (int i = 0; i < arr.length; i++, c++) {
			// 设置学生id
			student.setStudnetId(arr[i]); // 防止下标越界
			if (c >= counselors.size()) {
				c = 0;
			} // 设置分配的咨询师id
			student.setUserId2(counselors.get(c).getUserId());
			flag = ss.allotCounselor(student);
		}
		return flag;
	}
	
	/***
	   * 拥有咨询师角色的用户查询该用户下负责的所有学生
	   * 
	   * @param student
	   * @param page
	   * @param limit
	   * @return
	   */
	  @RequestMapping("getStudentsByUserId2")
	  public Map<String, Object> getStudentsByUserId2(Student student, User user, TimeToSearch dfs, Integer page,
	      Integer limit) {
	    Map<String, Object> map = new HashMap<String, Object>();
	    page = page == null ? 0 : (page - 1) * limit;
	    limit = limit == null ? 10 : limit;
	    map.put("page", page);
	    map.put("limit", limit);
	    map.put("student", student);
	    map.put("user", user);
	    map.put("dfs", dfs);
	    return ss.getStudentsByUserId(map);
	  }
	  
	  /**
	   * 根据用户id获取用户负责的学生
	   * @param user
	   * @return
	   */
	  @RequestMapping("/getFollowAllStudentByUserId")
	  public Map<String, Object> getFollowAllStudentByUserId(String userId,String studentName,Integer page,Integer limit){
		  page = page == null ? 0 : (page - 1) * limit;
		  limit = limit == null ? 10 : limit;
		  return ss.getFollowAllStudentByUserId(userId,studentName,page,limit);
	  }
}
