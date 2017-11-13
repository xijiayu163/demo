package com.yu.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.util.CollectionUtils;

public class BeanMapperUtils {

	public static <E, T> List<T> mapList(Mapper mapper, Collection<E> sourceList, Class<T> destinationClass) {
		if (sourceList == null) {
			return null;
		}
		if (CollectionUtils.isEmpty(sourceList)) {
			return new ArrayList<T>();
		}

		List<T> destinationList = new ArrayList<T>();
		for (Iterator<E> i = sourceList.iterator(); i.hasNext();) {
			Object sourceObject = i.next();
			T destinationObject = mapper.map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}
}
