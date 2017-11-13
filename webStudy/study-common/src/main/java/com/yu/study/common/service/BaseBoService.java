package com.yu.study.common.service;

import java.io.Serializable;

public interface BaseBoService<T> extends BaseService<T>{
	public T get(Serializable id,LoadStrategy loadStrategy);
	
	public LoadStrategy parseStrategy(String strategyJsonStr);
}
