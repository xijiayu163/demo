package com.yu.study.common.search.mybatis;

import com.yu.util.IntrospectionUtils;

public abstract class AbstractBetweenMybatisResolveStrategy extends AbstractMybatisResolveStrategy{
	private Object paramValue1;
	private Object paramValue2;

	public Object getParamValue1() {
		return paramValue1;
	}

	public void setParamValue1(Object paramValue1) {
		this.paramValue1 = paramValue1;
	}
	
	public Object getParamValue2() {
		return paramValue2;
	}

	public void setParamValue2(Object paramValue2) {
		this.paramValue2 = paramValue2;
	}
	
	@Override
	protected void doResolveCriteria(Object conditionObj) throws Exception{
		setParamValue1(getSearchCondition().getParamValues().get(0));
		setParamValue2(getSearchCondition().getParamValues().get(1));
		IntrospectionUtils.callMethodN(conditionObj, getMethodName(), 
				new Object[]{getParamValue1(),getParamValue2()}, new Class<?>[]{getParamType(),getParamType()});

	}


}
