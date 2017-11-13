package com.yu.dubbo.startup;

import java.io.FileNotFoundException;

import org.springframework.util.Log4jConfigurer;

public class Provider {
	
	static {
        try {
			Log4jConfigurer.initLogging("classpath:META-INF/spring/log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	

	public static void main(String[] args) throws Exception {
		com.alibaba.dubbo.container.Main.main(args);
	}
}
