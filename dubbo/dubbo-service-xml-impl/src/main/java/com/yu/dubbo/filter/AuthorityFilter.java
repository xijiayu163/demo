package com.yu.dubbo.filter;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

public class AuthorityFilter implements Filter{
	
	private final static Logger log = Logger.getLogger(AuthorityFilter.class);
	
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String clientIp = RpcContext.getContext().getRemoteHost();  
		log.info("访问ip为:"+clientIp);  
		 return invoker.invoke(invocation);  
	}

}
