package com.yu.study.enums;

/**
 * 数据行状态,对应于row_status字段
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum RowStatusEnum {
	Add("add"),Delete("delete");
	
	private String aliasName;
	
	private RowStatusEnum(String aliasName){
		this.aliasName = aliasName;
	}
	
	public static RowStatusEnum valueOfStr(String val) {
		if(val == null) return null;
		
		for (RowStatusEnum rowStatusEnum : RowStatusEnum.values()) {
			if (rowStatusEnum.aliasName.equals(val)) {
				return rowStatusEnum;
			}
		}
		return null;
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
}
