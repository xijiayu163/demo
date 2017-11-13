package com.yu.dubbo.service.impl;

import com.yu.dubbo.entity.User;
import com.yu.dubbo.service.UserService;

public class UserServiceImpl implements UserService{

	public User getUser(String accountUid) {
		User user = new User();
		user.setAccountUid("accountUid");
		user.setAge(80);
		
		return user;
	}
	
}
