package com.wk68.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.UserChecks;
import com.wk68.service.UserChecksService;
import com.wk68.util.PoiUtils;

@RestController
@RequestMapping("/excelUCC")   
public class ExcelUCController {
    
	@Autowired
	private UserChecksService ucs;
	
	@GetMapping("/outexceldaka")
	public void testExcel(HttpServletResponse response,String ids) {
		System.out.println("ids"+"----------------"+ids);
		
		String downloadName = "打卡.xls";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel"); //指明响应文件为excel类型
		ServletOutputStream out = null;
		
		//1、通过前端传来的数据生成Excel
		//2、通过前端传来的id
		
		List<UserChecks> sList = new ArrayList<UserChecks>();
		String[] ucId=ids.split(",");
		System.out.println("ucId"+ucId.length);
		if(ids != null && ids != "") {
			for(int i =0; i<ucId.length; i++) {
				//同过遍历取出字符串的每一个id
				String id=ucId[i];
				List<UserChecks> uc = ucs.findById(id);
				System.out.println(uc);
				sList.add(uc.get(0));
			}
			System.out.println("slist==="+sList);
		}else {
			sList = ucs.findAll();
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
			System.out.println("ppppppp导出"+p);
			p.createExcel(sList,UserChecks.class, out);
			System.out.println(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
}
