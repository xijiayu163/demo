package com.yu.dubbo.consumer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yu.dubbo.consumer.localservice.LocalStudentService;
import com.yu.dubbo.entity.Student;
import com.yu.dubbo.entity.User;
import com.yu.dubbo.group.service.GroupService;
import com.yu.dubbo.service.UserService;
import com.yu.dubbo.stub.service.StubService;
import com.yu.dubbo.token.service.TokenService;
import com.yu.study.common.spring.SpringContextHolder;

@Controller
@RequestMapping("/dubbo")
public class TestController {
	@Autowired
	private UserService userService;
	@Autowired
	private LocalStudentService localStudentService;
	@Autowired
	private StubService stubService;
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	@ResponseBody
	public User testReferenceInController(){
		User user = userService.getUser("xxx");
		System.out.println(user.getAccountUid());
		System.out.println(user.getCompany());
		return user;
	}
	
	
	@RequestMapping(value="/stu",method = RequestMethod.GET)
	@ResponseBody
	public Student testReferenceInService(){
		Student student = localStudentService.getStudent("fdsfd");
		System.out.println(student.getId());
		System.out.println(student.getName());
		return student;
	}
	
	@RequestMapping(value="/group",method = RequestMethod.GET)
	@ResponseBody
	public List<User> testGroup(){
		GroupService groupService1 = (GroupService)SpringContextHolder.getBean("myGroupService1");
		GroupService groupService2 = (GroupService)SpringContextHolder.getBean("myGroupService2");
		
		User user1 = groupService1.getUser("xxx");
		User user2 = groupService2.getUser("xxx");
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		
		return users;
	}
	
	@RequestMapping(value="/stub",method = RequestMethod.GET)
	@ResponseBody
	public String testSub(){
		return stubService.sayHello("hi");
	}
	
	@RequestMapping(value="/token",method = RequestMethod.GET)
	@ResponseBody
	public User testToken(){
		User user = tokenService.getUser("xxx");
		return user;
	}
}
