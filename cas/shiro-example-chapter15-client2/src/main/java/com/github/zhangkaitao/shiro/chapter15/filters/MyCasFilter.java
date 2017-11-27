package com.github.zhangkaitao.shiro.chapter15.filters;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.session.SingleSignOutHandler;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.XmlUtils;

public class MyCasFilter extends CasFilter {

	private static final SingleSignOutHandler handler = new SingleSignOutHandler();

	@Override
	public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
//		super.doFilterInternal(request, response, chain);
		
//		System.out.println("fdsfsdfsd");
//
		if (handler.isTokenRequest((HttpServletRequest) request)) {
			handler.recordSession((HttpServletRequest) request); // 登录，记录session
			super.doFilterInternal(request, response, chain); // 记录完了之后，就调用CasFilter自己的doFilterInternal
			return;
		} else if (handler.isLogoutRequest((HttpServletRequest) request)) {
			final String logoutMessage = CommonUtils.safeGetParameter((HttpServletRequest) request, "logoutRequest");
			final String token = XmlUtils.getTextForElement(logoutMessage, "SessionIndex");
			if (CommonUtils.isNotBlank(token)) {
				HttpSession session = null;
				try {
					Field msField = handler.getSessionMappingStorage().getClass().getDeclaredField("MANAGED_SESSIONS");
					msField.setAccessible(true);
					@SuppressWarnings("unchecked")
					Map<String, HttpSession> MANAGED_SESSIONS = (Map) msField.get(handler.getSessionMappingStorage());
					session = MANAGED_SESSIONS.get(token);
				} catch (Exception e) {
				}

				if (session != null) {
					Enumeration<String> attributeNames = session.getAttributeNames();
					Subject subject = getSubject(request, response);
					SimplePrincipalCollection principalCollection = ((SimplePrincipalCollection) (session.getAttribute(
							"org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY")));
					try {
						Field principalsField = subject.getClass().getSuperclass().getDeclaredField("principals");
						principalsField.setAccessible(true);
						principalsField.set(subject, principalCollection);
					} catch (Exception e) {
					}
					try {
						subject.logout();
					} catch (SessionException ise) {
					}
				}
				
				try{
					handler.destroySession((HttpServletRequest)request);
				}catch(Exception exx){
					
				}
				
				return;
			}else{
				chain.doFilter(request, response);
			}
		}
	}

}
