package com.yu.webstudy.responseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/responsestatus")
public class ResponseStatusTestController {
	@RequestMapping(value="",method = RequestMethod.GET)
	@ResponseBody
	public void test(HttpServletRequest request,HttpServletResponse response){
		throw new UserNotMatchException();
	}
}