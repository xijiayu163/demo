package com.yu.webstudy.interceptor.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogRequestHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//该方式只能获取get请求参数,如果需要获取@ResponseBody请求体数据，则只能考虑获取request的inputStream，通过对inputStream进行读取
		//但是因为流一旦读取完就不能再次读了，所以需要写回去，在拦截器中是实现不了的，只能在过滤器中实现
		System.out.println("requestUri:"+request.getRequestURI());
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
		return true;
	}
}