package com.yu.dubbo.stub.service.impl;

import com.yu.dubbo.stub.service.StubService;

public class StubServiceImpl implements StubService{

	@Override
	public String sayHello(String name) {
		int i = (int)(Math.random()*1000);  
        if(i<600)  
        {  
            Integer.parseInt("ss");  //stub 测试           
        }  
        return "提供方服务数据  调用: " + name + String.valueOf(i);  
	}
	
}
