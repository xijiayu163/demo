package com.yu.study.enums;

/**
 * 日志类型,分为手动和系统
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum LogTypeEnum {
	System("system"),Manual("manual");
	
	private String aliasName;
	
	private LogTypeEnum(String aliasName){
		this.aliasName = aliasName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	public String getValue(){
		return aliasName;
	}
	
	public static LogTypeEnum valueOfStr(String val) {
		if(val == null) return null;
		
		for (LogTypeEnum logTypeEnum : LogTypeEnum.values()) {
			if (logTypeEnum.aliasName.equals(val)) {
				return logTypeEnum;
			}
		}
		return null;
	}
}
