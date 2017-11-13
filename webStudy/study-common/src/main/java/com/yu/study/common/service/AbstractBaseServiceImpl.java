package com.yu.study.common.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.util.StringUtils;

import com.yu.study.common.search.SearchWrapper;
import com.yu.study.common.spring.SpringContextHolder;
import com.yu.util.IntrospectionUtils;
import com.yu.util.PrimaryKeyGenerator;

public abstract class AbstractBaseServiceImpl<T> implements BaseService<T>{
	@SuppressWarnings("unchecked")
	public Class<T> getTClassType(){
		//获取当前new对象的泛型的父类类型  
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
	    Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	    
	    return clazz;
	}

	public String getIdentifierValue(Object entity) {
		String getter = getGetter(getIdentifierName());
		try {
			return (String) IntrospectionUtils.callMethodN(entity,getter, 
					new Object[]{}, new Class<?>[]{});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public abstract SearchWrapper find(SearchWrapper searchWrapper);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public abstract List<T> findAll();						//查询所有
 	public abstract T get(Serializable id);					//只查询一个，常用于修改
	public String create(Object entity){
		return doCreate(entity,null,null);
	}
	public abstract String doCreate(Object entity,String foreignKey,String foreignKeyValue); 
	public abstract String update(Object entity);					//修改，用实体作为参数
	public abstract void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public abstract void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	public abstract void delete(SearchWrapper searchWrapper);  //批量删除，支持复杂条件

	
	protected String getSetter(String fieldName){
		String firstChar = fieldName.substring(0,1);
		String remainChars = fieldName.substring(1);
		return "set"+firstChar.toUpperCase()+remainChars;
	}
	
	protected String getGetter(String fieldName){
		String firstChar = fieldName.substring(0,1);
		String remainChars = fieldName.substring(1);
		return "get"+firstChar.toUpperCase()+remainChars;
	}
	
	/**根据当前serviceClazz Bo或者Do Service实现类获取对应的Bo或Do实体对象作为属性的属性名
	 * @param serviceClazz Bo或者Do Service实现类，形如OrderBoServiceImpl或OrderDoServiceImpl
	 * @return 返回对应的Bo或Do实体对象作为属性的属性名,如 orderBo,orderDo
	 */
	public String getPropertyName(){
		String simpleClassName = this.getClass().getSimpleName();
		String firstChar = simpleClassName.substring(0, 1);
		//去除ServiceImpl或者ServiceImpl
		String remainChars = simpleClassName.substring(1,simpleClassName.length()-11);
		String propertyName = firstChar.toLowerCase()+remainChars;
		
		return propertyName;
	}
	
	/**根据当前服务对象xxxBoService 或者 xxxDoServiceImpl的class获取对应的Bo或Do实体对象作为属性的属性名
	 * @param serviceClazz Bo或者Do Service实现类，形如OrderBoServiceImpl或OrderDoServiceImpl
	 * @return 返回对应的Bo或Do实体对象作为属性的属性名,如 orderBo,orderDo
	 */
	public String getPropertyListNameByServiceClass(){
		String simpleClassName = this.getClass().getSimpleName();
		String firstChar = simpleClassName.substring(0, 1);
		//去除ServiceImpl或者ServiceImpl
		String remainChars = simpleClassName.substring(1,simpleClassName.length()-11);
		String propertyName = firstChar.toLowerCase()+remainChars+"List";
		
		return propertyName;
	}
	
	private Mapper mapper;
	protected Mapper getMapper(){
		if(mapper==null){
			mapper = SpringContextHolder.getBean(Mapper.class);
		}
		return mapper;
	}
	
	/**根据当前服务对象xxxBoService 或者 xxxDoServiceImpl的class获取对应的xxxDaoImpl
	 * @return dao层实现类名称 形如 xxxDaoImpl
	 */
	protected String getDaoName(){
		 String className = this.getClass().getSimpleName();
		 String firstChar = className.substring(0, 1);
		 String remainChars = className.substring(1,className.length()-13);//去除DoServiceImpl
		 String daoName = firstChar.toLowerCase()+remainChars+"DaoImpl";
		 return daoName;
	}
	
	/**生成主键，如果唯一标识已经赋值，则忽略
	 * @param object 
	 * @param identifierName 
	 */
	protected void generatePrimaryKey(Object object,String identifierName){
		//判断主键是否已经生成，如果未生成，则生成它
		if(!StringUtils.hasText((String)IntrospectionUtils.getProperty(object, identifierName))){
			//生成主键,默认非List
			String generatePrimaryKey = PrimaryKeyGenerator.generatePrimaryKey();
			//反射设置主键
			IntrospectionUtils.setProperty(object, identifierName, 
					generatePrimaryKey);
		}
	}

	public boolean foundProperty(String propertyName){
		return IntrospectionUtils.findProperty(getTClassType(), propertyName);

	}
}
