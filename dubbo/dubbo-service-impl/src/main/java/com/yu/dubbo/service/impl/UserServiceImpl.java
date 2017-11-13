package com.yu.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yu.dubbo.entity.User;
import com.yu.dubbo.service.UserService;

@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService{
	
	public UserServiceImpl(){
		System.out.println("fdsfds");
	}
	
	public User getUser(String accountUid) {
		User user = new User();
		user.setAccountUid("accountUid");
		user.setAge(80);
		
		return user;
	}
	
}
