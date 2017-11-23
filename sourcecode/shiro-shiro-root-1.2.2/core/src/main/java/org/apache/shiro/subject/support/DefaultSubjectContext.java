/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shiro.subject.support;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.MapContext;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Default implementation of the {@link SubjectContext} interface.  Note that the getters and setters are not
 * simple pass-through methods to an underlying attribute;  the getters will employ numerous heuristics to acquire
 * their data attribute as best as possible (for example, if {@link #getPrincipals} is invoked, if the principals aren't
 * in the backing map, it might check to see if there is a subject or session in the map and attempt to acquire the
 * principals from those objects).
 *
 * @since 1.0
 */
public class DefaultSubjectContext extends MapContext implements SubjectContext {

    private static final String SECURITY_MANAGER = DefaultSubjectContext.class.getName() + ".SECURITY_MANAGER";

    private static final String SESSION_ID = DefaultSubjectContext.class.getName() + ".SESSION_ID";

    private static final String AUTHENTICATION_TOKEN = DefaultSubjectContext.class.getName() + ".AUTHENTICATION_TOKEN";

    private static final String AUTHENTICATION_INFO = DefaultSubjectContext.class.getName() + ".AUTHENTICATION_INFO";

    private static final String SUBJECT = DefaultSubjectContext.class.getName() + ".SUBJECT";

    private static final String PRINCIPALS = DefaultSubjectContext.class.getName() + ".PRINCIPALS";

    private static final String SESSION = DefaultSubjectContext.class.getName() + ".SESSION";

    private static final String AUTHENTICATED = DefaultSubjectContext.class.getName() + ".AUTHENTICATED";

    private static final String HOST = DefaultSubjectContext.class.getName() + ".HOST";

    public static final String SESSION_CREATION_ENABLED = DefaultSubjectContext.class.getName() + ".SESSION_CREATION_ENABLED";

    /**
     * The session key that is used to store subject principals.
     */
    public static final String PRINCIPALS_SESSION_KEY = DefaultSubjectContext.class.getName() + "_PRINCIPALS_SESSION_KEY";

    /**
     * The session key that is used to store whether or not the user is authenticated.
     */
    public static final String AUTHENTICATED_SESSION_KEY = DefaultSubjectContext.class.getName() + "_AUTHENTICATED_SESSION_KEY";

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public DefaultSubjectContext() {
        super();
    }

    public DefaultSubjectContext(SubjectContext ctx) {
        super(ctx);
    }

    public SecurityManager getSecurityManager() {
        return getTypedValue(SECURITY_MANAGER, SecurityManager.class);
    }

    public void setSecurityManager(SecurityManager securityManager) {
        nullSafePut(SECURITY_MANAGER, securityManager);
    }

    public SecurityManager resolveSecurityManager() {
        SecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            if (log.isDebugEnabled()) {
                log.debug("No SecurityManager available in subject context map.  " +
                        "Falling back to SecurityUtils.getSecurityManager() lookup.");
            }
            try {
                securityManager = SecurityUtils.getSecurityManager();
            } catch (UnavailableSecurityManagerException e) {
                if (log.isDebugEnabled()) {
                    log.debug("No SecurityManager available via SecurityUtils.  Heuristics exhausted.", e);
                }
            }
        }
        return securityManager;
    }

    public Serializable getSessionId() {
        return getTypedValue(SESSION_ID, Serializable.class);
    }

    public void setSessionId(Serializable sessionId) {
        nullSafePut(SESSION_ID, sessionId);
    }

    public Subject getSubject() {
        return getTypedValue(SUBJECT, Subject.class);
    }

    public void setSubject(Subject subject) {
        nullSafePut(SUBJECT, subject);
    }

    public PrincipalCollection getPrincipals() {
        return getTypedValue(PRINCIPALS, PrincipalCollection.class);
    }

    public void setPrincipals(PrincipalCollection principals) {
        if (!CollectionUtils.isEmpty(principals)) {
            put(PRINCIPALS, principals);
        }
    }

    public PrincipalCollection resolvePrincipals() {
        PrincipalCollection principals = getPrincipals();

        if (CollectionUtils.isEmpty(principals)){
        	log.debug("当前上下文缓存中(backmap)没有principals");
        }else{
        	if (log.isDebugEnabled()) {
        		log.debug("当前上下文缓存中(backmap)有principals");
            }
        }
        
        if (CollectionUtils.isEmpty(principals)) {
        	if (log.isDebugEnabled()) {
        		log.debug("当前上下文缓存中(backmap)没有principals，从缓存中(backmap)中查看是否有授权信息");
            }
            //check to see if they were just authenticated:
            AuthenticationInfo info = getAuthenticationInfo();
            if (info != null) {
            	if (log.isDebugEnabled()) {
            		log.debug("当前上下文缓存中(backmap)有授权信息，从授权信息中获取principals");
                }
            	principals = info.getPrincipals();
            	
            	if (CollectionUtils.isEmpty(principals)){
                	log.debug("当前授权信息中没有principals");
                }else{
                	if (log.isDebugEnabled()) {
                		log.debug("当前授权信息中有principals");
                    }
                }
            }
        }

        if (CollectionUtils.isEmpty(principals)) {
        	if (log.isDebugEnabled()) {
        		log.debug("principals身份信息为空，尝试从缓存中(backmap)中查找Subject。");
            }
            Subject subject = getSubject();
            if (subject != null) {
            	if (log.isDebugEnabled()) {
            		log.debug("缓存中(backmap)Subject找到，尝试从这个subject中获取principals信息。");
                }
                principals = subject.getPrincipals();
                
                if (CollectionUtils.isEmpty(principals)){
                	log.debug("当前subject信息中没有principals");
                }else{
                	if (log.isDebugEnabled()) {
                		log.debug("当前subject信息中有principals");
                    }
                }
            }
        }

        if (CollectionUtils.isEmpty(principals)) {
            //try the session:
        	if (log.isDebugEnabled()) {
        		log.debug("尝试从session中查找principals信息");
            }
            Session session = resolveSession();
            if (session != null) {
                principals = (PrincipalCollection) session.getAttribute(PRINCIPALS_SESSION_KEY);
                if (log.isDebugEnabled()) {
            		log.debug("session不为空，从session中查找到的principals信息"+principals);
                }
            }
        }

        return principals;
    }


    public Session getSession() {
        return getTypedValue(SESSION, Session.class);
    }

    public void setSession(Session session) {
        nullSafePut(SESSION, session);
    }

    public Session resolveSession() {
        Session session = getSession();
        if (session == null) {
            //try the Subject if it exists:
            Subject existingSubject = getSubject();
            if (existingSubject != null) {
                session = existingSubject.getSession(false);
            }
        }
        return session;
    }

    public boolean isSessionCreationEnabled() {
        Boolean val = getTypedValue(SESSION_CREATION_ENABLED, Boolean.class);
        return val == null || val;
    }

    public void setSessionCreationEnabled(boolean enabled) {
        nullSafePut(SESSION_CREATION_ENABLED, enabled);
    }

    public boolean isAuthenticated() {
        Boolean authc = getTypedValue(AUTHENTICATED, Boolean.class);
        return authc != null && authc;
    }

    public void setAuthenticated(boolean authc) {
        put(AUTHENTICATED, authc);
    }

    public boolean resolveAuthenticated() {
        Boolean authc = getTypedValue(AUTHENTICATED, Boolean.class);
        if (authc == null) {
            //see if there is an AuthenticationInfo object.  If so, the very presence of one indicates a successful
            //authentication attempt:
            AuthenticationInfo info = getAuthenticationInfo();
            authc = info != null;
        }
        if (!authc) {
            //fall back to a session check:
            Session session = resolveSession();
            if (session != null) {
                Boolean sessionAuthc = (Boolean) session.getAttribute(AUTHENTICATED_SESSION_KEY);
                authc = sessionAuthc != null && sessionAuthc;
            }
        }

        return authc;
    }

    public AuthenticationInfo getAuthenticationInfo() {
        return getTypedValue(AUTHENTICATION_INFO, AuthenticationInfo.class);
    }

    public void setAuthenticationInfo(AuthenticationInfo info) {
        nullSafePut(AUTHENTICATION_INFO, info);
    }

    public AuthenticationToken getAuthenticationToken() {
        return getTypedValue(AUTHENTICATION_TOKEN, AuthenticationToken.class);
    }

    public void setAuthenticationToken(AuthenticationToken token) {
        nullSafePut(AUTHENTICATION_TOKEN, token);
    }

    public String getHost() {
        return getTypedValue(HOST, String.class);
    }

    public void setHost(String host) {
        if (StringUtils.hasText(host)) {
            put(HOST, host);
        }
    }

    public String resolveHost() {
        String host = getHost();

        if (host == null) {
            //check to see if there is an AuthenticationToken from which to retrieve it:
            AuthenticationToken token = getAuthenticationToken();
            if (token instanceof HostAuthenticationToken) {
                host = ((HostAuthenticationToken) token).getHost();
            }
        }

        if (host == null) {
            Session session = resolveSession();
            if (session != null) {
                host = session.getHost();
            }
        }

        return host;
    }
}
