package com.yu.study.common.dozer.converter;

import org.dozer.CustomConverter;

import com.yu.util.DeclaredFieldsUtil;

/**
 * dozer自定义转换器
 * enum与String互转
 * 
 * 注：
 * enum转String：枚举类中必须提供getValue()的方法。
 * String转enum：枚举类中必须提供valueOfStr()的方法。
 *
 * @author ksh 康胜虎
 * @date 2016年11月4日下午5:15:53
 * @since 3.7
 */
public class EnumStringConverter implements CustomConverter{

	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		if(source == null) return null;
		
		if(source instanceof Enum) {
			Object obj = DeclaredFieldsUtil.getFieldValueByName("value", source);
			if(obj == null) return null;
			return obj.toString();
		}
		
		if(source instanceof String){
			Enum enum1 = (Enum) DeclaredFieldsUtil.getObjByMethodName("valueOfStr", destClass, source);
			if(enum1 == null) return null;
			return enum1;
		}
		
		return null;
	}

}
