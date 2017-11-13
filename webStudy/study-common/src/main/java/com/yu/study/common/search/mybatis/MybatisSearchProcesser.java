package com.yu.study.common.search.mybatis;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.yu.study.common.search.AbstractSearchProcessor;
import com.yu.study.common.search.OrderByCondition;
import com.yu.study.common.web.Page;
import com.yu.util.CollectionUtil;
import com.yu.util.IntrospectionUtils;

public class MybatisSearchProcesser extends AbstractSearchProcessor{
	private Class<?> exampleClazz;
	private Object exampleInstance;
	private Object poMapperInstance;
	
	public MybatisSearchProcesser(Object poMapperInstance,Class<?> exampleClazz,Class<?> poClazz) {
		super(poClazz);
		this.exampleClazz = exampleClazz;
		this.poMapperInstance = poMapperInstance;
	}
	
	@Override
	protected Object initialConditionObject() throws InstantiationException, IllegalAccessException{
		exampleInstance = exampleClazz.newInstance();
		return exampleInstance;
	}
	
	@Override
	protected <T> void resolvePageCondition(Page page) throws Exception {
		IntrospectionUtils.callMethodN(exampleInstance, "setLimitStart", 
				new Object[]{(page.getPageNo()-1)*page.getPageSize()}, new Class<?>[]{Integer.class});
		IntrospectionUtils.callMethodN(exampleInstance, "setLimitEnd", 
				new Object[]{page.getPageSize()}, new Class<?>[]{Integer.class});
	}
	
	@Override
	protected void doResolveOrderByCondition(String orderByCondition) throws Exception {
//		StringBuilder sBuilder = new StringBuilder();
//		for(OrderByCondition condition:orderByConditions){
//			sBuilder.append(condition.getFieldName());
//			if(condition.isAscFlag()){
//				sBuilder.append(" ASC");
//			}else {
//				sBuilder.append(" DESC");
//			}
//			sBuilder.append(",");
//		}
//		sBuilder.setLength(sBuilder.length()-1);
//		IntrospectionUtils.callMethodN(exampleInstance, 
//				"setOrderByClause", new Object[]{sBuilder.toString()}, new Class<?>[]{String.class});
		
		IntrospectionUtils.callMethodN(exampleInstance, 
				"setOrderByClause", new Object[]{orderByCondition}, new Class<?>[]{String.class});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected <T> List<T> doSearch() throws Exception{
		//判断是否有selectByExampleWithBLOBs方法
		Method findMethod = IntrospectionUtils.findMethod(poMapperInstance.getClass(), "selectByExampleWithBLOBs", new Class<?>[]{exampleClazz});
		List<T> results = new ArrayList<>();
		if(findMethod!=null){
			results = (List<T>) IntrospectionUtils.callMethodN(poMapperInstance, 
					"selectByExampleWithBLOBs", new Object[]{exampleInstance}, new Class<?>[]{exampleClazz});
			
		}else{
			results = (List<T>) IntrospectionUtils.callMethodN(poMapperInstance, 
					"selectByExample", new Object[]{exampleInstance}, new Class<?>[]{exampleClazz});
			
		}
		
		return results;
	}

	@Override
	protected int doCount() throws Exception {
		int num = (int) IntrospectionUtils.callMethodN(poMapperInstance, 
				"countByExample", new Object[]{exampleInstance}, new Class<?>[]{exampleClazz});
		
		return num;
	}
	
	protected void doDelete() throws Exception{
		IntrospectionUtils.callMethodN(poMapperInstance, 
				"deleteByExample", new Object[]{exampleInstance}, new Class<?>[]{exampleClazz});
	}

}
