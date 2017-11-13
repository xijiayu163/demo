package com.yu.study.enums;

/**
 * 订单状态
 *
 * @author yuxijia
 * @date 2017年3月17日
 * @since 4.2.0
 *
 */
public enum OrderStatusEnum {
	waitPay("待支付", 1), 
	Tranferring("运送中", 2), 
	Finished("已完成", 3), 
	Closed("已关闭", 4), 
	Handling("处理中",5), 
	RefundingFinished("退款完成", 6), 
	Cancel("已取消", 7);

	private String aliasName;
	private final int num;

	public int getNum() {
		return num;
	}

	public static OrderStatusEnum valueOf(int val) {
		for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
			if (orderStatusEnum.num == val) {
				return orderStatusEnum;
			}
		}

		return null;
	}

	private OrderStatusEnum(String aliasName, int value) {
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
