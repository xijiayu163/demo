package com.yu.util.httpClient;

import org.apache.commons.httpclient.HttpException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能：HttpClient方式访问
 * 详细：获取远程HTTP数据
 *
 * @author ksh 康胜虎
 * @date 2016年8月16日下午4:15:28
 * @since 3.5
 */
public class HttpProtocolHandler {
	/** 默认编码 */
    private static String              DEFAULT_CHARSET                     = "UTF-8";

    /** 连接超时时间，由bean factory设置，缺省为8秒钟 */
    private int                        defaultConnectionTimeout            = 8000;

    /** 回应超时时间, 由bean factory设置，缺省为30秒钟 */
    private int                        defaultSoTimeout                    = 30000;

    /** 闲置连接超时时间, 由bean factory设置，缺省为60秒钟 */
    private int                        defaultIdleConnTimeout              = 60000;

    private int                        defaultMaxConnPerHost               = 30;

    private int                        defaultMaxTotalConn                 = 80;

    /** 默认等待HttpConnectionManager返回连接超时（只有在达到最大连接数时起作用）：1秒*/
    private static final long          defaultHttpConnectionManagerTimeout = 3 * 1000;

    /**
     * HTTP连接管理器，该连接管理器必须是线程安全的.
     */
    private HttpConnectionManager      connectionManager;

    private static HttpProtocolHandler httpProtocolHandler                 = new HttpProtocolHandler();

    /**
     * 工厂方法
     * 
     * @return
     */
    public static HttpProtocolHandler getInstance() {
        return httpProtocolHandler;
    }

    /**
     * 私有的构造方法
     */
    private HttpProtocolHandler() {
        // 创建一个线程安全的HTTP连接池
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(defaultMaxConnPerHost);
        connectionManager.getParams().setMaxTotalConnections(defaultMaxTotalConn);

        IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
        ict.addConnectionManager(connectionManager);
        ict.setConnectionTimeout(defaultIdleConnTimeout);

        ict.start();
    }

    /**
     * 执行Http请求
     * 
     * @param request 请求数据
     * @param strParaFileName 文件类型的参数名
     * @param strFilePath 文件路径
     * @return 
     * @throws HttpException, IOException 
     */
    public HttpResponse execute(HttpRequest request) throws HttpException, IOException {
        HttpClient httpclient = new HttpClient(connectionManager);

        // 设置连接超时
        int connectionTimeout = defaultConnectionTimeout;
        if (request.getConnectionTimeout() > 0) {
            connectionTimeout = request.getConnectionTimeout();
        }
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);

        // 设置回应超时
        int soTimeout = defaultSoTimeout;
        if (request.getTimeout() > 0) {
            soTimeout = request.getTimeout();
        }
        httpclient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);

        // 设置等待ConnectionManager释放connection的时间
        httpclient.getParams().setConnectionManagerTimeout(defaultHttpConnectionManagerTimeout);

        String charset = request.getCharset();
        charset = charset == null ? DEFAULT_CHARSET : charset;
        HttpMethod method = null;

        // get模式且不带上传文件
        if (request.getMethod().equals(HttpRequest.METHOD_GET)) {
            method = new GetMethod(request.getUrl());
            method.getParams().setCredentialCharset(charset);
            // parseNotifyConfig会保证使用GET方法时，request一定使用QueryString
            method.setQueryString(request.getQueryString());
        } 
        
        // post模式
        if(request.getMethod().equals(HttpRequest.METHOD_POST)){
        	if(request.getFileParamMap() == null || request.getFileParamMap().isEmpty()) {
            	//post模式且不带上传文件
                method = new PostMethod(request.getUrl());
                if(request.getParamType().equals(HttpRequestParamType.Xml)){
                	// 参数格式为xml格式
                	((PostMethod) method).setRequestEntity(new StringRequestEntity(request.getXmlParamString(), "text/xml", "UTF-8"));
                }else if(request.getParamType().equals(HttpRequestParamType.Json)){
                	// 参数为josn格式
                	if(StringUtils.hasText(request.getJsonParamString())){
                		((PostMethod) method).setRequestEntity(new StringRequestEntity(request.getJsonParamString(), "application/json", charset));
                	}
                }else if(request.getParamType().equals(HttpRequestParamType.NameValuePair)){
                	// 参数格式为键值对的格式
                	((PostMethod) method).addParameters(request.getParameters());
                    method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=" + charset);
                }
            }else {
            	//post模式且带上传文件
                method = new PostMethod(request.getUrl());
                List<Part> parts = new ArrayList<Part>();
                for (int i = 0; i < request.getParameters().length; i++) {
                	parts.add(new StringPart(request.getParameters()[i].getName(), request.getParameters()[i].getValue(), charset));
                }
                
                // 增加文件参数
                for(Map.Entry<String, String> entry:request.getFileParamMap().entrySet()){
                	parts.add(new FilePart(entry.getKey(), new FilePartSource(new File(entry.getValue()))));
                }
                
                // 设置请求体
                ((PostMethod) method).setRequestEntity(new MultipartRequestEntity(parts.toArray(new Part[0]), new HttpMethodParams()));
            }
        }

        // 设置Http Header中的User-Agent属性
        method.addRequestHeader("User-Agent", "Mozilla/4.0");
        
        // 设置自定义请求头
        if(!CollectionUtils.isEmpty(request.getHeaders())){
        	Set<String> keys = request.getHeaders().keySet();
        	for(String key:keys){
        		method.addRequestHeader(key, request.getHeaders().get(key));
        	}
        }
        
        HttpResponse response = new HttpResponse();

        try {
            int statusCode = httpclient.executeMethod(method);
            response.setStatusCode(statusCode);
            if(statusCode == HttpStatus.SC_OK){
            	if (request.getResultType().equals(HttpResultType.STRING)) {
                	method.getParams().setContentCharset(charset);
                    response.setStringResult(method.getResponseBodyAsString());
                }
            	
            	if (request.getResultType().equals(HttpResultType.BYTES)) {
                    response.setByteResult(method.getResponseBody());
                }
                response.setResponseHeaders(method.getResponseHeaders());
            }
            
        } finally {
            method.releaseConnection();
        }
        return response;
    }

    /**
     * 将NameValuePairs数组转变为字符串
     * 
     * @param nameValues
     * @return
     */
    protected String toString(NameValuePair[] nameValues) {
        if (nameValues == null || nameValues.length == 0) {
            return "null";
        }

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < nameValues.length; i++) {
            NameValuePair nameValue = nameValues[i];

            if (i == 0) {
                buffer.append(nameValue.getName() + "=" + nameValue.getValue());
            } else {
                buffer.append("&" + nameValue.getName() + "=" + nameValue.getValue());
            }
        }

        return buffer.toString();
    }
    
}
