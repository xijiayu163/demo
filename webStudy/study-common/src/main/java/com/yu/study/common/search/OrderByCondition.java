package com.yu.study.common.search;

public class OrderByCondition {
	private String fieldName;
	private Boolean ascFlag;
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Boolean isAscFlag() {
		return ascFlag;
	}
	public void setAscFlag(Boolean ascFlag) {
		this.ascFlag = ascFlag;
	}
}
