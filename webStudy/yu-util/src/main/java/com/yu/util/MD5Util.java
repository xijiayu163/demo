package com.yu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * MD5加密工具�?
 * 
 * @author zous
 * @date 2015-05-05
 */
public class MD5Util {

	/**
	 * MD5 加密(32�?
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			} else {
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}

		}

		return md5StrBuff.toString();
	}

	// 签名生成方法
	public static String getSign(String id, String timestamp, String password) {
		return getMD5Str(id + timestamp + password);
	}

	/**
	 * 两次MD5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getTwoMD5Str(String str) {
		return getMD5Str(getMD5Str(str));
	}
	
	/**
	 * 获取随机加密密码
	 * @author Wangxinglong
	 * @date 2017年2月14日 上午10:58:45
	 * @since 4.1
	 * @return
	 */
	public static String getRandomPassWord(){
		return getTwoMD5Str(getRandom());
	}
	
	//生成随6位机数
	private static String getRandom() {
		Random random = new Random();
		return String.format("%s%s%s%s%s%s", random.nextInt(9), random.nextInt(9), random.nextInt(9), random.nextInt(9),random.nextInt(9),random.nextInt(9));

	}
	
	public static void main(String[] args) {
		System.out.println(MD5Util.getSign("20170717164740629-319882bfb9d047359fe55b47e78de191", "20170911120000", "14e1b600b1fd579f47433b88e8d85291"));
	}
	
}
