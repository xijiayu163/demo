package com.yu.study.common.spring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;


/**mimsp项目配置文件（集成spring）
 * @author xijia
 *
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

	private static Map<String, String> configMap = null;
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		Map<String, String> map = new HashMap<String, String>();
		for(Object key: props.keySet()){
			map.put(key.toString(), props.getProperty(key.toString()));
		}
		configMap = Collections.unmodifiableMap(map);
	}
	
	/**
	 * 获取配置配置文件，不可以修改
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key){
		String value = configMap.get(key);
		if(StringUtils.hasText(value)){
			return value;
		}
		throw new RuntimeException("no fonud config key : " + key);
	}
}