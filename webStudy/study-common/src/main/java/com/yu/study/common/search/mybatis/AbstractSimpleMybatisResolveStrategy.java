package com.yu.study.common.search.mybatis;

import com.yu.util.IntrospectionUtils;

public abstract class AbstractSimpleMybatisResolveStrategy extends AbstractMybatisResolveStrategy{
	
	private Object paramValue;

	public Object getParamValue() {
		return paramValue;
	}

	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}
	


	@Override
	protected void doResolveCriteria(Object conditionObj) throws Exception{
		setParamValue(getSearchCondition().getParamValues().get(0));
		doInternalResolveConditionObject(conditionObj);

	}
	
	protected void doInternalResolveConditionObject(Object conditionObj) throws Exception{
		IntrospectionUtils.callMethodN(conditionObj, getMethodName(), 
				new Object[]{getParamValue()}, new Class<?>[]{getParamType()});
	}
}
