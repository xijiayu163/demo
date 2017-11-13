package com.yu.webstudy.interceptor.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.WebContentInterceptor;


public class BasicAuthHandlerInterceptorTest extends WebContentInterceptor{
	private static final Log log = LogFactory.getLog(BasicAuthHandlerInterceptorTest.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException{
		try{
			log.info(request.getRequestURI());
			String sessionAuth = (String) request.getSession().getAttribute("auth");  
			if (sessionAuth != null) {  
	            System.out.println("this is next step");
	            return true;
	        } else {  
	            if(!checkHeaderAuth(request, response)){  
	                response.setStatus(401);  
	                response.setHeader("Cache-Control", "no-store");  
	                response.setDateHeader("Expires", 0);  
	                response.setHeader("WWW-authenticate", "Basic Realm=\"xxxx\"");  
	                return false;
	            }             
	        }  
			
			return true;
		}catch(Exception ex){
			throw new ServletException(ex);
		}
	}
	
	private boolean checkHeaderAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {  
		  
        String auth = request.getHeader("Authorization");  
        System.out.println("auth encoded in base64 is " + getFromBASE64(auth));  
          
        if ((auth != null) && (auth.length() > 6)) {  
            auth = auth.substring(6, auth.length());  
  
            String decodedAuth = getFromBASE64(auth);  
            System.out.println("auth decoded from base64 is " + decodedAuth);  
  
            request.getSession().setAttribute("auth", decodedAuth);  
            return true;  
        }else{  
            return false;  
        }  
    }  
	
	private String getFromBASE64(String s) {  
        if (s == null)  
            return null;  

        try {  
            byte[] b = Base64.decodeBase64(s);
            return new String(b);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
}
