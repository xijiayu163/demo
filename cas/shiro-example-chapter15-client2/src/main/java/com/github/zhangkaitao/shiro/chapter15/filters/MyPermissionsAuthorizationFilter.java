package com.github.zhangkaitao.shiro.chapter15.filters;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyPermissionsAuthorizationFilter extends AuthorizationFilter{
	
	private static String redirectToLoginWhenNoPermission = "logout";
	private static String redirectToWarnWhenNoPermission = "warn";
	private String loginWarnUrl = null;
	
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		 Subject subject = getSubject(request, response);
		 String servletPath = ((HttpServletRequest)request).getServletPath();
		 if(!subject.isRemembered()){
			 return subject.isPermitted(servletPath);
		 }else{	
			 //如果是记住我状态，不允许访问非严格校验的资源，并重定向到登录界面
			 String needStrictlyVerified = isNeedStrictlyVerified(request);
			 if(needStrictlyVerified==null){
				 return true;
			 }else {
				 return false;
			 }
		 }
	}
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException{
		Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            saveRequestAndRedirectToLogin(request, response);
        } else {
        	String needStrictlyVerified = isNeedStrictlyVerified(request);
        	if(needStrictlyVerified.equals(redirectToLoginWhenNoPermission)){
        		//String redirectUrl = "http://192.168.1.4:8080/chapter15-server/logout";
//    	        try {
//    	            subject.logout();
//    	        } catch (SessionException ise) {
//    	            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
//    	        }
//    	        saveRequest(request);
    	        WebUtils.issueRedirect(request, response, getLoginWarnUrl());
        	}else{
              String unauthorizedUrl = getUnauthorizedUrl();
              if (StringUtils.hasText(unauthorizedUrl)) {
                  WebUtils.issueRedirect(request, response, unauthorizedUrl);
              } 
        	}
        }
        return false;
	}
	
	private String isNeedStrictlyVerified(ServletRequest request){
		if(((HttpServletRequest)request).getServletPath().equals("/needauth.jsp")){
			return redirectToLoginWhenNoPermission;
		}else if (((HttpServletRequest)request).getServletPath().equals("/needauthonlyshowwarn.jsp")){
			return redirectToWarnWhenNoPermission;
		}else{
			return null;
		}
	}

	public String getLoginWarnUrl() {
		return loginWarnUrl;
	}

	public void setLoginWarnUrl(String loginWarnUrl) {
		this.loginWarnUrl = loginWarnUrl;
	}
	
}
