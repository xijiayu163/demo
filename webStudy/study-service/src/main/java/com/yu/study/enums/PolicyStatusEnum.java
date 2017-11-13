package com.yu.study.enums;

/**
 * 保单使用状态，分为启用和未启用
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum PolicyStatusEnum {
	Used("已启用",1),
	Unused("未启用",0);
	
	
	private String aliasName;
	private int num;
	
	public int getNum() {
		return num;
	}

	
	public static PolicyStatusEnum valueOf(int val) {
		for (PolicyStatusEnum policyStatusEnum : PolicyStatusEnum.values()) {
			if (policyStatusEnum.num == val) {
				return policyStatusEnum;
			}
		}
		return null;
	}
	
	private PolicyStatusEnum(String aliasName,int value){
		this.aliasName = aliasName;
		this.num = value;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
}
