package com.wk68.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wk68.entity.DynamicMessage;
import com.wk68.service.DynamicMessageService;
@RestController
@RequestMapping("/dynamicMessage")
@CrossOrigin
public class DynamicMessageController {
	@Autowired
	private DynamicMessageService dms;
	
	/***
	 * 咨询师获取网络咨询师推送的信息(全部)
	 */
	@RequestMapping("getDynamicMessagesByCounselor")
	public List<DynamicMessage> getDynamicMessagesByCounselor(DynamicMessage dm){
		return dms.getDynamicMessagesByCounselor(dm);
	}
	/***
	 * 推送信息未读--->已读
	 */
	@RequestMapping("invertDMReadByDMId")
	public boolean invertDMReadByDMId(DynamicMessage dm) {
		System.out.println(dm);
		return dms.invertDMReadByDMId(dm);
	}
}
