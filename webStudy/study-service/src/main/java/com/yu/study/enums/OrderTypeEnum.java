package com.yu.study.enums;

/**
 * 订单类型，分为免费和非免费
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum OrderTypeEnum {
	Free(0),
	NoFree(1);
	
	private int num;
	
	public int getNum() {
		return num;
	}
	
	private OrderTypeEnum(int value){
		this.num = value;
	}
	
	public static OrderTypeEnum valueOf(int val) {
		for (OrderTypeEnum orderTypeEnum : OrderTypeEnum.values()) {
			if (orderTypeEnum.num == val) {
				return orderTypeEnum;
			}
		}
		
		return null;
	}
}
