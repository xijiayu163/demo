package com.yu.study.common.search.mybatis;

import com.yu.study.common.search.ResolveStrategy;

import java.util.Arrays;
import java.util.List;

import com.yu.study.common.search.ResolveStrategeEnum;
import com.yu.study.common.search.ResolveStrategyFactory;
import com.yu.util.IntrospectionUtils;

/**解析策略工厂类,使用双检锁机制,线程安全及高效
 * @author xijia
 *
 */
public class MybatisResolveStrategyFactory implements ResolveStrategyFactory{
	
	volatile private static MybatisResolveStrategyFactory instance = null;
	
	private MybatisResolveStrategyFactory(){}  
	
	public static MybatisResolveStrategyFactory getInstance() {  
        try {    
            if(instance != null){//懒汉式   
                  
            }else{  
                //创建实例之前可能会有一些准备性的耗时工作   
                Thread.sleep(300);  
                synchronized (MybatisResolveStrategyFactory.class) {  
                    if(instance == null){//二次检查  
                        instance = new MybatisResolveStrategyFactory();  
                    }  
                }  
            }   
        } catch (InterruptedException e) {   
            e.printStackTrace();  
        }  
        return instance;  
    }  
	
	@Override
	public ResolveStrategy createStrategy(ResolveStrategeEnum strategeEnum) {
		try {
			String className = "com.yu.study.common.search.mybatis.MybatisResolveStrategyFactory$Mybatis"+strategeEnum.name()+"ResolveStrategy";
			ResolveStrategy strategy = (ResolveStrategy) Class.forName(className).newInstance();
			return strategy;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static class MybatisBetweenResolveStrategy extends AbstractBetweenMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "Between";
		}
	}
	
	public static class MybatisEqualToResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "EqualTo";
		}
	}
	
	public static class MybatisGreaterThanOrEqualToResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "GreaterThanOrEqualTo";
		}
	}
	
	public static class MybatisGreaterThanResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "GreaterThan";
		}
	}
	
	public static class MybatisInResolveStrategy extends AbstractMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "In";
		}
	}
	
	public static class MybatisIsNotNullResolveStrategy extends AbstractNoValueMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "IsNotNull";
		}
	}
	
	public static class MybatisIsNullResolveStrategy extends AbstractNoValueMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "IsNull";
		}
	}
	
	public static class MybatisLessThanOrEqualToResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "LessThanOrEqualTo";
		}
	}
	
	public static class MybatisLessThanResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "LessThan";
		}
	}
	
	public static class MybatisLikeResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "Like";
		}
		
		@Override
		protected void doInternalResolveConditionObject(Object conditionObj) throws Exception{
			IntrospectionUtils.callMethodN(conditionObj, getMethodName(), 
					new Object[]{'%'+getParamValue().toString()+'%'}, new Class<?>[]{getParamType()});
		}
	}

	public static class MybatisNotBetweenResolveStrategy extends AbstractBetweenMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "NotBetween";
		}
	}
	
	public static class MybatisNotEqualToResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "NotEqualTo";
		}
	}
	
	public static class MybatisNotInResolveStrategy extends AbstractMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "NotIn";
		}
	}
	
	public static class MybatisNotLikeResolveStrategy extends AbstractSimpleMybatisResolveStrategy{
		@Override
		protected String getMethodNameSuffix() {
			return "NotLike";
		}
	}
}
