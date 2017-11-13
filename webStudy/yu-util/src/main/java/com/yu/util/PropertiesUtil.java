package com.yu.util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
public class PropertiesUtil {
	
	/**
	 * 获取类路径文件转换为properties对象
	 * @author HQH
	 * @date 2015年9月10日 下午3:10:46
	 * @since 2.6
	 * @param filePath 文件路径
	 * @return
	 */
	public static Properties getClassByProperties(String filePath) {
		Properties props = new Properties();
		ClassPathResource cs = new ClassPathResource(filePath);
		EncodedResource encodedResource = new EncodedResource(cs,"UTF-8");
		Reader reader = null;
		try {
			reader = encodedResource.getReader();
			props.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return props;
	}

	/**
	 * 获取文件信息
	 * @author HQH
	 * @date 2015年9月10日 下午3:11:32
	 * @since 2.6
	 * @param properties properties对象
	 * @return 以map数据结构返回文件信息
	 */
	public static Map<String, String> readProperties(Properties properties) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if(!properties.isEmpty()) {
				Enumeration<?> en = properties.propertyNames();
				while (en.hasMoreElements()) {
					String key = (String) en.nextElement();
					map.put(key, properties.getProperty(key));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 写输入到properties文件
	 * @author HQH
	 * @date 2015年9月10日 下午3:16:59
	 * @since 2.6
	 * @param filePath 文件路径
	 * @param parameterName 键
	 * @param parameterValue 值
	 */
	public static void writeProperties(String filePath, String parameterName, String parameterValue) {
		OutputStream fos = null;
		try {
			ClassPathResource cs = new ClassPathResource(filePath);
			Properties prop = PropertiesUtil.getClassByProperties(filePath);
			fos = new FileOutputStream(cs.getFile());
			prop.setProperty(parameterName, parameterValue);
			prop.store(fos, "save success!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
