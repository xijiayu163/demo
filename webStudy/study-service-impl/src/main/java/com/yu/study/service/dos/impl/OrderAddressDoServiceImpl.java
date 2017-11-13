package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderAddressPo;
import com.yu.study.dos.OrderAddressDo;
import com.yu.study.service.dos.OrderAddressDoService;

@Service
public class OrderAddressDoServiceImpl extends BaseDoServiceImpl<OrderAddressDo,OrderAddressPo> implements OrderAddressDoService{

	@Override
	public String getIdentifierName() {
		return "adressUid";
	}
}
