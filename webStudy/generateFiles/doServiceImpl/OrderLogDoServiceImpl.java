package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderLogPo;
import com.yu.study.dos.OrderLogDo;
import com.yu.study.service.dos.OrderLogDoService;

@Service
public class OrderLogDoServiceImpl extends BaseDoServiceImpl<OrderLogDo,OrderLogPo> implements OrderLogDoService{

	@Override
	public String getIdentifierName() {
		return "logUid";
	}
}
