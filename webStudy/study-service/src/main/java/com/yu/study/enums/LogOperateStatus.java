package com.yu.study.enums;

/**
 * 日志操作状态,对应字段operate_status
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum LogOperateStatus {
	Add("add");
	
	private String aliasName;
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	private LogOperateStatus(String aliasName){
		this.aliasName = aliasName;
	}
}
