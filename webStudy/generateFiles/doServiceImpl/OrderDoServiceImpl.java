package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderPo;
import com.yu.study.dos.OrderDo;
import com.yu.study.service.dos.OrderDoService;

@Service
public class OrderDoServiceImpl extends BaseDoServiceImpl<OrderDo,OrderPo> implements OrderDoService{

	@Override
	public String getIdentifierName() {
		return "orderUid";
	}
}
