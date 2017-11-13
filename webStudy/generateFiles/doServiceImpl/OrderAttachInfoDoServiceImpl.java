package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.OrderAttachInfoPo;
import com.yu.study.dos.OrderAttachInfoDo;
import com.yu.study.service.dos.OrderAttachInfoDoService;

@Service
public class OrderAttachInfoDoServiceImpl extends BaseDoServiceImpl<OrderAttachInfoDo,OrderAttachInfoPo> implements OrderAttachInfoDoService{

	@Override
	public String getIdentifierName() {
		return "orderAttachUid";
	}
}
