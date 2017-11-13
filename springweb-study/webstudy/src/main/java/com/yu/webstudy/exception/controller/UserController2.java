package com.yu.webstudy.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user2")
public class UserController2{
	@RequestMapping(value="",method = RequestMethod.GET)
	@ResponseBody
	public void getUsers() throws IllegalAccessException{
		throw new IllegalAccessException("抛出了异常");
	}
}
