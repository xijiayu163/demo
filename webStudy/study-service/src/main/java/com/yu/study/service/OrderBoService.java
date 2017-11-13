package com.yu.study.service;

import com.yu.study.bo.OrderBo;
import com.yu.study.common.service.BaseService;

/** 该service 层可处理业务，或配置开关以达到动态加载的目的
 * @author xijia
 *
 */
public interface OrderBoService extends BaseService<OrderBo>{
	
	public class LoadStrategy implements com.yu.study.common.service.LoadStrategy{
		private boolean loadOrderGoodsFlag = true;
		private boolean loadOrderAttachInfoFlag = true;
		private boolean loadOrderLogFlag = true;
		private boolean loadOrderPolicyFlag = true;
		private boolean loadOrderRefundFlag = true;
		
		public boolean isLoadOrderGoodsFlag() {
			return loadOrderGoodsFlag;
		}
		public void setLoadOrderGoodsFlag(boolean loadOrderGoodsFlag) {
			this.loadOrderGoodsFlag = loadOrderGoodsFlag;
		}
		public boolean isLoadOrderAttachInfoFlag() {
			return loadOrderAttachInfoFlag;
		}
		public void setLoadOrderAttachInfoFlag(boolean loadOrderAttachInfoFlag) {
			this.loadOrderAttachInfoFlag = loadOrderAttachInfoFlag;
		}
		public boolean isLoadOrderLogFlag() {
			return loadOrderLogFlag;
		}
		public void setLoadOrderLogFlag(boolean loadOrderLogFlag) {
			this.loadOrderLogFlag = loadOrderLogFlag;
		}
		public boolean isLoadOrderPolicyFlag() {
			return loadOrderPolicyFlag;
		}
		public void setLoadOrderPolicyFlag(boolean loadOrderPolicyFlag) {
			this.loadOrderPolicyFlag = loadOrderPolicyFlag;
		}
		public boolean isLoadOrderRefundFlag() {
			return loadOrderRefundFlag;
		}
		public void setLoadOrderRefundFlag(boolean loadOrderRefundFlag) {
			this.loadOrderRefundFlag = loadOrderRefundFlag;
		}
	}
}
