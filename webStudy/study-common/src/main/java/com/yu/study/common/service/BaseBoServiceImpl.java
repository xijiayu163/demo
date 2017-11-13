package com.yu.study.common.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yu.study.common.search.ResolveStrategeEnum;
import com.yu.study.common.search.SearchCondition;
import com.yu.study.common.search.SearchWrapper;
import com.yu.study.common.web.Page;
import com.yu.util.BeanMapperUtils;
import com.yu.util.CollectionUtil;
import com.yu.util.IntrospectionUtils;
import com.yu.util.JsonUtil;

/**组合模式实现复合servie
 * Boservice操作的对象为Bo，里面的数据默认是主从关系,也即一对一或者一对多
 * @author xijia
 *
 * @param <T>
 */
public abstract class BaseBoServiceImpl<T> extends AbstractBaseServiceImpl<T> implements BaseBoService<T>{

	/**返回需要使用的service,子类可动态改变，以达到设置开关按需加载或按需插入的效果
	 * 如果做删除操作，级联删除，需要将所有相关的service返回
	 * @return
	 */
	protected abstract List<BaseService<?>> getServices(LoadStrategy loadStrategy);
	
	protected abstract LoadStrategy getServicesOfLoadAllStrategy();
	
	public abstract LoadStrategy parseStrategy(String strategyJsonStr);
	
	@Override
	public String getIdentifierName(){
		throw new NotImplementedException("Bo service 不能设置标识符");
	}

	@Override
	public SearchWrapper find(SearchWrapper searchWrapper) {
		throw new NotImplementedException("不支持的操作");
	}

	@SuppressWarnings("unused")
	private List<T> compositeData(BaseService<?> firstService,Map<BaseService<?>,SearchWrapper> results,String fisrtIdentifierName) throws Exception{
		//分析result,将其组装成合适的结果集
		List<T> tList = new ArrayList<>();
		SearchWrapper result = results.get(firstService);
		Class<?> tClassType = ((AbstractBaseServiceImpl<?>)firstService).getTClassType();
		for(Object object:result.getResults()){
			//obj 为Po对象,形如OrderPo,将其转换成Do或者Bo
			Object obj = getMapper().map(object, tClassType);
			//取出当前instance(orderDo)的标识值(orderUid对应的值)
			String identifierValue = ((AbstractBaseServiceImpl<?>)firstService).getIdentifierValue(obj);
			T instance = getTClassType().newInstance();
			tList.add(instance);
			String propertyName = ((AbstractBaseServiceImpl<?>)firstService).getPropertyName();
			String setter = getSetter(propertyName);
			//调用setOrderDo
			IntrospectionUtils.callMethodN(instance,setter, 
					new Object[]{obj}, new Class<?>[]{tClassType});
			
			
			for(BaseService<?> service:results.keySet()){
				if(service.equals(firstService)){
					continue;
				}else{
					//从集合中查找出属于当前intance的子集合或单条记录，赋给instance的setOrderGoodsDoList
					//取出记录集
					SearchWrapper currentSearchWrapper = results.get(service);
					//映射成Bo或者Do
					Class<?> subClassType = ((AbstractBaseServiceImpl<?>)service).getTClassType();
					List<?> currentResult = BeanMapperUtils.mapList(getMapper(), currentSearchWrapper.getResults(), tClassType);
					//从记录集中找出匹配当前instance属性值的子集合
					List<?> matchResult = CollectionUtil.getAllMatch(currentResult, fisrtIdentifierName, identifierValue);
					if(CollectionUtils.isEmpty(matchResult)){
						continue;
					}
					//获取当前service操作的对象类名作为属性
					String subPropertyName = ((AbstractBaseServiceImpl<?>)service).getPropertyName();
					//查找上层Bo是否包含该属性
					if(foundProperty(subPropertyName)){
						//有找到，表示是单个属性,默认取第一条将属性设值
						setter = getSetter(subPropertyName);
						IntrospectionUtils.callMethodN(instance,setter, 
								new Object[]{matchResult.get(0)}, new Class<?>[]{subClassType});
					}else{
						//未找到单个属性，尝试找List结尾,将匹配集合赋值到该属性
						subPropertyName = subPropertyName+"List";
						if(foundProperty(subPropertyName)){
							setter = getSetter(subPropertyName);
							IntrospectionUtils.callMethodN(instance,setter, 
									new Object[]{matchResult}, new Class<?>[]{List.class});
						}
					}
				}
			}
		}
		
		return tList;
	}
	
	@SuppressWarnings("unused")
	private void removeNoEffectRecordFromResult(List<T> tList,String fisrtIdentifierName){
		//找出标识交集
		Set<Serializable> set = new HashSet<>();
		for(Object object2:tList){
			if(object2 instanceof List){
				List<?> list = (List<?>)object2;
				for(Object item:list){
					Serializable value = (Serializable) IntrospectionUtils.getProperty(item, fisrtIdentifierName);
					set.add(value);
				}
			}else{
				Serializable value = (Serializable) IntrospectionUtils.getProperty(object2, fisrtIdentifierName);
				set.add(value);
			}
		}
		
		//遍历，去掉不在交集中的数据
		Iterator<T> iterator = tList.iterator();
		while(iterator.hasNext()){
			T next = iterator.next();
			Serializable value = (Serializable) IntrospectionUtils.getProperty(next, fisrtIdentifierName);
			if(!set.contains(value)){
				iterator.remove();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		SearchWrapper find = find(null);
		return (List<T>) find.getResults();
	}

	@Override
	public T get(Serializable id) {
		LoadStrategy strategy = getServicesOfLoadAllStrategy();
		return get(id,strategy);
	}

	@Override
	public T get(Serializable id,LoadStrategy loadStrategy){
		List<BaseService<?>> services = getServices(loadStrategy);
		
		try{
			if(services.size()==0){
				return null;
			}
			
			T instance = getTClassType().newInstance();
			String fisrtIdentifierName = services.get(0).getIdentifierName();
			Object firstValue = null;
			BaseService<?> firstService = null;
			for(int i=0;i<services.size();i++){
				BaseService<?> service = services.get(i);
				SearchWrapper searchWrapper = new SearchWrapper();
				SearchCondition condition = new SearchCondition();
				boolean found = false;
				Class<?> tClassType = ((AbstractBaseServiceImpl<?>)service).getTClassType();
				if(i==0){
					firstService = service;
					fisrtIdentifierName = service.getIdentifierName();
					condition.setParamName(fisrtIdentifierName);
					condition.setParamValue(id);
					found = true;
				}else{
					//如果当前属性类中的属性包含有第一个属性类的唯一标识名，则继续使用该标识名查询
					found = ((AbstractBaseServiceImpl<?>)service).foundProperty(fisrtIdentifierName);
					if(found){
						condition.setParamName(fisrtIdentifierName);
						condition.setParamValue(id);
					}
					//如果当前属性类中的属性不包含有第一个属性类的唯一标识名
					//从第一个属性类中找到包含有当前属性类的唯一标识名，使用该标识名与它对应的值继续查询
					if(!found){
						found = ((AbstractBaseServiceImpl<?>)firstService).foundProperty(service.getIdentifierName());
						if(found){
							condition.setParamName(service.getIdentifierName());
							condition.setParamValue(getIdentifierValue(firstValue));
						}
					}
				}
				
				if(!found){
					continue;
				}
				
				searchWrapper.getSearchConditions().add(condition);
				SearchWrapper find = service.find(searchWrapper);
				if(CollectionUtils.isEmpty(find.getResults())){
					continue;
				}
				
				List<?> results = BeanMapperUtils.mapList(getMapper(), find.getResults(), tClassType);
				
				String propertyName = ((AbstractBaseServiceImpl<?>)service).getPropertyName();
				if(foundProperty(propertyName)){
					String setter = getSetter(propertyName);
					IntrospectionUtils.callMethodN(instance,setter, 
							new Object[]{results.get(0)}, new Class<?>[]{tClassType});
				}else{
					propertyName = propertyName+"List";
					if(foundProperty(propertyName)){
						String setter = getSetter(propertyName);
						IntrospectionUtils.callMethodN(instance,setter, 
								new Object[]{results}, new Class<?>[]{List.class});
					}
				}
			}
			return instance;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public String create(Object entity) {
		List<BaseService<?>> services = getServices(getServicesOfLoadAllStrategy());
		
		//校验对象组合的正确性，不能包含同一个xxxDaoImpl多次,防止重复插入
		String duplicateDaoServieImpl = checkCompositeValidation(services);
		if(duplicateDaoServieImpl!=null){
			throw new RuntimeException("发现多次的包含同一个DaoService,"+duplicateDaoServieImpl);
		}
		
		return doCreate(entity,null,null);
	}
	
	/**采用递归插入,前提条件是被包含Bo的第一个Do也是属于主从关系
	 * @param entity
	 * @param foreignKeyValue
	 * @return
	 */
	public String doCreate(Object entity,String foreignKey,String foreignKeyValue){
		List<BaseService<?>> services = getServices(getServicesOfLoadAllStrategy());
		
		try{
			String fisrtIdentifierName = null;
			String firstGeneratePrimaryKey = null;
			for(int i=0;i<services.size();i++){
				AbstractBaseServiceImpl<?> service = (AbstractBaseServiceImpl<?>) services.get(i);
				String currentIdentifierName =service.getIdentifierName();
				if(StringUtils.hasText(currentIdentifierName)){
					//反射获取服务需要操作的对象
					//1解析service名字  OrderDoServiceImpl=>orderDo
					String doPropertyName = service.getPropertyName();
					//2 反射获取该属性名对应的属性值,可能为单实体 也可能是List
					Object object = IntrospectionUtils.getProperty(entity, doPropertyName);
					if(object==null){
						String doListPropertyName = service.getPropertyListNameByServiceClass();
						object = IntrospectionUtils.getProperty(entity, doListPropertyName);
					}
					if(i==0){
						if(foreignKey!=null){
							//设置外键
							IntrospectionUtils.setProperty(object, foreignKey, foreignKeyValue);
						}
						firstGeneratePrimaryKey = service.create(object);
						fisrtIdentifierName = currentIdentifierName;
					}else if(i>0){
						if(object instanceof List){
							@SuppressWarnings("unchecked")
							List<Object> list = (List<Object>)object;
							for(Object obj:list){
								service.doCreate(obj, fisrtIdentifierName, firstGeneratePrimaryKey);
							}
						}else{
							service.doCreate(object, fisrtIdentifierName, firstGeneratePrimaryKey);
						}
					}
				}
			}
			
			return firstGeneratePrimaryKey;
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public String update(Object entity) {
		LoadStrategy strategy = getServicesOfLoadAllStrategy();
		return update(entity,strategy);
	}

	public String update(Object entity,LoadStrategy loadStrategy){
		List<BaseService<?>> services = getServices(loadStrategy);
		
		//校验对象组合的正确性，不能包含同一个xxxDaoImpl多次,防止重复插入
		String duplicateDaoServieImpl = checkCompositeValidation(services);
		if(duplicateDaoServieImpl!=null){
			throw new RuntimeException("发现多次的包含同一个DaoService,"+duplicateDaoServieImpl);
		}
		try{
			String firstGeneratePrimaryKey = null;
			for(int i=0;i<services.size();i++){
				AbstractBaseServiceImpl<?> service = (AbstractBaseServiceImpl<?>) services.get(i);
				String currentIdentifierName =service.getIdentifierName();
				if(StringUtils.hasText(currentIdentifierName)){
					//反射获取服务需要操作的对象
					//1解析service名字  OrderDoServiceImpl=>orderDo
					String doPropertyName = service.getPropertyName();
					//2 反射获取该属性名对应的属性值,可能为单实体 也可能是List
					Object object = IntrospectionUtils.getProperty(entity, doPropertyName);
					if(object==null){
						String doListPropertyName = service.getPropertyListNameByServiceClass();
						object = IntrospectionUtils.getProperty(entity, doListPropertyName);
					}
					if(i==0){
						service.update(object);
						firstGeneratePrimaryKey = service.getIdentifierValue(object);
					}else if(i>0){
						if(object instanceof List){
							@SuppressWarnings("unchecked")
							List<Object> list = (List<Object>)object;
							for(Object obj:list){
								service.update(obj);
							}
						}else{
							service.update(object);
						}
					}
				}
			}
			
			return firstGeneratePrimaryKey;
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void deleteById(Serializable id) {
		List<BaseService<?>> services = getServices(getServicesOfLoadAllStrategy());
		
		try{
			BaseService<?> firstService = services.get(0);
			for(int i=services.size()-1;i>=0;i--){
				if(i==0){
					services.get(i).deleteById(id);
				}else{
					SearchWrapper searchWrapper = new SearchWrapper();
					SearchCondition e = new SearchCondition();
					e.setParamName(firstService.getIdentifierName());
					e.setParamValue(id);
					e.setStrategeEnum(ResolveStrategeEnum.EqualTo);
					searchWrapper.getSearchConditions().add(e);
					services.get(i).delete(searchWrapper);
				}
			}
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void delete(Serializable[] ids) {
		List<BaseService<?>> services = getServices(getServicesOfLoadAllStrategy());
		
		SearchWrapper searchWrapper = new SearchWrapper();
		SearchCondition e = new SearchCondition();
		e.setParamName(services.get(0).getIdentifierName());
		for(Serializable id:ids){
			e.getParamValues().add(id);
		}
		e.setStrategeEnum(ResolveStrategeEnum.EqualTo);
		searchWrapper.getSearchConditions().add(e);
		delete(searchWrapper);
	}

	public void delete(SearchWrapper searchWrapper){
		List<BaseService<?>> services = getServices(getServicesOfLoadAllStrategy());
		
		try{
			for(int i=services.size()-1;i>=0;i--){
				services.get(i).delete(searchWrapper);
			}
		}catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**查看是否有重复的service
	 * @return
	 */
	private String checkCompositeValidation(List<BaseService<?>> services) {
		List<String> serviceNames = new ArrayList<>();
		for(BaseService<?> service:services){
			if(serviceNames.contains(service.getClass().getName())){
				return  service.getClass().getName();
			}else{
				serviceNames.add(service.getClass().getName());
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		SearchWrapper searchWrapper = new SearchWrapper();
		searchWrapper.setPage(new Page());
		SearchCondition e = new SearchCondition();
		e.setParamName("orderAccount");
		e.setParamValue("90011640");
		e.setStrategeEnum(ResolveStrategeEnum.EqualTo);
		searchWrapper.getSearchConditions().add(e);
		System.out.println(JsonUtil.obj2Json(searchWrapper));
	}
}
