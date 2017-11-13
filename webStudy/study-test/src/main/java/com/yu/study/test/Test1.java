package com.yu.study.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yu.study.common.search.ResolveStrategeEnum;
import com.yu.study.common.search.SearchCondition;
import com.yu.study.common.search.SearchWrapper;
import com.yu.study.common.web.Page;
import com.yu.study.dao.po.UserPo;
import com.yu.util.JsonUtil;

public class Test1 {
	public static void main(String[] args) throws JsonProcessingException {
//		UserPoExample example = new UserPoExample();
//		Page<UserPo> page = new Page<>();
//		page.setPageNo(0);
//		page.setPageSize(3);
//		String obj2Json = JsonUtil.obj2Json(page);
//		System.out.println(obj2Json);
		
		
//		Map<String, Object> map = new HashMap<>();
////		map.put("userName", "222");
//		List<String> list = new ArrayList<>();
//		list.add("33");
//		list.add("44");
//		map.put("age", 555);
//		map.put("userName", list);
//		
//		String obj2Json = JsonUtil.obj2Json(map);
//		System.out.println(obj2Json);
		
		
		
		
		List<SearchCondition> conditions = new ArrayList<>();
		SearchCondition searchCondition = new SearchCondition();
		searchCondition.setStrategeEnum(ResolveStrategeEnum.GreaterThan);
		searchCondition.setParamName("age");
		searchCondition.setParamValue(66);
		conditions.add(searchCondition);
		
		searchCondition = new SearchCondition();
		searchCondition.setStrategeEnum(ResolveStrategeEnum.Like);
		searchCondition.getParamNames().add("userName");
		searchCondition.getParamNames().add("company");
		searchCondition.setParamValue("me");
		conditions.add(searchCondition);
		
		SearchWrapper wrapper = new SearchWrapper();
		wrapper.setSearchConditions(conditions);
		wrapper.setPage(new Page());
		
		String obj2Json = JsonUtil.obj2Json(wrapper);
		System.out.println(obj2Json);
		
	}
}
