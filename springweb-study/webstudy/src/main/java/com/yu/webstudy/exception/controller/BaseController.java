package com.yu.webstudy.exception.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {  
    /** 基于@ExceptionHandler异常处理 */  
    @ExceptionHandler  
    public String exp(HttpServletRequest request, Exception ex) {  
          
        request.setAttribute("ex", ex);  
          
        // 根据不同错误转向不同页面  
        if(ex instanceof IllegalAccessException) {  
            return "IllegalAccessException";  
        }else if(ex instanceof RuntimeException) {  
            return "runtimeException";  
        } else {  
            return "defaultException";  
        }  
    }  
    
    @ExceptionHandler(value=IllegalAccessException.class)
    public String exp2(HttpServletRequest request, Exception ex) {  
        
        request.setAttribute("ex", ex);  
        
        System.out.println("errrrrrrrrrrrrr");
        
        // 根据不同错误转向不同页面  
        if(ex instanceof IllegalAccessException) {  
            return "IllegalAccessException";  
        }else if(ex instanceof RuntimeException) {  
            return "runtimeException";  
        } else {  
            return "defaultException";  
        }  
    }  
    
    
}  