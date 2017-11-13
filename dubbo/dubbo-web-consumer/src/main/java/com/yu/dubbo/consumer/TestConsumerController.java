package com.yu.dubbo.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.yu.dubbo.entity.User;
import com.yu.dubbo.service.UserService;

@Controller
@RequestMapping("/dubbo")
public class TestConsumerController {
	@Reference
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public User print(){
		User user = userService.getUser("xxx");
		System.out.println(user.getAccountUid());
		System.out.println(user.getCompany());
		return user;
	}
}
