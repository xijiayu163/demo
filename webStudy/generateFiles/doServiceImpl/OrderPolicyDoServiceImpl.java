package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderPolicyPo;
import com.yu.study.dos.OrderPolicyDo;
import com.yu.study.service.dos.OrderPolicyDoService;

@Service
public class OrderPolicyDoServiceImpl extends BaseDoServiceImpl<OrderPolicyDo,OrderPolicyPo> implements OrderPolicyDoService{

	@Override
	public String getIdentifierName() {
		return "policyUid";
	}
}
