package com.yu.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.StringUtils;


/**
 * AES安全编码组件
 * 
 * @author 张超
 * @date 2015年8月13日 上午10:04:14
 * @since 2.5
 *
 */
public abstract class AESCoder {
	
	private static final Log log = LogFactory.getLog(AESCoder.class);
	
	static{
		log.info("addProvider: " + BouncyCastleProvider.class.getName());
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * 密钥算法
	 */
	public static final String KEY_ALGORITHM = "AES";
	
	/**
	 * 加密/解密算法 / 工作模式 / 填充方式
	 * Java 7 支持PKCS5Padding填充方式
	 * Bouncy Castle支持PKCS7Padding填充方式  http://www.bouncycastle.org/latest_releases.html
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";
	
	/**
	 * 密钥密码
	 */
	private static final String PASSWORD = "szyinozlhys";
	
	/**
	 * 数据库数据AES密钥. 一定不要修改！！！否则数据无法还原。
	 */
	private static final String DB_AES_KEY = "aaaaaabbbbbbccccccddddddeeeeeeff"; // 32*8=256字节
	
	/**
	 * 密钥长度
	 * 可选长度：128、192、256
	 * 默认长度：128
	 * 256长度需要获的无政策限制权限文件(Unlimited Strength Jurisdictiion Policy Files)
	 * 下载对应JDK的文件   http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
	 * 替换下面路径JDK文件(local_policy.jar US_export_policy.jar)：
	 * ${JAVA_HOME}\jre\lib\security
	 * ${JRE_HOME}\lib\security
	 */
	private static final int KEY_SIZE = 256;
	
//	/**
//	 * 生成密钥<br/>
//	 * @return byte[] 二进制密钥
//	 * @throws Exception
//	 */
//	private static byte[] initKey()throws Exception{
//		// 实例化
//		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
////		String isDev = MimspPropertyConfig.getProperty("is_dev_environment");
////		if("true".equalsIgnoreCase(isDev)){
//			SecureRandom secureRandom = new SecureRandom(PASSWORD.getBytes());
////			SecureRandom secureRandom = SecureRandom.getInstance(KEY_ALGORITHM, "BC");
////			secureRandom.setSeed(PASSWORD.getBytes());
////			System.out.println("secureRandom: " + secureRandom.getAlgorithm());
////			System.out.println("secureRandom: " + secureRandom.getProvider().getName() + "\n\t" + secureRandom.getProvider().getInfo());
//			kg.init(KEY_SIZE, secureRandom);
////			kg.init(KEY_SIZE, secureRandom);
////		}
////		else{
////			kg.init(KEY_SIZE);
////		}
//		// 生成密码密钥
//		SecretKey secretKey = kg.generateKey();
//		// 获取密钥的二进制编码形式
//		return secretKey.getEncoded();
//	}
//	
//	/**
//	 * 初始化秘钥
//	 * @return Base64编码密钥
//	 * @throws Exception
//	 */
//	public static String initKeyString()throws Exception{
//		return Base64.encodeBase64String(initKey());
//	}
//	
//	/**
//	 * 获取密钥
//	 * @param key Base64编码密钥
//	 * @return byte[] 密钥
//	 * @throws Exception
//	 */
//	public static byte[] getkey(String key)throws Exception{
//		return Base64.decodeBase64(key);
//	}
	
	/**
	 * 转换密钥
	 * @param key 二进制密钥
	 * @return key 密钥
	 * @throws Exception
	 */
	private static Key toKey(byte[] key)throws Exception{
		//实例化AES密钥材料
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secretKey;
	}
	
	/**
	 * 解密
	 * @param data 待解密数据
	 * @param key 密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key)throws Exception{
		// 还原密钥
		Key k = toKey(key);
		/**
		 * 实例化
		 * 使用PKCS5Padding填充方式，按如下方式实现
		 * Cipher.getInstance(CIPHER_ALGORITHM, "BC")
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		// 初始化，设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, k);
		// 执行操作
		return cipher.doFinal(data);
	}
	
	/**
	 * 解密
	 * @param data 待解密数据
	 * @param key Base64编码的密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String key)throws Exception{
		return decrypt(data, key.getBytes("utf-8"));
	}
	
	/**
	 * 系统数据库AES解密专用
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String data){
		if(!StringUtils.hasLength(data)){
			return data;
		}
		Exception ex = null;
		try {
			return Base64.encodeBase64String(decrypt(data.getBytes("utf-8"), DB_AES_KEY));
		} catch (UnsupportedEncodingException e) {
			ex = e;
		} catch (Exception e) {
			ex= e;
		}
		throw new RuntimeException(ex);
	}
	
	/**
	 * 加密
	 * @param data 待加密数据
	 * @param key 秘钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key)throws Exception{
		// 还原密钥
		Key k = toKey(key);
		/**
		 * 实例化
		 * 使用PKCS5Padding填充方式，按如下方式实现
		 * Cipher.getInstance(CIPHER_ALGORITHM, "BC")
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		// 初始化，设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, k);
		// 执行操作
		return cipher.doFinal(data);
	}
	
	/**
	 * 加密
	 * @param data 待加密的数据
	 * @param key Base64编码的密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String key)throws Exception{
		return encrypt(data, key.getBytes("utf-8"));
	}
	
	/**
	 * 系统数据库AES加密专用
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data){
		if(!StringUtils.hasLength(data)){
			return data;
		}
		Exception ex = null;
		try {
			return Base64.encodeBase64String(decrypt(data.getBytes("utf-8"), DB_AES_KEY));
		} catch (UnsupportedEncodingException e) {
			ex = e;
			e.printStackTrace();
		} catch (Exception e) {
			ex = e;
			e.printStackTrace();
		}
		throw new RuntimeException(ex);
	}
	
//	/**
//	 * 摘要处理
//	 * @param data 待摘要数据
//	 * @return String 摘要字符串
//	 */
//	public static String shaHex(byte[] data){
//		return DigestUtils.md5Hex(data);
//	}
	
//	/**
//	 * 验证
//	 * @param data 待摘要数据
//	 * @param messageDigest 摘要字符串
//	 * @return 验证结果
//	 */
//	public static boolean validate(byte[] data, String messageDigest){
//		return messageDigest.equals(shaHex(data));
//	}
	
	 //生成随机数字和字母,  
	public static String getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			}
			else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static void main(String[] args) throws Exception{
		byte[] contentByte = Base64.decodeBase64("x+STL34gTM4CvlhZefjTAaBRkG5U+pTBKNp4IbdhRgj0a1zx54XYxIRfPQAw6ytQlUbe4QSHSfz32zxSYbEM6M9L7kiRJw59NgIpFP9QT7s=");
		contentByte = AESCoder.decrypt(contentByte, "P6c406x9tMg0h564jXy7Z20CW2bRu171");
		return;
	}
	
	/*
	public static void main(String[] args) throws Exception{
//		String inputStr = 
//				"{\"patientUID\":70000501,\"patientRole\":3,\"serverTime\":\"20150826114140\","
//				+ "\"defaultBoundPatientUID\":70000501,"
//				+ "\"token\":\"7gkD+EDQN7/coBrDRh9PgbV6aWuoPI+Y5v/31KYejne3mfo/FUNfV1M4wGI/oIB2M57uh9LSTxyYhRyGK/cDWH3fnDppBSktGPJC0pavMj0=\","
//				+ "\"patientInfoRes\":{\"patientUID\":70000501,\"patientName\":\"小一\","
//				+ "\"studyNumber\":\"LA000006507\",\"sex\":\"M\",\"age\":45,"
//				+ "\"birthday\":\"19691204220900\",\"inPatientNumber\":\"凤凰传奇\","
//				+ "\"hospital\":\"2.0测试医院\",\"idNumber\":\"凤凰传奇\",\"stepNum\":3,"
//				+ "\"cellPhone\":\"15312356122\",\"referringPhysicianUID1\":\"70000379\","
//				+ "\"referringPhysicianUID2\":\"70000375\",\"courseStatus\":\"定位\"},"
//				+ "\"doctorInfoRes\":{\"doctorUID\":70000375,\"doctorName\":\"樊全荣\","
//				+ "\"sex\":\"M\",\"idNumber\":\"\",\"address\":\"\",\"technicalPostName\":\"医师\","
//				+ "\"positionName\":\"医师\",\"occupationName\":\"放疗医师\",\"hospitalName\":\"2.0测试医院\","
//				+ "\"roleNo\":8},\"serverAesKey\":\"306pZJpEq543649PVL1DjA2T91Q95sd1\"}";
//		
//		byte[] inputData = inputStr.getBytes("utf-8");
//		System.out.println("原文:\t" + inputStr);
		
		// 初始化密钥
		String key = "78c0c7da5d2e322deef989770ebef917";
		//加密
//		inputData = AESCoder.encrypt(inputData, key);
		String test = 
				"8pX49+MTtWG39gA7rabiPikyK9i7bwmd/5Ayd1Qr+ti61mpYTSmSAQmSuiYYWc8bgZaWDCvj5"
				+ "RDR6kJmmbvne5zFJNJs7fhC/tJ0N1CTB6FvcuyGuRLW6NkxwfS8TK3KoIYgNshBmo8674zA"
				+ "5LTbt82VIcpdJFCgqzbZCepBMRkcRQkjObZoWVuALeRywg2lsuUBa/H6na3TceQJNbDnHmG"
				+ "dbHckseOPAGrE6brMIs5o73Fiincx0gRWfNNV5i/jnNxkXvRtf5A6V9B8m24FVuyUj05bqm"
				+ "54qB3Xppc/5XHJ6Bl2n2OBuJj3FCV1eEQWOZZuOh/fHo7pCaJJwdMslDyEIzlsYcD5oVZPF"
				+ "4V4OV5iXHFBbNYyhSt4C2VbclDAe8iIIaASDrz0NftGsCwtlHSEFWHTHhCpS2hGDt1j8h2m"
				+ "MFRD5GtVumKjwDGDLAqrw3J8cFsJjJxqvbApM6Sx0KRSi43IMb9KM845P4Nkwl/TZPkAPno"
				+ "P6/SmCvX+NLgVYL5h1JYb5ILTY5A0qR9GJMiAP727DBYfg+f38qpqmEZtT+XpkZBRlJ0viU"
				+ "hW55TkB8RqH8707D2Joy0hh44iHZXS+RRHO6vyewzgYA9qL+uP/NJTtJvMZ5/KNIjhMZm+y"
				+ "zjCtRAssPuq6iZnN9hI6Vl+1wI2hZtZt0RD7KS127nJVtPE8cplAgoKT4XAFc5D8vUDTZwg"
				+ "qGYjkxeaQ2AmH0rs+v39GuAT3alFfHFOa2s2QhyVAWezRCmM0MUHRHMPlJTwAkdLD9rrQyR"
				+ "DJZ4uX/HTztVzS/WAOrrgMfk2n8t7qFfZx2faE4L7Jc+ZnCXq6WBgxY83n1a+VL8STM7Atc"
				+ "EKll2RyggADLiDiOsG0wd59kuYIw7QHJc5vrc8pcS9w2NoorSdrzfJcUTtKRq8g/yoBrW+o"
				+ "tAKpBt9auPlAADVspwneMrzSz77L0SGytTnvipu2i7nhH3S2Vnxx4Gma6IAxmZgsmZlGXPs"
				+ "yjCNMcQKygD2UvzsVLXH1jw7517mhAw+8CypDkRWga35wPJf70tXOaeE051goGau/UJsKff"
				+ "gy23dGO1VIDcLUd2y2orcXPIDIlZdtNQ3cKZ+NyfOiCNUP1O2qiwfXcXQD1Ax6R9E5cwC2"
				+ "GtYUBE8IopnPsEx";
		byte[] inputData = Base64.decodeBase64(test);
		System.out.println("加密后:\t" + Base64.encodeBase64String(inputData));
		//解密
		byte[] outputData = AESCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.out.println("解密后:\t" + outputStr);
	}
	
	*/
}
