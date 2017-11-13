package com.yu.util.httpClient;

import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import com.google.gson.JsonObject;
/**
 * 功能：Http请求对象的封装
 * 详细：封装Http请求
 *
 * @author ksh 康胜虎
 * @date 2016年8月16日下午4:15:54
 * @since 3.5
 */
public class HttpRequest {

    /** HTTP GET method */
    public static final String METHOD_GET        = "GET";

    /** HTTP POST method */
    public static final String METHOD_POST       = "POST";

    /**
     * 待请求的url
     */
    private String             url               = null;

    /**
     * 默认的请求方式
     */
    private String             method            = METHOD_POST;

    private int                timeout           = 0;

    private int                connectionTimeout = 0;
    
    /**
     * 自定义请求头
     */
    private Map<String, String> headers          = null;

    /**
     * Post方式请求时组装好的参数值对
     */
    private NameValuePair[]    parameters        = null;
    
    /**
     * post请求json参数
     */
    private String         jsonParamString       = null;
    
    /**
     * post方式xml字符串格式参数
     */
    private String			   xmlParamString	 = null;

    /**
     * Get方式请求时对应的参数
     */
    private String             queryString       = null;
    
    /**
     * 文件参数map，key:文件名，value:文件路径
     */
    private Map<String,String> fileParamMap      = null;

    /**
     * 默认的请求编码方式
     */
    private String             charset           = "UTF-8";

    /**
     * 请求发起方的ip地址
     */
    private String             clientIp;
    
    /**
     * 请求参数格式
     */
    private HttpRequestParamType paramType		 = HttpRequestParamType.NameValuePair;

    /**
     * 请求返回的方式
     */
    private HttpResultType     resultType        = HttpResultType.BYTES;
    
    public HttpRequest() {
        super();
    }

    public HttpRequest(HttpResultType resultType) {
        super();
        this.resultType = resultType;
    }
    
    public HttpRequest(HttpRequestParamType paramType) {
        super();
        this.paramType = paramType;
    }
    
    public HttpRequest(HttpResultType resultType, HttpRequestParamType paramType) {
        super();
        this.resultType = resultType;
        this.paramType = paramType;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public NameValuePair[] getParameters() {
        return parameters;
    }

    public void setParameters(NameValuePair[] parameters) {
        this.parameters = parameters;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public HttpResultType getResultType() {
        return resultType;
    }

    public void setResultType(HttpResultType resultType) {
        this.resultType = resultType;
    }

	public HttpRequestParamType getParamType() {
		return paramType;
	}

	public void setParamType(HttpRequestParamType paramType) {
		this.paramType = paramType;
	}

	public String getXmlParamString() {
		return xmlParamString;
	}

	public void setXmlParamString(String xmlParamString) {
		this.xmlParamString = xmlParamString;
	}

	public String getJsonParamString() {
		return jsonParamString;
	}

	public void setJsonParamString(String jsonParamString) {
		this.jsonParamString = jsonParamString;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getFileParamMap() {
		return fileParamMap;
	}

	public void setFileParamMap(Map<String, String> fileParamMap) {
		this.fileParamMap = fileParamMap;
	}
}
