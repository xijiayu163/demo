package com.yu.study.enums;

/**
 * 日志说明类型
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum LogDescriptionEnum {
	ManualAddRemark("manul_add_remark"),
	Pay("pay"),
	OperatePlatform("operate_platform"),
	OrderAttachInfo("order_attach_info");
	
	private String aliasName;
	public String getAliasName() {
		return aliasName;
	}
	
	public String getValue(){
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	private LogDescriptionEnum(String aliasName){
		this.aliasName = aliasName;
	}
	
	public static LogDescriptionEnum valueOfStr(String val) {
		if(val == null) return null;
		
		for (LogDescriptionEnum logDescriptionEnum : LogDescriptionEnum.values()) {
			if (logDescriptionEnum.aliasName.equals(val)) {
				return logDescriptionEnum;
			}
		}
		return null;
	}
}
