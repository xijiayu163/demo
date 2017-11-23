package com.github.zhangkaitao.shiro.chapter15.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class MyPermissionsAuthorizationFilter extends AuthorizationFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		 Subject subject = getSubject(request, response);
		 String servletPath = ((HttpServletRequest)request).getServletPath();
		 return subject.isPermitted(servletPath);
	}
}
