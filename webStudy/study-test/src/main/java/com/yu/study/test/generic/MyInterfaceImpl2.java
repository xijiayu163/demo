package com.yu.study.test.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MyInterfaceImpl2 extends MyInterfaceImpl<User>{

	private Type getTClassType(){
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
		Type type = parameterizedType.getActualTypeArguments()[0];
		return type;
//	    Class<?> clazz = (Class<?>) type;
//	    return clazz;
	}
	
	
	public static void main(String[] args) {
		MyInterface<User> myInterface = new MyInterfaceImpl2();
		myInterface.write(null);
	}

}
