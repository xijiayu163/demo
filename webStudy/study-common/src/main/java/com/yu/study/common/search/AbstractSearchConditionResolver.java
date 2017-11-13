package com.yu.study.common.search;

public abstract class AbstractSearchConditionResolver implements SearchConditionResolver{
	private Class<?> poClazz;
	private SearchCondition searchCondition;
	
	public Class<?> getPoClazz(){
		return poClazz;
	}
	
	public void setPoClazz(Class<?> poClazz){
		this.poClazz = poClazz;
	}
	
	public void setSearchCondition(SearchCondition searchCondition){
		this.searchCondition=searchCondition;
	}
	
	public SearchCondition getSearchCondition(){
		return this.searchCondition;
	}

	public abstract ResolveStrategy getResolveStrategy();
	
	@Override
	public void resolveConditionObject(Object conditionObj){
		getResolveStrategy().setSearchCondition(getSearchCondition());
		getResolveStrategy().setPoClazz(getPoClazz());
		getResolveStrategy().resolveConditionObject(conditionObj);
	}
	
	public AbstractSearchConditionResolver(Class<?> poClazz,SearchCondition searchCondition){
		this.poClazz = poClazz;
		this.searchCondition = searchCondition;
	}

}
