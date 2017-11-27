/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.zhangkaitao.shiro.chapter15.filters;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.session.SessionMappingStorage;
import org.jasig.cas.client.session.SingleSignOutHandler;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.XmlUtils;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Map;

/**
 * Implements the Single Sign Out protocol.  It handles registering the session and destroying the session.
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.1
 */
public final class MySingleSignOutFilter extends AbstractConfigurationFilter {

    private static final SingleSignOutHandler handler = new SingleSignOutHandler();

    public void init(final FilterConfig filterConfig) throws ServletException {
        if (!isIgnoreInitConfiguration()) {
            handler.setArtifactParameterName(getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
            handler.setLogoutParameterName(getPropertyFromInitParams(filterConfig, "logoutParameterName", "logoutRequest"));
        }
        handler.init();
    }

    public void setArtifactParameterName(final String name) {
        handler.setArtifactParameterName(name);
    }
    
    public void setLogoutParameterName(final String name) {
        handler.setLogoutParameterName(name);
    }

    public void setSessionMappingStorage(final SessionMappingStorage storage) {
        handler.setSessionMappingStorage(storage);
    }
    
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (handler.isTokenRequest(request)) {
            handler.recordSession(request);
        } else if (handler.isLogoutRequest(request)) {
        	final String logoutMessage = CommonUtils.safeGetParameter(request, "logoutRequest");
            final String token = XmlUtils.getTextForElement(logoutMessage, "SessionIndex");
            if (CommonUtils.isNotBlank(token)) {
            	HttpSession session = null;
                try {
                    Field msField = handler.getSessionMappingStorage().getClass().getDeclaredField("MANAGED_SESSIONS");
                    msField.setAccessible(true);
                    Map<String,HttpSession> MANAGED_SESSIONS = (Map)msField.get(handler.getSessionMappingStorage());
                    session = MANAGED_SESSIONS.get(token);
                } catch (Exception e) {
                }
                
                if (session != null) {
                	Enumeration<String> attributeNames = session.getAttributeNames();
                	
                	
                	
                    Subject subject = SecurityUtils.getSubject();
                    SimplePrincipalCollection principalCollection = 
                    		((SimplePrincipalCollection)(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY")));
                    //SimplePrincipalCollection pc = new SimplePrincipalCollection(shiroUser, shiroUser.getName());
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
            }
        	
            handler.destroySession(request);
            
            
            
            
            // Do not continue up filter chain
            return;
        } else {
            log.trace("Ignoring URI " + request.getRequestURI());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        // nothing to do
    }
    
    protected static SingleSignOutHandler getSingleSignOutHandler() {
        return handler;
    }
}
