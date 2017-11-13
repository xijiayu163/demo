package com.yu.util;

public class IntegerUtils {
	public static boolean isZero(Integer param){
		if (param == null || param == 0) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isNotZero(Integer param){
		return !isZero(param);
	}
	
	public static int getValue(Integer param){
		if (param == null) {
			return 0;
		}
		
		return param;
	}
}
