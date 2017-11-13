package com.yu.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.util.Assert;

/**
 * java对象反射工具类
 * 
 * @author ksh 康胜虎
 * @date 2016年8月16日上午10:43:36
 * @since 3.5
 */
public class DeclaredFieldsUtil {
	
	/**
	 * 通过属性名获取对象的属性值
	 * @author ksh 康胜虎
	 * @date 2016年8月16日上午10:49:32
	 * @since 3.5
	 *
	 * @param fieldName 属性名称
	 * @param obj 属性所属对象
	 * @return 属性值
	 */
	public static Object getFieldValueByName(String fieldName, Object obj){
		try {
			Class<?> clsClass = obj.getClass();
			List<Method> methods = new ArrayList<Method>(Arrays.asList(clsClass.getDeclaredMethods()));
			methods.addAll(Arrays.asList(clsClass.getSuperclass().getDeclaredMethods()));
			String fieldGetName = parGetName(fieldName);
			if(!checkGetMet(methods, fieldGetName)){
				return null;
			}
			
			Method method = clsClass.getMethod(fieldGetName, new Class[] {});      
			Object value = method.invoke(obj, new Object[] {});
	        return value;
		} catch (Exception e) {
			throw new RuntimeException("get '" + fieldName + "' value by '" + obj.getClass().getName() + "' exception.", e);
		}
	}
	
	/**
	 * 
	 * 根据方法名称获取属性值
	 * 
	 * @author ksh
	 * @date 2017年6月27日
	 * @since 1.13p
	 *
	 * @param methodName
	 * @param clsClass
	 * @param paramObj
	 * @return
	 */
	public static Object getObjByMethodName(String methodName, Class<?> clsClass, Object paramObj){
		try {			
			Method method = clsClass.getMethod(methodName, paramObj.getClass());  
			Object value = method.invoke(clsClass, paramObj);
	        return value;
		} catch (Exception e) {
			throw new RuntimeException("get value by '" + methodName + "' exception.", e);
		}
	}
	
	/**
	 * 根据属性名称对对象属性赋值
	 * @author ksh 康胜虎
	 * @date 2016年10月10日上午10:06:01
	 * @since 3.7
	 *
	 * @param fieldName
	 * @param fieldValue
	 * @param obj
	 */
	public static void setFieldValueByName(String fieldName, Object fieldValue, Object obj){
		try {
			Class<?> clsClass = obj.getClass();
			List<Method> methods = new ArrayList<Method>(Arrays.asList(clsClass.getDeclaredMethods()));
			methods.addAll(Arrays.asList(clsClass.getSuperclass().getDeclaredMethods()));
			String fieldSetName = parSetName(fieldName);
			if(!checkSetMet(methods, fieldSetName)){
				return;
			}
			
			Field[] fields = clsClass.getDeclaredFields();
			for(Field field:fields){
				if(field.getName().equals(fieldName)){
					Method method = obj.getClass().getMethod(fieldSetName, field.getType());
					switch (field.getGenericType().toString()) {
					case "class java.lang.String":{
						method.invoke(obj, fieldValue.toString());
						break;
					}
					case "class java.util.Date":{
						Date date = parseDate(fieldValue.toString());
						method.invoke(obj, date);
						break;
					}
					case "class java.lang.Integer":{
						Integer integer = Integer.valueOf(fieldValue.toString());
						method.invoke(obj, integer);
						break;
					}
					case "class java.lang.Long":{
						Long lng = Long.valueOf(fieldValue.toString());
						method.invoke(obj, lng);
						break;
					}
					case "class java.lang.Double":{
						Double d = Double.valueOf(fieldValue.toString());
						method.invoke(obj, d);
						break;
					}
					case "class java.lang.Boolean":{
						Boolean bolean = Boolean.valueOf(fieldValue.toString());
						method.invoke(obj, bolean);
						break;
					}
					default:
						System.out.println("not supper type" + field.getGenericType().toString());
					}
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException("set '" + fieldName + "' value to '" + fieldValue.toString() + "' for '" + obj.getClass().getName() + "' exception.", e);
		}
	}
	
	/**
	 * 判断是否存在某属性的 get方法 
	 * @author ksh 康胜虎
	 * @date 2016年10月10日下午4:22:54
	 * @since 3.7
	 *
	 * @param methods
	 * @param fieldGetMet
	 * @return
	 */
    private static boolean checkGetMet(List<Method> methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * 判断是否存在某属性的 set方法 
	 * @author ksh 康胜虎
	 * @date 2016年10月10日下午4:23:01
	 * @since 3.7
	 *
	 * @param methods
	 * @param fieldSetMet
	 * @return
	 */
    private static boolean checkSetMet(List<Method> methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {  
                return true;
            }
        }
        return false;
    }
    
    /**
     * 拼接某属性的 get方法 
     * @author ksh 康胜虎
     * @date 2016年10月10日下午4:23:08
     * @since 3.7
     *
     * @param fieldName
     * @return
     */
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }
    
    /**
     * 拼接在某属性的 set方法  
     * @author ksh 康胜虎
     * @date 2016年10月10日下午4:23:14
     * @since 3.7
     *
     * @param fieldName
     * @return
     */
    private static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }
    
    /**
     * 格式化string为Date
     * @author ksh 康胜虎
     * @date 2016年10月10日下午4:23:25
     * @since 3.7
     *
     * @param datestr
     * @return
     */
    private static Date parseDate(String datestr) {
        if (null == datestr || "".equals(datestr)) {
            return null;
        }
        try {
            String fmtstr = null;
            if (datestr.indexOf(':') > 0) {
                fmtstr = "yyyy-MM-dd HH:mm:ss";
            } else {
                fmtstr = "yyyy-MM-dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);
            return sdf.parse(datestr);
        } catch (Exception e) {
            throw new RuntimeException(datestr + " parse to Date fail.", e);
        }
    }
    
    /**
     * 日期转化为String
     * @author ksh 康胜虎
     * @date 2016年10月10日下午4:23:34
     * @since 3.7
     *
     * @param date
     * @return
     */
    private static String fmtDate(Date date) {
        if (null == date) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            return sdf.format(date);
        } catch (Exception e) {
        	throw new RuntimeException(date + " format to String fail.", e);
        }
    }
    
    public static Map<String,String> getObjPropertyToMap(Object obj){
    	return getObjPropertyToMap(obj, null);
    }
    
    /**
	 * 将对象属性及值 去除空值，存入map
	 * 
	 * @author ksh 康胜虎
	 * @date 2016年8月30日下午2:38:02
	 * @since 3.6
	 *
	 * @param obj
	 * @param ignoreFields
	 * @return
	 */
	public static Map<String,String> getObjPropertyToMap(Object obj, String[] ignoreFields){
		Assert.notNull(obj);
		Map<String,String> paramMap = new HashMap<String, String>();
		Field[] fields = obj.getClass().getDeclaredFields();
		List<Field> fieldsList = new ArrayList<Field>(Arrays.asList(fields));
		if(obj.getClass().getSuperclass() != null){
			Class supperClz = obj.getClass().getSuperclass();
			Field[] supperFields = supperClz.getDeclaredFields();
			fieldsList.addAll(Arrays.asList(supperFields));
		}
		// 去除忽略的字段
		if(ignoreFields != null && ignoreFields.length > 0){
			List<String> ignoreFieldList = new ArrayList<String>(Arrays.asList(ignoreFields));
			List<Field> removeFieldList = new ArrayList<Field>();
			for(Field field:fieldsList){
				for(String s:ignoreFieldList){
					if(field.getName().equals(s)){
						removeFieldList.add(field);
					}
				}
			}
			fieldsList.removeAll(removeFieldList);
		}
		
		
		for(Field field:fieldsList){
    		String fieldName = field.getName();
    		Object fieldValue = DeclaredFieldsUtil.getFieldValueByName(field.getName(),obj);
    		if(ObjectUtils.isEmpty(fieldValue)) continue;
    		paramMap.put(fieldName, fieldValue.toString());
    	}
		
		return paramMap;
	}
    
	public static void main(String[] args) {
		/*AliPayResult aliPayResult = new AliPayResult();
		System.out.println(aliPayResult.getSign());
		setFieldValueByName("sign", "aaaaaaaa", aliPayResult);
		System.out.println(aliPayResult.getSign());*/
	}
}
