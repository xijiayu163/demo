package com.yu.study.common.search.mybatis;

import java.util.List;

import com.yu.study.common.search.ResolveStrategy;
import com.yu.study.common.search.SearchCondition;
import com.yu.util.IntrospectionUtils;

public abstract class AbstractMybatisResolveStrategy implements ResolveStrategy{
	private SearchCondition searchCondition;
	private Class<?> poClazz;
	private Class<?> paramType;
	private String methodNamePrefix;
	private String methodName;

	
	public SearchCondition getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(SearchCondition searchCondition) {
		this.searchCondition = searchCondition;
	}
	
	public void setPoClazz(Class<?> poClazz){
		this.poClazz = poClazz;
	}
	
	public Class<?> getPoClazz(){
		return this.poClazz;
	}
	
	public Class<?> getParamType() {
		return paramType;
	}

	public void setParamType(Class<?> paramType) {
		this.paramType = paramType;
	}
	
	public String getMethodNamePrefix() {
		return methodNamePrefix;
	}

	public void setMethodNamePrefix(String methodNamePrefix) {
		this.methodNamePrefix = methodNamePrefix;
	}
	
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	@Override
	public void resolveConditionObject(Object conditionExample){
		try {
			Class<?> clazz = poClazz.getDeclaredField(getSearchCondition().getParamNames().get(0)).getType();
			setParamType(clazz);
			if(this.getSearchCondition().getParamNames().size()>1){
				doResolveConditionObjectIfMultiParamNames(conditionExample);
			}else{
				doResolveConditionObjectIfSingleParamName(conditionExample);
			}
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	protected void doResolveConditionObjectIfSingleParamName(Object conditionExample) throws Exception{
		String firstChar = getSearchCondition().getParamNames().get(0).substring(0,1);
		String remainChars = getSearchCondition().getParamNames().get(0).substring(1);
		setMethodNamePrefix("and"+firstChar.toUpperCase()+remainChars);
		setMethodName(getMethodNamePrefix()+getMethodNameSuffix()); 
		
		Object criterias = IntrospectionUtils.callMethodN(conditionExample, "getOredCriteria", 
				new Object[]{}, new Class<?>[]{});
		int size = (int) IntrospectionUtils.callMethodN(criterias, "size", 
				new Object[]{}, new Class<?>[]{});
		if(size==0){
			IntrospectionUtils.callMethodN(conditionExample, 
			"createCriteria", new Object[0], new Class<?>[0]);
			size++;
		}
		for(int i=0;i<size;i++){
			Object criteria = IntrospectionUtils.callMethodN(criterias, "get", 
					new Object[]{i}, new Class<?>[]{int.class});
			doResolveCriteria(criteria);
		}
	}
	
	protected void doResolveConditionObjectIfMultiParamNames(Object conditionExample) throws Exception{
		Object criterias = IntrospectionUtils.callMethodN(conditionExample, "getOredCriteria", new Object[] {},
				new Class<?>[] {});
		int size = (int) IntrospectionUtils.callMethodN(criterias, "size", new Object[] {}, new Class<?>[] {});
		if(size==0){
			IntrospectionUtils.callMethodN(conditionExample, 
			"createCriteria", new Object[0], new Class<?>[0]);
			size++;
		}
		for (int i = 0; i < size; i++) {
			Object criteria = IntrospectionUtils.callMethodN(criterias, "get", new Object[] { i },
					new Class<?>[] { int.class });
			for (String paramName : getSearchCondition().getParamNames()) {
				// 复制
				Object example = conditionExample.getClass().newInstance();
				Object criteriaCopy = IntrospectionUtils.callMethodN(example, "createCriteria", new Object[] {},
						new Class<?>[] {});
				Object criterions = IntrospectionUtils.callMethodN(criteriaCopy, "getAllCriteria", new Object[] {},
						new Class<?>[] {});
				Object toBeCopyCriterions = IntrospectionUtils.callMethodN(criteria, "getAllCriteria", new Object[] {},
						new Class<?>[] {});
				IntrospectionUtils.callMethodN(criterions, "addAll", new Object[] { toBeCopyCriterions },
						new Class<?>[] { java.util.Collection.class });

				String firstChar = paramName.substring(0, 1);
				String remainChars = paramName.substring(1);
				setMethodNamePrefix("and" + firstChar.toUpperCase() + remainChars);
				setMethodName(getMethodNamePrefix() + getMethodNameSuffix());

				// 根据当前参数操作条件
				doResolveCriteria(criteriaCopy);
				IntrospectionUtils.callMethodN(conditionExample, "or", new Object[] { criteriaCopy },
						new Class<?>[] { criteriaCopy.getClass()});
			}
		}

		// 删除原有的or条件对象
		for (int i = size - 1; i >= 0; i--) {
			IntrospectionUtils.callMethodN(criterias, "remove", new Object[] { i }, new Class<?>[] { int.class });
		}
	}
	
	
	protected void doResolveCriteria(Object criteria) throws Exception{
		IntrospectionUtils.callMethodN(criteria, getMethodName(), 
				new Object[]{getSearchCondition().getParamValues()}, new Class<?>[]{List.class});
	}
	
	protected abstract String getMethodNameSuffix();
}
