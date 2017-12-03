package com.yu.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.yu.study.bo.OrderBo;
import com.yu.study.common.service.BaseBoServiceImpl;
import com.yu.study.common.service.BaseService;
import com.yu.study.common.spring.SpringContextHolder;
import com.yu.study.service.OrderBoService;
import com.yu.study.service.dos.OrderAttachInfoDoService;
import com.yu.study.service.dos.OrderDoService;
import com.yu.study.service.dos.OrderGoodsDoService;
import com.yu.study.service.dos.OrderLogDoService;
import com.yu.study.service.dos.OrderPolicyDoService;
import com.yu.study.service.dos.OrderRefundDoService;
import com.yu.util.JsonUtil;

@Service
public class OrderBoServiceImpl extends BaseBoServiceImpl<OrderBo> implements OrderBoService{
	
	@Override
	protected List<BaseService<?>> getServices(com.yu.study.common.service.LoadStrategy loadSrategy) {
		List<BaseService<?>> services = new ArrayList<>();
		services.add(SpringContextHolder.getBean(OrderDoService.class));
		LoadStrategy strategy = (LoadStrategy)loadSrategy;
		if(strategy.isLoadOrderGoodsFlag()){
			services.add(SpringContextHolder.getBean(OrderGoodsDoService.class));
		}
		if(strategy.isLoadOrderAttachInfoFlag()){
			services.add(SpringContextHolder.getBean(OrderAttachInfoDoService.class));
		}
		if(strategy.isLoadOrderLogFlag()){
			services.add(SpringContextHolder.getBean(OrderLogDoService.class));
		}
		if(strategy.isLoadOrderPolicyFlag()){
			services.add(SpringContextHolder.getBean(OrderPolicyDoService.class));
		}
		if(strategy.isLoadOrderRefundFlag()){
			services.add(SpringContextHolder.getBean(OrderRefundDoService.class));
		}
		return services;
	}

	@Override
	protected com.yu.study.common.service.LoadStrategy getServicesOfLoadAllStrategy() {
		LoadStrategy strategy = new LoadStrategy();
		strategy.setLoadOrderAttachInfoFlag(true);
		strategy.setLoadOrderGoodsFlag(true);
		strategy.setLoadOrderLogFlag(true);
		strategy.setLoadOrderPolicyFlag(false);
		strategy.setLoadOrderRefundFlag(true);
		
		return strategy;
	}

	@Override
	public com.yu.study.common.service.LoadStrategy parseStrategy(String strategyJsonStr) {
		return JSON.parseObject(strategyJsonStr,LoadStrategy.class);
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		LoadStrategy strategy = new LoadStrategy();
		strategy.setLoadOrderAttachInfoFlag(true);
		strategy.setLoadOrderGoodsFlag(true);
		strategy.setLoadOrderLogFlag(true);
		strategy.setLoadOrderPolicyFlag(true);
		strategy.setLoadOrderRefundFlag(true);
		
		String obj2Json = JsonUtil.obj2Json(strategy);
		System.out.println(obj2Json);
		
		LoadStrategy ss = JSON.parseObject(obj2Json, LoadStrategy.class);
		System.out.println("ok");
	}

}
