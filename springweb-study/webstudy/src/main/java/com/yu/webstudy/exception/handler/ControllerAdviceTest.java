package com.yu.webstudy.exception.handler;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.NativeWebRequest;

import com.yu.webstudy.exception.customexception.UserNameNotMatchPasswordException;

@ControllerAdvice  
public class ControllerAdviceTest {  
  
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");  
    }  
  
    @ExceptionHandler(UserNameNotMatchPasswordException.class)  
    public String processUnauthenticatedException(NativeWebRequest request, UserNameNotMatchPasswordException e) {  
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");  
        return "IllegalAccessException"; //返回一个逻辑视图名  
    }  
}
