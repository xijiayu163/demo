package com.yu.study.common.search;

public interface SearchConditionResolver{	
	
	public void setSearchCondition(SearchCondition searchCondition);
	public SearchCondition getSearchCondition();
	
	/**
	 * 根据当前条件解析关联的查询对象
	 * 
	 * @param
	 */
	public void resolveConditionObject(Object conditionObj);
}
