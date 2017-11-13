package com.yu.study.enums;

/**
 * 下单人类型
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum OrderAccountTypeEnum {
	Doctor("医生端",1),
	Patient("患者端",2),
	DoctorAndPatient("医患端",3);
	
	
	private String aliasName;
	private int num;
	
	
	public int getNum() {
		return num;
	}
	
	private OrderAccountTypeEnum(String aliasName,int value){
		this.aliasName = aliasName;
		this.num = value;
	}
	
	public static OrderAccountTypeEnum valueOf(int val) {
		for (OrderAccountTypeEnum orderAccountTypeEnum : OrderAccountTypeEnum.values()) {
			if (orderAccountTypeEnum.num == val) {
				return orderAccountTypeEnum;
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
}
