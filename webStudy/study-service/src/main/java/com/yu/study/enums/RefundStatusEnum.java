package com.yu.study.enums;

/**
 * 订单退款状态
 *
 * @author yuxijia
 * @date 2017年3月17日 
 * @since 4.2.0
 *
 */
public enum RefundStatusEnum {
	WaitReview("待审核",1),
	Reviewed("已审核",3),
	ReviewNotAllowd("审核不通过",2),
	Refunding("退款中",4),
	RefundFinished("退款完成",5),
	RefundFailed("退款失败",6);
	
	private String aliasName;
	private int num;
	
	public int getNum() {
		return num;
	}
	
	public static RefundStatusEnum valueOf(int val) {
		for (RefundStatusEnum refundStatusEnum : RefundStatusEnum.values()) {
			if (refundStatusEnum.num == val) {
				return refundStatusEnum;
			}
		}
		
		return null;
	}
	
	private RefundStatusEnum(String aliasName,int value){
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
