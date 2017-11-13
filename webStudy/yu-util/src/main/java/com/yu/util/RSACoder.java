package com.yu.util;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * RSA安全编码组件
 * @author 张超
 * @date 2015年8月13日 下午2:36:42
 * @since 2.6
 *
 */
public abstract class RSACoder {
	
	private static final Log log = LogFactory.getLog(RSACoder.class);
	
	static{
		log.info("addProvider: " + BouncyCastleProvider.class.getName());
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * 非对称加密算法
	 */
	private static final String KEY_ALGORITHM = "RSA";
	//算法提供商
	private static final String BC = "BC";
	//公钥
	private static final String PUBLIC_KEY = "rsa_public_key";
	//私钥
	private static final String PRIVATE_KEY = "rsa_private_key";
	
	/**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
     
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;
	
	/**
	 * RSA密钥长度
	 * 默认1024位，
	 * 密钥长度必须是64的倍数，
	 * 范围长度512-65536位之间。
	 */
	private static final int KEY_SIZE = 1024;
	
	/**
	 * 私钥解密
	 * @param data 待解密数据
	 * @param key 私钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrytByPrivateKey(byte[] data, byte[] key)throws Exception{
		//取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		//生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		//对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm(), BC);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
//		return cipher.doFinal(data);
		
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
//        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
	}
	
	/**
	 * 私钥加密
	 * @param data 待加密数据
	 * @param key 私钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, byte[] key)throws Exception{
		//取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		//生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm(), BC);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * 公钥解密
	 * @param data 待解密数据
	 * @param key 公钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decryptByPublickey(byte[] data, byte[] key)throws Exception{
		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 生成公钥
		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm(), BC);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * 公钥加密
	 * @param data 待加密数据
	 * @param key 公钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, byte[] key)throws Exception{
		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 生成公钥
		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm(), BC);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	
	/**
	 * 取得私钥
	 * @param keyMap 密钥Map
	 * @return byte[] 私钥
	 * @throws Exception
	 */
	public static byte[] getPrivateKey(Map<String, Object> keyMap)throws Exception{
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return key.getEncoded();
	}
	
	/**
	 * 取得公钥
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static byte[] getPublicKey(Map<String, Object> keyMap)throws Exception{
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
	
	/**
	 * 初始化密钥
	 * @return Map 密钥Map
	 * @throws Exception
	 */
	public static Map<String, Object> initKey()throws Exception{
		// 实例化密钥对生成器
		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		// 初始化密钥对生成器
		keyGenerator.initialize(KEY_SIZE);
		// 生成密钥对
		KeyPair keypair = keyGenerator.generateKeyPair();
		// 公钥
		RSAPublicKey publicKey = (RSAPublicKey) keypair.getPublic();
		// 私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keypair.getPrivate();
		// 封装密钥
		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}
	
	public static void main(String[] args) throws Exception {
		// 初始化密钥
//		Map<String, Object> keyMap = RSACoder.initKey();
		
		byte[] publicKey = null;
		byte[] privateKey = null;
		
		String publicKeyStr = "";
		
		String privateKeyStr = "";

		
		publicKey = Base64.decodeBase64(publicKeyStr);
		privateKey = Base64.decodeBase64(privateKeyStr);
		
//		System.out.println("公钥:\n" + Base64.encodeBase64String(publicKey));
//		System.out.println("私钥:\n" + Base64.encodeBase64String(privateKey));
		
//		System.out.println("\n---私钥加密--公钥解密---");
//		String inputStr1 = "123456";
//		byte[] data1 = inputStr1.getBytes("utf-8");
//		System.out.println("原文:\n" + inputStr1);
//		// 加密
//		byte[] encodedData1 = RSACoder.encryptByPrivateKey(data1, privateKey);
//		System.out.println("加密后:\n" + Base64.encodeBase64String(encodedData1));
//		// 解密
//		byte[] decodedData1 = RSACoder.decryptByPublickey(encodedData1, publicKey);
//		String outputStr1 = new String(decodedData1, "utf-8");
//		System.out.println("解密后:\n" + outputStr1);
		
		System.out.println("\n---公钥加密--私钥解密---");
//		String inputStr2 = "~!@#$%^&*()';./,\\zdf}{{} 否停hr";
//		byte[] data2 = inputStr2.getBytes("utf-8");
//		System.out.println("原文:\n" + inputStr2);
//		// 加密
//		byte[] encodedData2 = RSACoder.encryptByPublicKey(data2, publicKey);
//		System.out.println("加密后:\n" + Base64.encodeBase64String(encodedData2));
		byte[] encodedData2 = Base64.decodeBase64("D6ivjUt1781ZfFvRfXJvRCYpE4/cFNq+MTfopYj4TJuXpCBxKn3kQ92U/2Kjo+qA34KeIK2/NQE+MJgy1D7lcYJ/1JckuM3F8EFEv9ZwPLbG+0HIuvnFyE7mMFh3JYWpgmwNh+Bn7A/xRFla9SDAq1Y8WlXDFU52tf9XRICTVEc=");
		// 解密
		byte[] decodedData2 = RSACoder.decrytByPrivateKey(encodedData2, privateKey);
		System.out.println("decodedData2 length: " + decodedData2.length);
		System.out.println("解密后:\n" + new String(decodedData2, "utf-8"));
	}
}
