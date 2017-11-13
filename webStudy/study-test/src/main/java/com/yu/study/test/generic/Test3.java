package com.yu.study.test.generic;

public class Test3 {
	public <T> void write(T t){
		System.out.println(t.getClass());
	}
	
	public static void main(String[] args) {
		Test3 test3 = new Test3();
		User user = new User();
		test3.write(user);
	}
}
