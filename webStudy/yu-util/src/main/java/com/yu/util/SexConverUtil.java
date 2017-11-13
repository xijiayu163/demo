package com.yu.util;

/**
 * 性别名称转换工具类
 * 
 * @author 张超
 * @date 2016年3月22日-下午5:41:44
 * @sinec 3.1.0
 *
 */
public class SexConverUtil {

	public static String enConverCn(String en) {
		if ("M".equals(en)) {
			return "男";
		}
		else if ("F".equals(en)) {
			return "女";
		}
		else if ("男".equals(en)) {
			return "男";
		}
		else if ("女".equals(en)) {
			return "女";
		}
		return "保密";
	}
}
