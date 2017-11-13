package com.yu.study.bo;

import java.util.ArrayList;
import java.util.List;

import com.yu.study.dos.OrderAttachInfoDo;
import com.yu.study.dos.OrderDo;
import com.yu.study.dos.OrderGoodsDo;
import com.yu.study.dos.OrderLogDo;
import com.yu.study.dos.OrderPolicyDo;
import com.yu.study.dos.OrderRefundDo;

public class OrderBo {
	private OrderDo orderDo;
	private List<OrderGoodsDo> orderGoodsDoList = new ArrayList<>();
	private OrderAttachInfoDo orderAttachInfoDo;
	private List<OrderLogDo> orderLogDoList = new ArrayList<>();
	private OrderPolicyDo orderPolicyDo;
	private List<OrderRefundDo> orderRefundDoList = new ArrayList<>();
	
	public OrderDo getOrderDo() {
		return orderDo;
	}
	public void setOrderDo(OrderDo orderDo) {
		this.orderDo = orderDo;
	}
	public List<OrderGoodsDo> getOrderGoodsDoList() {
		return orderGoodsDoList;
	}
	public void setOrderGoodsDoList(List<OrderGoodsDo> orderGoodsDoList) {
		this.orderGoodsDoList = orderGoodsDoList;
	}
	public List<OrderLogDo> getOrderLogDoList() {
		return orderLogDoList;
	}
	public void setOrderLogDoList(List<OrderLogDo> orderLogDoList) {
		this.orderLogDoList = orderLogDoList;
	}
	public OrderPolicyDo getOrderPolicyDo() {
		return orderPolicyDo;
	}
	public void setOrderPolicyDo(OrderPolicyDo orderPolicyDo) {
		this.orderPolicyDo = orderPolicyDo;
	}
	public List<OrderRefundDo> getOrderRefundDoList() {
		return orderRefundDoList;
	}
	public void setOrderRefundDoList(List<OrderRefundDo> orderRefundDoList) {
		this.orderRefundDoList = orderRefundDoList;
	}
	public OrderAttachInfoDo getOrderAttachInfoDo() {
		return orderAttachInfoDo;
	}
	public void setOrderAttachInfoDo(OrderAttachInfoDo orderAttachInfoDo) {
		this.orderAttachInfoDo = orderAttachInfoDo;
	}
	
}
