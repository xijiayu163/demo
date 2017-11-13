package com.yu.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 3DES加密解密的工具类
 * （易加医的加密算法）
 * @author LiLanke
 * @date 2017年3月27日-下午3:59:20
 * @since 4.2
 *
 */
public class DESUtils {

    //定义加密算法，有DES、DESede(即3DES)、Blowfish
    private static final String Algorithm = "DESede";

//    //加密使用方式
//    public static void main(String[] args) throws UnsupportedEncodingException {
//    	String name=URLEncoder.encode("蘑菇", "UTF-8");
//    	String urlString="appid=123456789&name="+name+"&mobile=13000000001";
//        System.out.println(getMd5(encryptMode(urlString.getBytes("utf-8"), "45et5b2f-3fc6-4854-8c00-erta6e12c4bb")));
//    }
    /**
     * 加密方法
     * @param src 源数据的字节数组
     * @return
     */
    public static byte[] encryptMode(byte[] src,String cryptKey) {
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(cryptKey), Algorithm);    //生成密钥
            Cipher c1 = Cipher.getInstance(Algorithm);    //实例化负责加密/解密的Cipher工具类
            c1.init(Cipher.ENCRYPT_MODE, deskey);    //初始化为加密模式
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }


    /**
     * 解密函数
     * @param src 密文的字节数组
     * @return
     */
    public static byte[] decryptMode(byte[] src,String cryptKey) {
        try {
            SecretKey deskey = new SecretKeySpec(build3DesKey(cryptKey), Algorithm);
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);    //初始化为解密模式
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }


    /*
     * 根据字符串生成密钥字节数组
     * @param keyStr 密钥字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException {
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组

        /*
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if(key.length > temp.length){
            //如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, temp.length);
        }else{
            //如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }

    public static String getMd5(byte[] plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText);
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
