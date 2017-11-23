package com.github.zhangkaitao.shiro.chapter15.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class MyRolesAuthorizationFilter extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return true;
	}
	
}
