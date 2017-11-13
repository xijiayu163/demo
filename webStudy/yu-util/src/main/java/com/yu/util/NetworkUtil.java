package com.yu.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 常用获取客户端信息的工具
 * 
 */
public final class NetworkUtil {

	/**
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public final static String getIpAddress(HttpServletRequest request){
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}
	
	public final static boolean isIP(String addr)
    {
      if(addr.length() < 7 || addr.length() > 15 || "".equals(addr))
      {
        return false;
      }
      /**
       * 判断IP格式和范围
       */
      String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
      
      Pattern pat = Pattern.compile(rexp);  
      
      Matcher mat = pat.matcher(addr);  
      
      boolean ipAddress = mat.find();

      return ipAddress;
    }
	
	/**
	 * 得到主域名
	 * @return
	 */
	public final static String getMainDomain(HttpServletRequest request) {
		String domain = request.getServerName();
		if(!NetworkUtil.isIP(domain)) { 
			String[] strs = domain.split("\\.");
			if(strs.length==3) {
				domain = domain.substring(domain.indexOf("."), domain.length());
			}
			if(strs.length==4) {
				domain = domain.substring(domain.indexOf(".", domain.indexOf(".") + 1), domain.length());
			}
		}
		return domain;
	}
}