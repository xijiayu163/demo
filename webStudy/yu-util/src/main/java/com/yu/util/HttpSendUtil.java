package com.yu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 以post/get向指定地�?��送数据的工具�?
 * 
 * @author zous
 * @date 2015-01-26
 */
public class HttpSendUtil {

	private static final Log log = LogFactory.getLog(HttpSendUtil.class);

	/**
	 * 向指定URL发�?GET方法的请�?
	 * 
	 * @param url
	 *            发�?请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式�?
	 * @return URL �?��表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			if (!StringUtil.isEmpty(param)) {
				urlNameString += "?" + param;
			}
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连�?
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属�?
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连�?
			connection.connect();
			// 获取�?��响应头字�?
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历�?��的响应头字段
			for (String key : map.keySet()) {
				log.debug(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响�?
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定地址以POST请求 David
	 * 
	 * @param headers
	 *            头部信息
	 * @param sendurl
	 *            请求地址
	 * @param data
	 *            json格式的参数
	 * @return
	 */
	public static String sendPost(Map<String, String> headers, String sendurl,
			String data) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(sendurl);
		// 设置头部信息
		if (headers != null && !headers.isEmpty()) {
			for (String key : headers.keySet()) {
				post.addHeader(key, headers.get(key));
			}
		}
		StringEntity myEntity = new StringEntity(data,
				ContentType.APPLICATION_JSON);// 构造请求数据
		post.setEntity(myEntity);// 设置请求参数
		String responseContent = null; // 响应内容
		CloseableHttpResponse response = null;
		try {
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (client != null)
						client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return responseContent;
	}

	/**
	 * 向指定地址以POST请求
	 * 
	 * @param sendurl
	 *            请求地址
	 * @param data
	 *            json格式的参数
	 * @return
	 */
	public static String sendPost(String sendurl, String data) {
		return sendPost(null, sendurl, data);
	}

}
