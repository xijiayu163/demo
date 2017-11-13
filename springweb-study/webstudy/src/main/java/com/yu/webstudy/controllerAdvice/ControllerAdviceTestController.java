package com.yu.webstudy.controllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controllerAdvice")
public class ControllerAdviceTestController {
	@RequestMapping(value="",method = RequestMethod.GET)
	@ResponseBody
	public void test(HttpServletRequest request,HttpServletResponse response){
		throw new UnauthenticatedException("xxx");
	}
}
