package com.yu.study.common.search.mybatis;

import com.yu.study.common.search.AbstractSearchConditionResolver;
import com.yu.study.common.search.ResolveStrategeEnum;
import com.yu.study.common.search.ResolveStrategy;
import com.yu.study.common.search.SearchCondition;

public class MybatisSearchConditionResolver extends AbstractSearchConditionResolver{
	
	private ResolveStrategy resolveStrategy;

	public void setResolveStrategy(ResolveStrategy resolveStrategy) {
		this.resolveStrategy = resolveStrategy;
	}
	
	@Override
	public ResolveStrategy getResolveStrategy() {
		if(resolveStrategy==null){
			resolveStrategy =  MybatisResolveStrategyFactory.getInstance().createStrategy(getSearchCondition().getStrategeEnum());
		}
		return resolveStrategy;
	}

	public MybatisSearchConditionResolver(Class<?> poClazz,SearchCondition searchCondition) {
		super(poClazz, searchCondition);
	}


}
