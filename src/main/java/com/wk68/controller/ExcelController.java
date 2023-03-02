package com.wk68.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.wk68.entity.Student;

import com.wk68.service.StudentService;
import com.wk68.util.PoiUtils;


@RestController
@RequestMapping("/excel")
public class ExcelController {


	@Autowired   
	private   StudentService StudentService;
	@GetMapping("/outexcel")
	public void testExcel(HttpServletResponse response, String ids) {
		System.out.println("ids"+"-----------------------------"+ids);
		
		String downloadName = "student.xls";
		response.setCharacterEncoding("UTF-8");// 设置响应的字符编码格式
		response.setContentType("application/vnd.ms-excel");// 指明响应文件为excel类型
		ServletOutputStream out = null;
		
		//1、通过前端传来的数据生成Excel
		//2、通过前端传了来的id
		
		List<Student> sList = new ArrayList<Student>();
		String[] mid=ids.split(","); 
		System.out.println("mid"+mid.length);
		if(ids !=null && ids != "") {
			for(int i =0;i<mid.length;i++) {
				//同过遍历取出字符串里的每个id
				String id=mid[i];
				List<Student> stu = StudentService.findById(id); 
			// stu.get().setMemberships(stu.get().getMemberships().getDepartment());  	;
				sList.add(stu.get(0));
			}
			System.out.println("slist====="+sList);
		}else {
			sList = StudentService.findAll();
		}
		try {
			// 文件名编码处理，防止浏览器下载文件名乱码
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(downloadName.getBytes("GB2312"), "ISO8859-1"));
			out = response.getOutputStream();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PoiUtils p = new PoiUtils();
			System.out.println("pppppppppppppp"+p);
			p.createExcel(sList, Student.class, out);
			System.out.println(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 导入时名称依旧为唯一标识，因此不能重复
	 * @param file
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/importExcel")
	public Map<String, Object> importExcel(@RequestParam(value = "file") MultipartFile file) {
		System.out.println("123");
		Map<String, Object> map=new HashMap<String, Object>();
		String originalFilename = file.getOriginalFilename();// 得到上传文件的名称
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//把上传的Excel文件里的数据解析出来，调用方法，存入数据库
		PoiUtils poiUtils = new PoiUtils();// Excel工具类
		List<Student> list = null;
		Integer student = null;
		try {
			list = (List<Student>) poiUtils.parseExcel(Student.class,
					file.getInputStream(), originalFilename);
			for (Student s : list) {
				
				s.setStudnetId(UUID.randomUUID().toString());
				student = StudentService.addStudentInfo(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(student!=null) {
			map.put("code", 0);
			return map;
		}
		map.put("code", -1);
		return   map;
	}
	
	
	
	
	
	
	
	
	
	
}
