package com.wk68.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wk68.entity.DynamicMessage;
import com.wk68.mapper.DynamicMessageMapper;
import com.wk68.service.DynamicMessageService;

@Service
public class DynamicMessageServiceImpl implements DynamicMessageService {

	@Autowired
	private DynamicMessageMapper dmm;

	@Override
	public List<DynamicMessage> getDynamicMessagesByCounselor(DynamicMessage dm) {

		return dmm.getDynamicMessagesByCounselor(dm);
	}

	@Override
	public boolean invertDMReadByDMId(DynamicMessage dm) {
		Integer num = 0;
		boolean flag = false;
		num = dmm.invertDMReadByDMId(dm);
		if(num > 0) {
			flag = true;
		}
		return flag;
	}

}
