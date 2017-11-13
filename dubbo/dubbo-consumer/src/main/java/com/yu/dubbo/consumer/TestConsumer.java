package com.yu.dubbo.consumer;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yu.dubbo.entity.User;
import com.yu.dubbo.service.UserService;

@Component
public class TestConsumer {
	@Reference(version="1.0.0")
	private UserService userService;
	
	private void print(){
		User user = userService.getUser("xxx");
		System.out.println(user.getAccountUid());
		System.out.println(user.getCompany());
	}
}
