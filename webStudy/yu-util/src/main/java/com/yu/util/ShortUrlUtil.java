package com.yu.util;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * 短链接工具类
 * @author LiLanke
 * @date 2017年2月21日-上午9:27:09
 * @since 4.1
 *
 */
public class ShortUrlUtil {
	
	/**
	 * 根据长链接获取短链接
	 * @author LiLanke
	 * @date 2017年2月21日-上午9:26:23
	 * @since 4.1
	 * @param urlLong Url长链接
	 * @return Url短链接
	 */
	public static String getUrlShort(String urlLong){
			//短连接的新浪接口
			//String url="http://api.t.sina.com.cn/short_url/shorten.json?source=3271760578&url_long=http://www.douban.com/note/249723561/";
			String url="http://api.t.sina.com.cn/short_url/shorten.json?source=3271760578&url_long="+urlLong;
			String resul= HttpSendUtil.sendGet(url, null);
			//短连接返回的json数据
			//[{"url_short":"http://t.cn/RJrqvXo","url_long":"http://admin.zlhys.com/index.do","type":0}]
			TypeReference<HashMap<String, Object>> typeRef =new TypeReference<HashMap<String,Object>>() {};
			HashMap<String, Object> map = new HashMap<String, Object>();
			resul=resul.replace("[", "").replace("]", "");
			try {
				map=JsonUtil.rtisJson2Obj(resul, typeRef);
				return map.get("url_short").toString();
			} catch (IOException e) {
				return urlLong;
			}
	}
}
