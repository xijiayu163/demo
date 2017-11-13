package com.yu.study.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.springframework.stereotype.Repository;

import com.yu.study.common.search.SearchProcessor;
import com.yu.study.common.search.SearchWrapper;
import com.yu.study.common.search.mybatis.MybatisSearchProcesser;
import com.yu.study.common.spring.SpringContextHolder;
import com.yu.util.BeanMapperUtils;
import com.yu.util.IntrospectionUtils;

@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	private Mapper mapper;
	protected  Log log = LogFactory.getLog(getClass());
	
	private Class<T> tClass = null;
	private String mapperClassName = null;
	private Object mapperInstance=null;
	private String exampleClassName = null;
	private Class<?> exampleClass = null;
	
	@Override
	public String getOrderByCondition(){
		return null;
	}
	
	protected Mapper getMapper(){
		if(mapper==null){
			mapper = SpringContextHolder.getBean(Mapper.class);
		}
		return mapper;
	}
	
	/**获取当前new对象的泛型的父类类型  
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getTClassType(){
		if(tClass==null){
			Type genericSuperclass = this.getClass().getGenericSuperclass();
			ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
			tClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
	    return tClass;
	}
	
	protected Object getPoMapperInstance(){
		if(mapperInstance==null){
			try {
				Class<?> poMapperClass = Class.forName(getMapperClassName());
				mapperInstance =  SpringContextHolder.getBean(poMapperClass);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		
		return mapperInstance;
	}
	
	protected String getMapperClassName() {
		if(mapperClassName==null){
			String temp = getTClassType().getName().replace(".po", ".mapper");
			mapperClassName = temp+"Mapper";
		}
		return mapperClassName;
	}
	
	protected String getExampleClassName(){
		if(exampleClassName==null){
			exampleClassName = getTClassType().getName()+"Example";
		}
		return exampleClassName;
	}
	
	protected Class<?> getExampleClass(){
		if(exampleClass==null){
			try{
				exampleClass =  Class.forName(getExampleClassName());
			}catch(Exception ex){
				throw new RuntimeException(ex);
			}
		}
		return exampleClass;
	}
	
	public SearchWrapper find(SearchWrapper searchWrapper) {
		return find(searchWrapper,false);
	}
	
	public SearchWrapper find(SearchWrapper searchWrapper,boolean ignoreNoEffectCondition) {
		try{
			SearchProcessor processer = new MybatisSearchProcesser(getPoMapperInstance(),getExampleClass(),getTClassType());
			return processer.searchByConditions(searchWrapper,getOrderByCondition());
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}


	@Override
	public List<T> findAll() {
		try{
			@SuppressWarnings("unchecked")
			List<T> list = (List<T>) IntrospectionUtils.callMethodN(getPoMapperInstance(), "selectByExample", new Object[]{null}, new Class<?>[]{getExampleClass()});
			
			return BeanMapperUtils.mapList(getMapper(), list, getTClassType());
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public T get(Serializable id) {
		try{
			@SuppressWarnings("unchecked")
			T entity = (T) IntrospectionUtils.callMethodN(getPoMapperInstance(), "selectByPrimaryKey", new Object[]{id}, new Class<?>[]{id.getClass()});
			return entity;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public int insert(T entity) {
		try{
			Integer n = (Integer) IntrospectionUtils.callMethodN(getPoMapperInstance(), "insertSelective", new Object[]{entity}, new Class<?>[]{entity.getClass()});
			return n;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public int update(T entity) {
		try{
			Integer n = (Integer) IntrospectionUtils.callMethodN(getPoMapperInstance(), "updateByPrimaryKeySelective", new Object[]{entity}, new Class<?>[]{entity.getClass()});
			return n;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public int deleteById(Serializable id) {
		try{
			Integer n = (Integer) IntrospectionUtils.callMethodN(getPoMapperInstance(), "deleteByPrimaryKey", new Object[]{id}, new Class<?>[]{id.getClass()});
			return n;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public int delete(Serializable[] ids) {
		int result =0;
		for(Serializable id:ids){
			result += deleteById(id);
		}
		
		return result;
	}

	@Override
	public void delete(SearchWrapper searchWrapper) {
		try{
			SearchProcessor processer = new MybatisSearchProcesser(getPoMapperInstance(),getExampleClass(),getTClassType());
			processer.deleteByConditions(searchWrapper);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
