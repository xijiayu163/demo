package com.yu.study.common.dozer.converter;

import java.util.Date;

import org.dozer.CustomConverter;

import com.yu.util.DateUtil;

/**
 * 身份证号与生日进行转换，只支持身份证号转生日
 *
 * @author ksh 康胜虎
 * @date 2016年11月17日下午4:55:27
 * @since 3.7
 */
public class IdNumberToBirthdayConverter implements CustomConverter{

	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		if(source == null) return null;
		
		if(source instanceof String && destination instanceof Date) {
			String idNumber = source.toString();
			
			if(idNumber.length() != 18){
				return null;
			}
			
			Date birthDay = DateUtil.parse2(idNumber.substring(6, 13) + "000000");
			if(birthDay == null) return null;
			
			return birthDay;
		}
		
		return null;
	}

}
