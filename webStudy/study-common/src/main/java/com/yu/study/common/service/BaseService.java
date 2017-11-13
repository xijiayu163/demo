package com.yu.study.common.service;

import java.io.Serializable;
import java.util.List;

import com.yu.study.common.search.SearchWrapper;

public interface BaseService<T> {
	public String getIdentifierName();			//获取唯一标识名称
	public SearchWrapper find(SearchWrapper searchWrapper);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public List<T> findAll();						//查询所有
 	public T get(Serializable id);					//只查询一个，常用于修改
	public String create(Object entity); 					//插入，用实体作为参数
	public String update(Object entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public void delete(SearchWrapper searchWrapper);  //批量删除，支持复杂条件,条件不能为null,以防止误删
}
