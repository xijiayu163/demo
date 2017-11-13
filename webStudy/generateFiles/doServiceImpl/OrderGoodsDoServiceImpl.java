package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderGoodsPo;
import com.yu.study.dos.OrderGoodsDo;
import com.yu.study.service.dos.OrderGoodsDoService;

@Service
public class OrderGoodsDoServiceImpl extends BaseDoServiceImpl<OrderGoodsDo,OrderGoodsPo> implements OrderGoodsDoService{

	@Override
	public String getIdentifierName() {
		return "orderGoodUid";
	}
}
