package com.yu.study.common.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.yu.study.common.search.mybatis.MybatisSearchConditionResolver;
import com.yu.study.common.web.Page;
import com.yu.util.DateUtil;
import com.yu.util.IntrospectionUtils;

public abstract class AbstractSearchProcessor implements SearchProcessor{
	
	private Class<?>  poClazz;
	
	public AbstractSearchProcessor(Class<?> poClazz){
		this.poClazz = poClazz;
	}
	

	@SuppressWarnings("unused")
	private void HandleNoEffectCondition(SearchWrapper searchWrapper){
		Iterator<SearchCondition> iterator = searchWrapper.getSearchConditions().iterator();
		while(iterator.hasNext()){
			SearchCondition condition = iterator.next();
			Iterator<String> iterator_param = condition.getParamNames().iterator();
			while(iterator_param.hasNext()){
				String propertyName = iterator_param.next();
				if(!IntrospectionUtils.findProperty(poClazz, propertyName)){
					iterator_param.remove();
				}
			}
			if(CollectionUtils.isEmpty(condition.getParamNames())){
				iterator.remove();
			}
		}
	}
	
	@Override
	public SearchWrapper searchByConditions(SearchWrapper searchWrapper,String orderByCondition){
		try{
			Object conditionObj = initialConditionObject();
			resolveConditions(conditionObj,searchWrapper.getSearchConditions());
			resolveOrderByCondition(orderByCondition);
			if(searchWrapper.getPage()!=null){
				resolvePageCondition(searchWrapper.getPage());
				searchWrapper.getPage().setTotalRecord(doCount());
			}
			List<Object> results = doSearch();
			searchWrapper.setResults(results);
			
			return searchWrapper;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	public void deleteByConditions(SearchWrapper searchWrapper){
		try{
			Object conditionObj = initialConditionObject();
			resolveConditions(conditionObj,searchWrapper.getSearchConditions());
			doDelete();
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	protected void resolveConditions(Object conditionObj,List<SearchCondition> conditions) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException{
		if(CollectionUtils.isEmpty(conditions)){
			return ;
		}
		
		for(SearchCondition condition:conditions){
			Class<?> clazz = poClazz.getDeclaredField(condition.getParamNames().get(0)).getType();
			List<Object> paramValues = new ArrayList<>();
			for(Object val:condition.getParamValues()){
				Object castValue = castValue(val,clazz);
				paramValues.add(castValue);
			}
			condition.setParamValues(paramValues);
			SearchConditionResolver resolver = new MybatisSearchConditionResolver(poClazz,condition);
			resolver.resolveConditionObject(conditionObj);
		}
	}
	
	private void resolveOrderByCondition(String orderByCondition) throws Exception{
		if(StringUtils.hasText(orderByCondition)){
			doResolveOrderByCondition(orderByCondition);;
		}
		
		
	}
	
	protected abstract void doResolveOrderByCondition(String orderByCondition) throws Exception;

	/**
	 * @return 初始化转换后的查询条件对象
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected abstract Object initialConditionObject() throws InstantiationException, IllegalAccessException;
	
	/**具体执行查询操作
	 * @param <T>
	 * @return
	 * @throws Exception 
	 */
	protected abstract <T> List<T> doSearch() throws Exception;
	
	protected abstract void doDelete() throws Exception;
	
	/**执行统计操作
	 * @return 
	 * @throws Exception
	 */
	protected abstract int doCount() throws Exception;
	
	protected abstract <T> void resolvePageCondition(Page page) throws Exception;
	
	private Object castValue(Object value,Class<?> clazz){
		if(value==null){
			return null;
		}
		
//		if(value instanceof List){
//			List<Serializable> list = new ArrayList<>();
//			Iterator<?> iterator = ((List<?>) value).iterator();
//			while (iterator.hasNext()) {
//				Object object = (Object) iterator.next();
//				list.add(castValue(object,clazz));
//			}
//			return list;
//		}
		
		if(clazz.equals(Integer.class)){
			return Integer.parseInt(String.valueOf(value));
		}else if(clazz.equals(Date.class)){
			return DateUtil.parseDerline(String.valueOf(value));
		}else if(clazz.equals(Boolean.class)){
			return Boolean.parseBoolean(String.valueOf(value));
		}else if(clazz.equals(Double.class)){
			return Double.parseDouble(String.valueOf(value));
		}else {
			return (Serializable) clazz.cast(value);
		}
	}
}
