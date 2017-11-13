package com.yu.webstudy.interceptor.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/interceptor")
public class HandlerInterceptorTestController {
	@RequestMapping(value="/get",method = RequestMethod.GET)
	@ResponseBody
	public void test(HttpServletRequest request){
		System.out.println("process business....");
		try {
			Map<String, String[]> parameterMap = request.getParameterMap();
			StringBuilder sb = new StringBuilder();
			for(String key:parameterMap.keySet()){
				sb.append(key+":");
				String[] strings = parameterMap.get(key);
				for(String value:strings){
					sb.append(value+",");
				}
				sb.setLength(sb.length()-1);
				sb.append("\r\n");
			}
			
			System.out.println(sb.toString());
			
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		System.out.println("process business end....");
	}
	
	@RequestMapping(value="/post",method = RequestMethod.POST)
	@ResponseBody
	public void post(HttpServletRequest request){
		System.out.println("process business....");
	}
	
}
