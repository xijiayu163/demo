package com.yu.study.common.search.mybatis;

import com.yu.util.IntrospectionUtils;

public abstract class AbstractNoValueMybatisResolveStrategy extends AbstractMybatisResolveStrategy{

	@Override
	protected void doResolveCriteria(Object conditionObj) throws Exception{
			IntrospectionUtils.callMethodN(conditionObj, getMethodName(), 
					new Object[]{}, new Class<?>[]{});

	}
}
