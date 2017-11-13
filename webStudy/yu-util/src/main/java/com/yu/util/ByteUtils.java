package com.yu.util;

public class ByteUtils {

	public static boolean isZero(Byte param){
		if (param == null || param == 0) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isNotZero(Byte param){
		return !isZero(param);
	}
	
	public static int getValue(Byte param){
		if (param == null) {
			return 0;
		}
		
		return param;
	}
}
