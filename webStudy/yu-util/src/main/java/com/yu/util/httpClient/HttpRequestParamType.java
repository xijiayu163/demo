package com.yu.util.httpClient;

/**
 * http请求参数格式枚举
 *
 * @author ksh 康胜虎
 * @date 2016年8月16日下午4:48:17
 * @since 3.5
 */
public enum HttpRequestParamType {
	/**
	 * xml字符串方式
	 */
	Xml,
	
	/**
	 * json字符串格式
	 */
	Json,
	
	/**
	 * 默认键值对的方式
	 */
	NameValuePair;
}
