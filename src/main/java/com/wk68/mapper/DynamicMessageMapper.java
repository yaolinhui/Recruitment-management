package com.wk68.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wk68.entity.DynamicMessage;

@Repository
public interface DynamicMessageMapper {

	List<DynamicMessage> getDynamicMessagesByCounselor(@Param("dm")DynamicMessage dm);



	Integer invertDMReadByDMId(@Param("dm")DynamicMessage dm);

}