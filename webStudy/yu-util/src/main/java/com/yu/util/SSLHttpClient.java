package com.yu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.util.StringUtils;

/**
 * 带证书认证的http请求工具类
 * 
 * @author ksh
 * @date 2016年12月20日
 * @since 3.9
 *
 */
public class SSLHttpClient {
	
	public static final String PKCS12 = "PKCS12";
	public static final String TLSV1 = "TLSv1";
	
	/**
	 * 
	 * SSL通信post请求
	 * 
	 * @author ksh
	 * @date 2016年12月20日
	 * @since 3.9
	 *
	 * @param keyFilePath  证书路劲
	 * @param keyPasswd    证书密码
	 * @param paramString  请求参数
	 * @param paramType    参数类型
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 */
	public static String sslDoPost(String keyFilePath, String keyPasswd, String url, String paramString, ParamType paramType) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
		HttpEntity httpEntity = null;
		if(paramType.equals(ParamType.XML)){
			httpEntity = new StringEntity(paramString, ContentType.create("text/xml", "UTF-8"));
    	}
		
		if(paramType.equals(ParamType.JSON)){
			httpEntity = new StringEntity(paramString, ContentType.APPLICATION_JSON);
		}
		
    	return sslDoPost(keyFilePath, keyPasswd, url, httpEntity);
	}
	
	/**
	 * 
	 * SSL通信post请求
	 * 
	 * @author ksh
	 * @date 2016年12月20日
	 * @since 3.9
	 *
	 * @param keyFilePath 证书路劲
	 * @param keyPasswd   证书密码
	 * @param httpEntity  请求参数对象
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 */
	public static String sslDoPost(String keyFilePath, String keyPasswd, String url, HttpEntity httpEntity) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
		SSLContext sslContext = getSSLContext(keyFilePath, keyPasswd);
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{SSLHttpClient.TLSV1}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
    	
		try {
			HttpPost httpPost = new HttpPost(url);
			
			if(httpEntity != null){
				httpPost.setEntity(httpEntity);
			}
			
			CloseableHttpResponse response = httpClient.execute(httpPost);
			return responseHandler(response);
		} finally{
			httpClient.close();
		}
	}
	
	/**
	 * 
	 * 处理响应流
	 * 
	 * @author ksh
	 * @date 2016年12月20日
	 * @since 3.9
	 *
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private static String responseHandler(CloseableHttpResponse response) throws IOException{
		try {
			HttpEntity entity = response.getEntity();
			
			StatusLine statusLine = response.getStatusLine();
			if(statusLine.getStatusCode() != HttpStatus.SC_OK){
				throw new NoHttpResponseException("连接失败，异常码：" + statusLine.getStatusCode() + ",异常信息：" + statusLine.getReasonPhrase());
			}
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
			
			String responseStr = "";
			String text;
			
			while ((text = bufferedReader.readLine()) != null) {
				responseStr += text + "\n";
			}
			return responseStr;
		} finally{
			response.close();
		}
	}
	
	/**
	 * 
	 * 获取SSLContext
	 * 
	 * @author ksh
	 * @date 2016年12月20日
	 * @since 3.9
	 *
	 * @param keyFilePath 证书路劲 例如：C:/Users/Administrator/Desktop/apiclient_cert.p12
	 * @param keyPasswd   证书密码
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws KeyManagementException
	 * @throws UnrecoverableKeyException
	 */
	protected static SSLContext getSSLContext(String keyFilePath, String keyPasswd) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
		if(!StringUtils.hasText(keyFilePath) || !StringUtils.hasText(keyPasswd)){
			throw new FileNotFoundException("证书路劲或密码为空，请输入有效的证书路劲和密码");
		}
		
		KeyStore keyStore = KeyStore.getInstance(SSLHttpClient.PKCS12);
    	FileInputStream inStream = new FileInputStream(new File(keyFilePath));
    	
    	try {
    		keyStore.load(inStream, keyPasswd.toCharArray());
		} finally{
			inStream.close();
		}
    	
    	SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, keyPasswd.toCharArray()).build();
		return sslContext;
	}
	
	/**
	 * 
	 * 请求参数类型
	 * @author admin
	 * @date 2016年12月20日
	 * @since 1.0.0
	 *
	 */
	public static enum ParamType {
		/**
		 * xml字符串方式
		 */
		XML,
		
		/**
		 * json字符串格式
		 */
		JSON
	}
}
