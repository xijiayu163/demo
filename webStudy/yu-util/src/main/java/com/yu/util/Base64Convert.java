package com.yu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Base64Convert {

	private static final Log log = LogFactory.getLog(Base64Convert.class);

	/**
	 * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * 
	 * @param imgFilePath
	 * @return
	 */
	public static String GetImageStr(String imgFilePath) {
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码

		return Base64.encodeBase64String(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 对字节数组字符串进行Base64解码并生成图片
	 * 
	 * @param imgStr
	 * @param imgFilePath
	 * @return
	 */
	public static boolean GenerateImage(String imgStr, String imgFilePath) {
		return GenerateImage(imgStr,imgFilePath,true);
	}
	
	/**
	 * 对字节字符串生成图片
	 * @author LiLanke
	 * @date 2017年4月11日-上午10:21:54
	 * @since 4.2
	 * @param imgStr 图片数据
	 * @param imgFilePath 图片路径
	 * @param isEncrypted 是否加密 true加密，false不加密
	 * @return
	 */
	public static boolean GenerateImage(String imgStr, String imgFilePath,boolean  isEncrypted) {
		if (imgStr == null) // 图像数据为空
			return false;

		try {
			byte[] bytes=null;
			// Base64解码
			if(isEncrypted){
				bytes = Base64.decodeBase64(imgStr);
			}else{
				bytes = imgStr.getBytes();
			}
			
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 判断目录是否存在 不存在则创建
	 * 
	 * @param filePath
	 */
	public static void checkFile(String filePath) {
		File file = new File(filePath);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
	}
}
