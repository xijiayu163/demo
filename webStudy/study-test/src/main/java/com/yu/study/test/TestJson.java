package com.yu.study.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class TestJson {
	
	private String p1;
	private String p2;
	
	protected TestJson(String xxx){
		
	}
	
	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }
	}
	
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
	
	public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
	
	public static void main(String[] args) {
		test1();
	}
	
	private static void test1(){
		Criteria criteria = new Criteria();
		Criterion criterion = new Criterion("xxvcx");
		criteria.getAllCriteria().add(criterion);
		
		String jsonString = JSON.toJSONString(criteria);
		System.out.println(jsonString);
		Criteria parse = JSON.parseObject(jsonString,Criteria.class);
		System.out.println(parse);
	}
	
	private static void test2(){
		TestJson testJson = new TestJson("fdsfdsdf");
		testJson.setP1("1");
		testJson.setP2("2");
		
		String jsonString = JSON.toJSONString(testJson);
		System.out.println(jsonString);
		TestJson parse = JSON.parseObject(jsonString,TestJson.class);
		System.out.println(parse);
	}

	
}
