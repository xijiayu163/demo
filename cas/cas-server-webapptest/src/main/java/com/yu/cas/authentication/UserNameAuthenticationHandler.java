package com.yu.cas.authentication;

import java.security.GeneralSecurityException;

import javax.security.auth.login.FailedLoginException;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;

public class UserNameAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler{
	
	@Override
	protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential)
			throws GeneralSecurityException, PreventedException {
		
		final String username = credential.getUsername();

        final String encodedPassword = this.getPasswordEncoder().encode(credential.getPassword());
        
        if(username.equals("xijia") && credential.getPassword().equals("xijia")){
        	return createHandlerResult(credential, new SimplePrincipal(username), null);
        }else{
        	throw new FailedLoginException();
        }
	}
	
}
