package com.yu.util.httpClient;

import org.apache.commons.httpclient.Header;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 功能：Http返回对象的封装
 * 详细：封装Http返回信息
 *
 * @author ksh 康胜虎
 * @date 2016年8月16日下午4:16:08
 * @since 3.5
 */
public class HttpResponse {

    /**
     * 返回中的Header信息
     */
    private Header[] responseHeaders;

    /**
     * String类型的result
     */
    private String   stringResult;

    /**
     * btye类型的result
     */
    private byte[]   byteResult;
    
    /**
     * 请求状态
     * 200为成功,其余都认为失败
     */
    private int statusCode;
    
    public HttpResponse(){
    	
    }
    
    public HttpResponse(int statusCode, String stringResult){
    	this.statusCode = statusCode;
    	this.stringResult = stringResult;
    }

    public Header[] getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    public void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }

    public String getStringResult() throws UnsupportedEncodingException {
        if (stringResult != null) {
            return stringResult;
        }
        if (byteResult != null) {
            return new String(byteResult, "utf-8");
        }
        return null;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
