package com.yu.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class IPUtil {
	/**
	 * 
	 * 获取客户端ip
	 * 
	 * @author ksh
	 * @date 2017年1月14日
	 * @since 3.9
	 *
	 * @param request
	 * @return
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String realIP = request.getHeader("X-Real-IP");
		if(StringUtils.hasText(realIP)){
			return realIP;
		}
		
		return request.getRemoteAddr();
	}
	
	/**
	 * 判断是否本机IP
	 *
	 * @author yuxijia
	 * @date 2017年1月16日 
	 * @since 3.9.0
	 *
	 * @param ip
	 * @return
	 */
	public static boolean isLocalIp(String ip){
		Enumeration<NetworkInterface> interfs;
		try {
			interfs = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			return false;
		}
		while (interfs!=null && interfs.hasMoreElements()) {
			NetworkInterface networkInterface = (NetworkInterface) interfs.nextElement();
			Enumeration<InetAddress> addres = networkInterface.getInetAddresses();
			
			while (addres.hasMoreElements()) {
				InetAddress inetAddress = (InetAddress) addres.nextElement();
				if(ip.equals(inetAddress.getHostAddress().toString())){
					return true;
				}
			}
		}
		return false;
	}
}
