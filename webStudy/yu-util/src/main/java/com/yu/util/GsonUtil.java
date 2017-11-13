package com.yu.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static String toJson(Object obj, Type type) {		
		return gson.toJson(obj, type);		
	}		
	
	public static Object fromJson(String str,Type type){
		return gson.fromJson(str, type);
	}
}  
