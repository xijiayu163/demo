package com.yu.webstudy.exception.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.yu.webstudy.exception.customexception.UserNameNotMatchPasswordException;

@Controller
@RequestMapping("/user")
public class UserController{
	@RequestMapping(value="",method = RequestMethod.GET)
	@ResponseBody
	public void getUsers(HttpServletRequest request) throws IllegalAccessException, NoSuchRequestHandlingMethodException, HttpRequestMethodNotSupportedException{
//		throw new IllegalAccessException("抛出了异常");
	      throw new UserNameNotMatchPasswordException();
//		throw new HttpRequestMethodNotSupportedException("getUsers");
	}
}
