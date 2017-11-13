package com.yu.study.common.search;

import java.util.ArrayList;
import java.util.List;

import com.yu.study.common.web.Page;

public class SearchWrapper {
	/**
	 * 查询条件
	 */
	private List<SearchCondition> searchConditions = new ArrayList<>(); 
	
	/**
	 * 对应的当前页记录,如果page为null，则默认为全部
	 */
	private List<Object> results;		
	/**
	 * 分页条件
	 */
	private Page page;
	
	public List<SearchCondition> getSearchConditions() {
		return searchConditions;
	}
	public void setSearchConditions(List<SearchCondition> searchConditions) {
		this.searchConditions = searchConditions;
	}
	public List<Object> getResults() {
		return results;
	}
	public void setResults(List<Object> results) {
		this.results = results;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
