package com.yu.dubbo.group.service.impl;

import com.yu.dubbo.entity.User;
import com.yu.dubbo.group.service.GroupService;

public class GroupServiceImpl2 implements GroupService{
	
	public User getUser(String accountUid) {
		User user = new User();
		user.setAccountUid("GroupServiceImpl2");
		user.setAge(80);
		
		return user;
	}
	
}
