package com.yu.webstudy.controllerAdvice;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.http.HttpStatus;

@ControllerAdvice  
public class ControllerAdviceTest {  
  
    @ModelAttribute 
    public User newUser() {  
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");  
        return new User();  
    }  
  
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");  
    }  
  
    //两个联合起来使用 表示拦截UnauthenticatedException类型的异常，并将响应状态码置为HttpStatus.FORBIDDEN
    //如果设置为返回字符串，表示返回一个逻辑视图名，此时HttpStatus.FORBIDDEN不会设置到response,因为返回了视图，后续默认的ResponseStatusExceptionResolver
    //并不会处理该异常，也就不会去设置该响应头了
    @ExceptionHandler(UnauthenticatedException.class)  
    @ResponseStatus(HttpStatus.FORBIDDEN)  
    public void processUnauthenticatedException(NativeWebRequest request, UnauthenticatedException e) {  
        System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");  
//        return "viewName2"; //返回一个逻辑视图名  
    }  
    
//   @ExceptionHandler(Throwable.class)  优先级示例
//   @ResponseStatus(HttpStatus.OK)  
//  public String processCommonException(NativeWebRequest request, Throwable e) {  
//      System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");  
//      return "viewName1"; //返回一个逻辑视图名  
//  }  
}  