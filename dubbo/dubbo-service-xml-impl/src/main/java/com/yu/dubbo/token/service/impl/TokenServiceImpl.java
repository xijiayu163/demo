package com.yu.dubbo.token.service.impl;

import com.yu.dubbo.entity.User;
import com.yu.dubbo.token.service.TokenService;

public class TokenServiceImpl implements TokenService{

	@Override
	public User getUser(String accountUid) {
		User user = new User();
		user.setAccountUid("token");
		user.setAge(80);
		
		return user;
	}

}
