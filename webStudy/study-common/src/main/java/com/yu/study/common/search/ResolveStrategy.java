package com.yu.study.common.search;

public interface ResolveStrategy {
	public void setSearchCondition(SearchCondition searchCondition);
	public SearchCondition getSearchCondition();
	public void setPoClazz(Class<?> poClazz);
	public Class<?> getPoClazz();
	public void resolveConditionObject(Object conditionObj);
}
