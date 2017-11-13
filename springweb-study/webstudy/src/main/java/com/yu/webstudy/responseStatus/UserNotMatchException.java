package com.yu.webstudy.responseStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="用户不匹配")
public class UserNotMatchException extends RuntimeException{
	
}
