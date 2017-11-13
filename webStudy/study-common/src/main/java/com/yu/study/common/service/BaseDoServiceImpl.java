package com.yu.study.common.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.yu.study.common.dao.BaseDao;
import com.yu.study.common.search.SearchWrapper;
import com.yu.study.common.spring.SpringContextHolder;
import com.yu.study.common.validation.ValidateEnum;
import com.yu.util.BeanMapperUtils;
import com.yu.util.IntrospectionUtils;
import com.yu.util.PrimaryKeyGenerator;

public abstract class BaseDoServiceImpl<D, P> extends AbstractBaseServiceImpl<D>{
	 
	protected  Log log = LogFactory.getLog(getClass());
	
	protected BaseDao<P> getDaoInstance(){
		return SpringContextHolder.getBean(getDaoName());
	}
	
	@SuppressWarnings("unchecked")
	private Class<P> getPClassType(){
		//获取当前new对象的泛型的父类类型
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();  
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		Class<P> clazz = (Class<P>) actualTypeArguments[1];
	    
	    return clazz;
	}
	
	@Override
	public SearchWrapper find(SearchWrapper searchWrapper){
		return find(searchWrapper,false);
	}
	
	public SearchWrapper find(SearchWrapper searchWrapper, boolean ignoreNoEffectCondition) {
		searchWrapper = getDaoInstance().find(searchWrapper,ignoreNoEffectCondition);
		return searchWrapper;
	}

	@Override
	public List<D> findAll() {
		List<P> list = getDaoInstance().findAll();
		return BeanMapperUtils.mapList(getMapper(), list, getTClassType());
	}

	@Override
	public D get(Serializable id) {
		checkIdValidation(id);
		
		P p = getDaoInstance().get(id);
		if(p==null){
			return null;
		}else{
			return getMapper().map(p, getTClassType());
		}
	}

	@Override
	public String create(Object entity){
		try{
			checkValidation(entity,false);
			if(getIdentifierName()!=null){
				//判断主键是否已经生成，如果未生成，则生成它
				if(!StringUtils.hasText((String)IntrospectionUtils.getProperty(entity, getIdentifierName()))){
					IntrospectionUtils.setProperty(entity, getIdentifierName(), PrimaryKeyGenerator.generatePrimaryKey());
				}
			}
			P p = getMapper().map(entity, getPClassType());
			getDaoInstance().insert(p);
			
			return getIdentifierValue(entity);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
	}
	
	public String doCreate(Object entity,String foreignKey,String foreignKeyValue){
		try{
			checkValidation(entity,false);
			
			if(foreignKey!=null){
				//设置外键
				IntrospectionUtils.setProperty(entity, foreignKey, foreignKeyValue);
			}
			
			//设置主键
			IntrospectionUtils.setProperty(entity, getIdentifierName(), PrimaryKeyGenerator.generatePrimaryKey());
			P p = getMapper().map(entity, getPClassType());
			getDaoInstance().insert(p);
			
			return getIdentifierValue(entity);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	

	@Override
	public String update(Object entity) {
		try {
			checkValidation(entity, true);
			P p = getMapper().map(entity, getPClassType());
			getDaoInstance().update(p);

			return getIdentifierValue(entity);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void deleteById(Serializable id) {
		checkIdValidation(id);
		getDaoInstance().deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		Assert.notNull(ids);
		Assert.isTrue(ids.length>0);
		getDaoInstance().deleteById(ids);
	}
	
	public void delete(SearchWrapper searchWrapper){  //批量删除，支持复杂条件
		getDaoInstance().delete(searchWrapper);
	}
	
	private void checkValidation(Object entity,boolean checkIdentifier) throws Exception{
		Assert.notNull(entity);
		Map<String, ValidateEnum> validatorMap = getValidatorMap();
		for (Class<?> clazz = entity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			for(Field f : clazz.getDeclaredFields()){
				String filedName = f.getName();
				if(validatorMap.containsKey(filedName)){
					f.setAccessible(true);
					//如果不需要检查唯一标识,则跳过检查唯一标识，用于在增加记录的时候会自动生成标识
					
					if (filedName.equals(getIdentifierName())) {
						if (!checkIdentifier) {
							continue;
						}
					}
					
					Object object = f.get(entity);
					ValidateEnum validateEnum = validatorMap.get(filedName);
					switch (validateEnum) {
					case NotNull:
			        		Assert.notNull((Object[]) object);
						break;
					case NotEmpty:
						if(object instanceof String){
			        		Assert.hasText((String) object);
			        	}else{
			        		Assert.notEmpty((Object[]) object);
			        	}
						break;
					default:
						break;
					}
				}
			}
		}
	}
	
	private  Map<String, ValidateEnum> getValidatorMap(){
		Map<String, ValidateEnum> valiatorMap = new HashMap<>();
		valiatorMap.put(getIdentifierName(), ValidateEnum.NotEmpty);
		Map<String, ValidateEnum> attachValidatorMap = getAttachValidatorMap();
		if(attachValidatorMap!=null){
			for(String key:attachValidatorMap.keySet()){
				valiatorMap.put(key, attachValidatorMap.get(key));
			}
		}

		return valiatorMap;
	}
	
	protected  Map<String, ValidateEnum> getAttachValidatorMap(){
		return null;
	}

	
	private void checkIdValidation(Serializable id){
		Assert.notNull(id);
		if(id instanceof String){
			Assert.hasText((String) id);
		}
	}
}
