package com.yu.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.util.ReflectionUtils;

public class ReflectUtil extends ReflectionUtils{

	/**
	 * 判断实体对象的属性是否有值，即至少有一个字段不为null
	 * 
	 * @param entryObj
	 * @param clazz
	 * @return
	 * @author 张超
	 * @date 2016年3月23日-下午2:49:54
	 */
	public static Boolean hasObjFieldNullValue(Object entryObj, Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				if(field.get(entryObj) != null && !Modifier.isStatic(field.getModifiers())){
					try {
						if(field.get(entryObj).toString().matches("\\s*|t|r|n")){
							return false;
						}
					} catch (Exception e) {}
					return true;
				}
			}
			catch (Exception e) {
				// ingore
			}
		}
		return false;
	}
}