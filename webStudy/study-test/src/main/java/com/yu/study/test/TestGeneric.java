package com.yu.study.test;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	private List<String> list = new ArrayList<>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	} 
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		ParameterizedType parameterizedType = (ParameterizedType) list.getClass().getGenericSuperclass();
		 Class<?> clazz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
		 System.out.println(clazz);
		 
	}
}
