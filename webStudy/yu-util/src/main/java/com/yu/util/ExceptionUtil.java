package com.yu.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 
 * @author 蔡海佳
 * @date 2015年6月24日 上午9:51:56
 * @since 2.3
 * 
 */
public class ExceptionUtil {
	public static String getStackTrace(Throwable aThrowable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString() + "\r\n";
	}
	
	/**
	 * 如果参数为空，则抛出异常
	 *
	 * @author derek 蔡海佳
	 * @date 2015年9月24日 下午5:57:45
	 *
	 * @param param 参数
	 * @param paramName 参数名
	 */
	public static void throwArgumentExceptionIfNull(Object param, String paramName) {
		if (param == null) {
			throw new IllegalArgumentException(paramName + " can not be null.");	
		}
	}
}
