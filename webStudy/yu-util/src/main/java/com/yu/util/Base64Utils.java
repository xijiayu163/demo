package com.yu.util;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {
	
	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	public static String encodeToString(byte[] src) {
		if (src == null) {
			return null;
		}
		if (src.length == 0) {
			return "";
		}
		
		return new String(Base64.encodeBase64(src), DEFAULT_CHARSET);
	}
}
