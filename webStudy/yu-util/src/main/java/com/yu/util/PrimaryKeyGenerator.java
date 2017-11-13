package com.yu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 主键生成器
 *
 * @author yuxijia
 * @date 2016年12月1日 
 * @since 3.8.0
 *
 */
public class PrimaryKeyGenerator {
	/**
	 * 生成主键,主键格式为yyyyMMddhhmmssfff-32位GUID 例如20160822154439756-be5447ede3e84412b7872dd86cdad62c
	 *
	 * @author yuxijia
	 * @date 2016年12月1日 
	 * @since 3.8.0
	 *
	 * @return
	 */
	public static String generatePrimaryKey(){
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateStr = sdf.format(dt);
		return dateStr+"-"+UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
	
	/**
	 * 根据主键获取前面的日期部分字符串
	 *
	 * @author yuxijia
	 * @date 2016年12月1日 
	 * @since 3.8.0
	 *
	 * @param key 主键字符串
	 * @return
	 */
	public static String getDateString(String key){
		return key.substring(0,17);
	}
	
	/**
	 * 根据主键获取后面的GUID
	 *
	 * @author yuxijia
	 * @date 2016年12月1日 
	 * @since 3.8.0
	 *
	 * @param key 主键字符串
	 * @return
	 */
	public static String getUUKey(String key){
		return key.substring(18);
	}
}
