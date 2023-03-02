package com.wk68.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wk68.entity.DynamicMessage;

public interface DynamicMessageService {

	List<DynamicMessage> getDynamicMessagesByCounselor(DynamicMessage dm);

	boolean invertDMReadByDMId(DynamicMessage dm);

}
