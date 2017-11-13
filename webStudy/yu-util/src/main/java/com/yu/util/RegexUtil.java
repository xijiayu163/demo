package com.yu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java中一些字符串的正则校验
 * @author Wangxinglong
 * @version V3.6
 * @date 2016年9月18日 上午9:19:19
 */
public class RegexUtil {
	/**
	 * 邮箱的正则校验
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月18日 上午9:22:58
	 * @param email
	 * @return 符合格式返回true，不符合格式返回false
	 */
	public static boolean matcherEmail(String email){
		Pattern pattern = Pattern.compile("[//w//.//-]+@([//w//-]+//.)+[//w//-]+",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		boolean result = matcher.matches();
		return result;
		
	}
	
	/**
	 * 电话号码的正则校验
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月18日 上午9:49:46
	 * @param phoneNo
	 * @return 符合格式返回true，不符合格式返回false
	 */
	public static boolean matcherPhone(String phoneNo){
		Pattern pattern = Pattern.compile("^1[3578]\\d{9}");
		Matcher matcher = pattern.matcher(phoneNo);
		boolean result = matcher.matches();
		return result;
	}
	
	/**
	 * 电话号码校验返回一个list集合
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月19日 下午3:43:43
	 * @param phoneNoList
	 * @return 
	 */
	public static List<String> matcherPhoneList(List<String> phoneNoList){
		List<String> resList = new ArrayList<String>();
		for (String phoneNo : phoneNoList) {
			if(matcherPhone(phoneNo)){
				resList.add(phoneNo);
			}
		}
		return phoneNoList;
	}
	
	
	
}
