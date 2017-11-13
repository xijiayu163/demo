package com.yu.dubbo.startup;

import java.io.FileNotFoundException;

import org.springframework.util.Log4jConfigurer;

public class Consumer {
	
	static {
        try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	

	public static void main(String[] args) throws Exception {
		
	}
}
