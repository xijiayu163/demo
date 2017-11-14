package com.yu.dubbo.stub.service.impl;

import com.yu.dubbo.stub.service.StubService;

public class StubServiceStub implements StubService{
	 private final StubService _ics;  
	 
	 public StubServiceStub(StubService stubService){
		 this._ics = stubService;
	 }

	@Override
	public String sayHello(String name) {
		 try{  
	            return this._ics.sayHello(name);  
	        }  
	        catch(Exception e)  
	        {  
	            return "error info!";  
	        }  
	}
	
}
