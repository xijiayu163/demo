package com.yu.study.service.dos.impl;

import org.springframework.stereotype.Service;
import com.yu.study.common.service.BaseDoServiceImpl;
import com.yu.study.dao.po.UserPo;
import com.yu.study.dos.UserDo;
import com.yu.study.service.dos.UserDoService;

@Service
public class UserDoServiceImpl extends BaseDoServiceImpl<UserDo,UserPo> implements UserDoService{

	@Override
	public String getIdentifierName() {
		return "accountUid";
	}
}
