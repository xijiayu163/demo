package com.yu.study.common.dao;

import java.io.Serializable;
import java.util.List;

import com.yu.study.common.search.SearchWrapper;

public interface BaseDao<T> {
	public SearchWrapper find(SearchWrapper searchWrapper);
	public String getOrderByCondition();		//获取排序规则
	public List<T> findAll();						//查询所有
 	public T get(Serializable id);					//只查询一个，常用于修改
	public int insert(T entity);					//插入，用实体作为参数
	public int update(T entity);					//修改，用实体作为参数
	public int deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public int delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public void delete(SearchWrapper searchWrapper);  //批量删除，支持复杂条件
	public SearchWrapper find(SearchWrapper searchWrapper, boolean ignoreNoEffectCondition);
}
