package com.yu.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

/**
 * 集合操作封装工具
 * 
 * @author 张超
 *
 */
public class CollectionUtil {

	/**
	 * 获取List集合的第一个元素
	 * 
	 * @param list
	 * @return 如果集合为null，则返回null；否则返回指定的泛型对象
	 */
	public static <E>  E getFirst(List<E> list){
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		else{
			return list.get(0);
		}
	}
	
	/**
	 * 从集合中查找第一个指定属性为指定值的元素
	 *
	 * @author yuxijia
	 * @date 2017年1月10日 
	 * @since 3.9.0
	 *
	 * @param list 集合
	 * @param propertyName 属性名
	 * @param value 待匹配的属性值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> T getFirstMatch(List<T> list,String propertyName,E value){
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		String firstWord = propertyName.substring(0,1).toUpperCase();
		String methodName = "get"+firstWord+propertyName.substring(1,propertyName.length());
		T t = list.get(0);
		Method declaredMethod;
		try {
			declaredMethod = t.getClass().getDeclaredMethod(methodName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
		for(T t1:list){
			E objValue;
			try {
				objValue = (E)(declaredMethod.invoke(t1, new Object[]{}));
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			} 
			if(value.equals(objValue)){
				return t1;
			}
		}
		return null;
	}
	
	/**
	 * 从集合中查找所有指定属性为指定值的子集
	 *
	 * @author yuxijia
	 * @date 2017年1月10日 
	 * @since 3.9.0
	 *
	 * @param list 集合
	 * @param propertyName 属性名
	 * @param value 待匹配的属性值
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> List<T> getAllMatch(List<T> list,String propertyName,E value){
		List<T> matchList = new ArrayList<>();
		if(CollectionUtils.isEmpty(list)){
			return matchList;
		}
		String firstWord = propertyName.substring(0,1).toUpperCase();
		String methodName = "get"+firstWord+propertyName.substring(1,propertyName.length());
		T t = list.get(0);
		Method declaredMethod = null;
			for (Class<?> clazz = t.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
				try {
					Class<? extends Object> class1 = clazz.getClass();
					Method[] declaredMethods = clazz.getDeclaredMethods();
					declaredMethod = clazz.getDeclaredMethod(methodName);
				} catch (Exception e) {
					//no-op
				}
				if(declaredMethod != null){
					break;
				}
			}
		
		for(T t1:list){
			E objValue;
			try {
				objValue = (E)(declaredMethod.invoke(t1, new Object[]{}));
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			} 
			if(value.equals(objValue)){
				matchList.add(t1);
			}
		}
		return matchList;
	}	
	
	/**
	 * 从集合中查找指定属性值组成的集合
	 *
	 * @author yuxijia
	 * @date 2017年1月10日 
	 * @since 3.9.0
	 *
	 * @param list	集合
	 * @param propertyName 属性名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T,V> List<V> getSingleValueList(List<T> list,String propertyName,Class<V> clazz){
		List<V> matchList = new ArrayList<V>();
		if(CollectionUtils.isEmpty(list)){
			return matchList;
		}
		String firstWord = propertyName.substring(0,1).toUpperCase();
		String methodName = "get"+firstWord+propertyName.substring(1,propertyName.length());
		T t = list.get(0);
		Method declaredMethod;
		try {
			declaredMethod = t.getClass().getDeclaredMethod(methodName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
		for(T t1:list){
			V objValue;
			try {
				objValue = (V)(declaredMethod.invoke(t1, new Object[]{}));
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			} 
			matchList.add(objValue);
		}
		return matchList;
	}
	
	
	/**
	 * 判断集合中是否存在指定元素的指定值在指定的集合中
	 *
	 * @author yuxijia
	 * @date 2017年1月10日 
	 * @since 3.9.0
	 *
	 * @param list 集合
	 * @param propertyName 属性名
	 * @param destValues 待匹配的属性值集合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> Boolean isMatchBetween2List(List<T> list,String propertyName,List<E> destValues){
		if(CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(destValues)){
			return false;
		}
		String firstWord = propertyName.substring(0,1).toUpperCase();
		String methodName = "get"+firstWord+propertyName.substring(1,propertyName.length());
		T t = list.get(0);
		Method declaredMethod;
		try {
			declaredMethod = t.getClass().getDeclaredMethod(methodName);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
		for(T t1:list){
			E objValue;
			try {
				objValue = (E)(declaredMethod.invoke(t1, new Object[]{}));
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			} 
			for(E e:destValues){
				if(e.equals(objValue)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static List<Serializable> getInteresctList(@SuppressWarnings("unchecked") List<Serializable> ...lists){
		Set<Serializable> set = new HashSet<>();
		List<Serializable> result = new ArrayList<>();
		for(List<Serializable> list:lists){
			for(Serializable e:list){
				if(set.add(e)){
					result.add(e);
				}
			}
		}
		return result;
	}
}
