package com.yu.util;

/** 
* 2017年2月20日 
* Chatpay 
* zhouqiang
*/

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
'============================================================================ 
'api说明： 
'createSHA1Sign创建签名SHA1 
'getSha1()Sha1签名 
'============================================================================ 
'*/
public class WeiXinShareUtil {

	// 微信公众号开发的随机字串
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.getRandomPassWord();
	}

	// 微信公众号开发的获取时间戳
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	// 创建签名SHA1
	public static String createSHA1Sign(SortedMap<String, String> signParams) throws Exception {
		StringBuffer sb = new StringBuffer();
		Set es = signParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + v + "&");
			// 要采用URLENCODER的原始值！
		}
		String params = sb.substring(0, sb.lastIndexOf("&"));

		return getSha1(params);
	}

	// Sha1签名
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 微信签名，时间戳，随机数，appId
	 * zhouqiang
	 * @param response
	 * @param request
	 * @param JSAPI_TICKET
	 * @param appId
	 */
	public static Map<String, String>  menuShareSignature(HttpServletResponse response, HttpServletRequest request, String ACCESS_TOKEN,
			String appId) {
		String JSAPI_TICKET = getticket(ACCESS_TOKEN);
		String NONCESTR = WeiXinShareUtil.getNonceStr();
		String TIMESTAMP = WeiXinShareUtil.getTimeStamp();

		String url = "";
		url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getServletPath();
		if (request.getQueryString() != null) {
			url += "?" + request.getQueryString();
		}

		String signature = WeiXinShareUtil.getSha1("jsapi_ticket=" + JSAPI_TICKET + "&noncestr=" + NONCESTR + "&timestamp="
				+ TIMESTAMP + "&url=" + url + "");
		Map<String, String> sig = new HashMap<String, String>();

		sig.put("signature", signature);//签名
		sig.put("nonceStr", NONCESTR);//随机数
		sig.put("appId", appId);//微信id
		sig.put("timestamp", TIMESTAMP);//时间戳
		return sig;
	}

	public static String getticket(String ACCESS_TOKEN) {

		String jsapi_ticket = HttpSendUtil.sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket",
				"access_token=" + ACCESS_TOKEN + "&type=jsapi");
		return jsapi_ticket;
	}
}