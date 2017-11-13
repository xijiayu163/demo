package com.yu.study.common.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;

public class SearchCondition {
	private List<String> paramNames;
	private List<Object> paramValues;
	private ResolveStrategeEnum strategeEnum = ResolveStrategeEnum.EqualTo;
	
	public void setParamNames(List<String> paramNames) {
		this.paramNames=paramNames;
	}

	public List<String> getParamNames() {
		if(this.paramNames==null){
			this.paramNames = new ArrayList<>();
		}
		
		return this.paramNames;
	}

	public void setParamName(String paramName){
		setParamNames(new ArrayList<String>());
		getParamNames().add(paramName);
	}
	
	public  void setParamValues(List<Object> paramValues){
		this.paramValues=paramValues;
	}
	
	public void setParamValue(Object paramValue){
		if(!Object.class.isAssignableFrom(Serializable.class)){
			throw new IllegalArgumentException("参数不能为集合!");
		}
		setParamValues(new ArrayList<Object>());
		getParamValues().add(paramValue);
	}

	public List<Object> getParamValues() {
		if(this.paramValues == null){
			this.paramValues = new ArrayList<>();
		}
		return paramValues;
	}
	
	public ResolveStrategeEnum getStrategeEnum() {
		return this.strategeEnum;
	}

	public void setStrategeEnum(ResolveStrategeEnum strategeEnum) {
		this.strategeEnum = strategeEnum;
	}
}
