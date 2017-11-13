package com.yu.util;

import javax.servlet.http.HttpServletRequest;

public class ServletThreadLocalUtils {

	private static final ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	
	public static void setRequest(HttpServletRequest request){
		requestLocal.remove();
		requestLocal.set(request);
	}
	
	public static HttpServletRequest getRequest(){
		return requestLocal.get();
	}

}
