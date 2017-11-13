package com.yu.study.common.web;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yu.study.common.search.SearchWrapper;
import com.yu.study.common.service.BaseBoService;
import com.yu.study.common.service.BaseService;
import com.yu.study.common.service.LoadStrategy;
import com.yu.study.common.spring.SpringContextHolder;
import com.yu.util.BeanMapperUtils;

public class BaseController<V,T> extends AbstractController{
	
	private Class<V> vClass = null;
	private Class<T> tClass = null;
	private String serviceName = null;
	
	protected String getServiceName(){
		if (serviceName == null) {
			String className = getTClassType().getSimpleName();
			String firstChar = className.substring(0, 1);
			String remainChars = className.substring(1, className.length());
			serviceName = firstChar.toLowerCase() + remainChars + "ServiceImpl";
		}
		return serviceName;
	}
	
	/**获取当前实体，默认根据当前Controller类名xxxControler解析得到xxxServiceImpl
	 * 如果不符合该命名标准，可在子类重写方法.例如在子类中根据类型获取SpringContextHolder.getBean(xxxService.class);
	 * @return
	 */
	protected BaseService<T> getServiceInstance(){
		return SpringContextHolder.getBean(getServiceName());
	}
	
	
	@SuppressWarnings("unchecked")
	private Class<V> getVClassType(){
		if(vClass==null){
			//获取当前new对象的泛型的父类类型  
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			vClass = (Class<V>) parameterizedType.getActualTypeArguments()[0];
		}
	    
	    return vClass;
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getTClassType(){
		if(tClass==null){
			//获取当前new对象的泛型的父类类型
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();  
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			tClass = (Class<T>) actualTypeArguments[1];
		}

	    return tClass;
	}
	
	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseBody
	public SearchWrapper find(@RequestBody SearchWrapper searchWrapper){
		searchWrapper = getServiceInstance().find(searchWrapper);
		return searchWrapper;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<V> findAll(){
		List<T> list = getServiceInstance().findAll();
		return BeanMapperUtils.mapList(getMapper(), list, getVClassType());
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseBody
	public V get(@PathVariable("id") Serializable id){
		T b = getServiceInstance().get(id);
		if(b==null){
			return null;
		}else{
			return getMapper().map(b, getVClassType());
		}
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	@ResponseBody
	public V get(@RequestBody String loadStrategy,@PathVariable("id") Serializable id){
		BaseBoService<T> baseBoService = (BaseBoService<T>)getServiceInstance();
		LoadStrategy strategy = baseBoService.parseStrategy(loadStrategy);
		T b = baseBoService.get(id,strategy);
		if(b==null){
			return null;
		}else{
			return getMapper().map(b, getVClassType());
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody V v,HttpServletResponse response){
		T b = getMapper().map(v, getTClassType());
		response.setStatus(HttpStatus.CREATED.value());
		return getServiceInstance().create(b);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public String update(@PathVariable("id") Serializable id,@RequestBody V v,HttpServletResponse response){
		T b = getMapper().map(v, getTClassType());
		return getServiceInstance().update(b);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteById(@PathVariable("id") Serializable id){
		getServiceInstance().deleteById(id);
	}
}
