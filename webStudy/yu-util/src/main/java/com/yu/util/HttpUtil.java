package com.yu.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	
	
	/**
	 * 设置cookie
	 * 
	 * @author derek 周强
	 * @date 2017年2月14日
	 * @since 4.1
	 * 
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response,String key,String value,int maxAge){
	    Cookie cookie = new Cookie(key,value);
	    cookie.setPath("/");
	    if(maxAge>0)  cookie.setMaxAge(maxAge);
	    response.addCookie(cookie);
	}
	
	/**
	 * 根据名字获取cookie
	 *
	 * @author derek 周强
	 * @date 2017年2月14日
	 * @since 4.1
	 * 
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String key){
	    Map<String,Cookie> cookieMap = ReadCookieMap(request);
	    if(cookieMap.containsKey(key)){
	        Cookie cookie = (Cookie)cookieMap.get(key);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	
	/**
	 * 将cookie封装到Map里面
	 * 
	 * @author derek 周强
	 * @date 2017年2月14日
	 * @since 4.1
	 *  
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	
	/**
	 * 获取网络图片，并转存到filePath目录下
	 * @param filePath  图片需要存储的位置
	 */
	public String downloadImages(String picUrl,String filePath){
		try {
			//MimspPropertyConfig.getProperty("photo_server")
			String fileUrl = picUrl;
			
			String realfilePath =  filePath;
			// 3.判断上传路径是否存在，不存在的话就创建
			if (!FileUtil.exists(realfilePath)) {
				FileUtil.newFolderDeep(realfilePath);
			}
			/*将网络资源地址赋值给url*/
			URL url = new URL(fileUrl);
			/*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
			
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			
			//String filename = httpConn.getHeaderField("Content-disposition").split("\"")[1];
			realfilePath = realfilePath + File.separator + ".jpg";
			DataInputStream in = new DataInputStream(httpConn.getInputStream());
			FileOutputStream fos = new FileOutputStream(realfilePath);
			/*此处也可用BufferedInputStream与BufferedOutputStream 需要保存的路径*/
			DataOutputStream out = new DataOutputStream(fos);
			
			byte[] buffer = new byte[4096];
			int count = 0;
			while((count = in.read(buffer))>0){//将输入流以字节的形式读取并写入buffer中
				out.write(buffer,0,count);
			}
			out.close();
			in.close();
			httpConn.disconnect();
			return filePath + File.separator + ".jpg";
		} catch (Exception e) {
			return null;
		}
	}
	
}
