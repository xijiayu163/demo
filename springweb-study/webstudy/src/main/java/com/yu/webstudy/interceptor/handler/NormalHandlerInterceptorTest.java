package com.yu.webstudy.interceptor.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class NormalHandlerInterceptorTest {

	public static class NormalHandlerInterceptorTest1 extends HandlerInterceptorAdapter {
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			System.out.println("preHanle1...");
			return true;
		}
		
		public void postHandle(
				HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
				throws Exception {
			System.out.println("postHandle1...");
		}
		
		public void afterCompletion(
				HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			System.out.println("afterCompletion1...");
		}
	}

	public static class NormalHandlerInterceptorTest2 extends HandlerInterceptorAdapter {
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			System.out.println("preHanle2...");
			return false;
		}
		
		public void postHandle(
				HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
				throws Exception {
			System.out.println("postHandle2...");
		}
		
		public void afterCompletion(
				HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			System.out.println("afterCompletion2...");
		}
	}

	public static class NormalHandlerInterceptorTest3 extends HandlerInterceptorAdapter {
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			System.out.println("preHanle3...");
			return true;
		}
		
		public void postHandle(
				HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
				throws Exception {
			System.out.println("postHandle3...");
		}
		
		public void afterCompletion(
				HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			System.out.println("afterCompletion3...");
		}
	}

}
