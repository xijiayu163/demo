package com.yu.study.common.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;

import com.yu.study.common.spring.SpringContextHolder;

public class AbstractController {
	protected Mapper mapper;
	
	protected  Log log = LogFactory.getLog(getClass());
	
	protected Mapper getMapper(){
		if(mapper==null){
			mapper = SpringContextHolder.getBean(Mapper.class);
		}
		return mapper;
	}
}
