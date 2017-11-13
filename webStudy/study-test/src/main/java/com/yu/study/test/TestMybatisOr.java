//import com.yu.study.dao.po.UserPoExample;
//import com.yu.study.dao.po.UserPoExample.Criteria;

//package com.yu.study.test;
//
//import com.yu.study.common.spring.SpringContextHolder;
//import com.yu.study.dao.mapper.UserPoMapper;
//import com.yu.study.dao.po.UserPoExample;
//import com.yu.study.dao.po.UserPoExample.Criteria;
//
//public class TestMybatisOr {
//	private void testExample(){
//		UserPoExample example = new UserPoExample();
//		Criteria criteria;
//		//1
//		criteria = example.createCriteria().andAccountUidEqualTo("11");
//		//2
//		criteria = example.createCriteria().andAgeEqualTo(2);
////		example.getOredCriteria().add(criteria2);
//		example.getOredCriteria().get(0).getAllCriteria().addAll(criteria.getAllCriteria());
//		//3 碰到关键字搜索,每一个待搜索的字段与criteria与 最后再或,加入关键字为company和userNmae
//		//3.1
//		Criteria copyCriteria1 = copyCriteria(example.getOredCriteria().get(0));
//		copyCriteria1.andCompanyLike("com");
//		Criteria copyCriteria2 = copyCriteria(example.getOredCriteria().get(0));
//		copyCriteria2.andUserNameLike("un");
//		example.getOredCriteria().removeAll(example.getOredCriteria());
//		example.or(copyCriteria1);
//		example.or(copyCriteria2);
//		
//		//4 另一个关键字搜索，相关字段为password和accountuid
//		
//		System.out.println("xxxx");
//		
//		int size = example.getOredCriteria().size();
//		for(int i=0;i<size;i++){
//			Criteria cta = example.getOredCriteria().get(i);
//			Criteria copyCriteria111 = copyCriteria(cta);
//			copyCriteria111.andUserPasswordLike("dd");
//			example.or(copyCriteria111);
//			Criteria copyCriteria222 = copyCriteria(cta);
//			copyCriteria222.andAccountUidLike("id");
//			example.or(copyCriteria222);
//		}
//		for(int i=size-1;i>=0;i--){
//			example.getOredCriteria().remove(i);
//		}
//		
//		
//		//5 下一个是普通的and，以age为例子
//		size = example.getOredCriteria().size();
//		for(int i=0;i<size;i++){
//			Criteria cta = example.getOredCriteria().get(i);
//			cta.andAgeEqualTo(55);
//		}
//		
//		
//		
//		
////		criteria1.getAllCriteria().addAll(criteria2.getAllCriteria());
//		UserPoMapper userPoMapper = SpringContextHolder.getBean(UserPoMapper.class);
//		userPoMapper.selectByExample(example);
//}


//	private Criteria copyCriteria(Criteria criteria){
//		UserPoExample example = new UserPoExample();
//		Criteria copy = example.createCriteria();
//		copy.getAllCriteria().addAll(criteria.getAllCriteria());
//		
//		return copy;
//	}
