package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderRefundPo;
import com.yu.study.dos.OrderRefundDo;
import com.yu.study.service.dos.OrderRefundDoService;

@Service
public class OrderRefundDoServiceImpl extends BaseDoServiceImpl<OrderRefundDo,OrderRefundPo> implements OrderRefundDoService{

	@Override
	public String getIdentifierName() {
		return "orderRefundUid";
	}
}
