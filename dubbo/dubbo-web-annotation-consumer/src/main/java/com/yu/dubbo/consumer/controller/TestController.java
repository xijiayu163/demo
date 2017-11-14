package com.yu.dubbo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yu.dubbo.consumer.localservice.LocalStudentService;
import com.yu.dubbo.entity.Student;
import com.yu.dubbo.entity.User;
import com.yu.dubbo.service.UserService;

@Controller
@RequestMapping("/dubbo")
public class TestController {
	@Reference
	private UserService userService;
	@Autowired
	private LocalStudentService localStudentService;
	
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
}
