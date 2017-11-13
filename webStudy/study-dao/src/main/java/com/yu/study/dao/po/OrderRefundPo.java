package com.yu.study.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderRefundPo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.order_refund_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderRefundUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.refund_sequence
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String refundSequence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.refund_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal refundAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.refund_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Byte refundStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.confirm_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date confirmDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.refund_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date refundDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.refund_remark
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String refundRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.operate_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date operateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.operator
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String operator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String rowStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_refund.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date rowVersion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.order_refund_uid
     *
     * @return the value of order_refund.order_refund_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderRefundUid() {
        return orderRefundUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.order_refund_uid
     *
     * @param orderRefundUid the value for order_refund.order_refund_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderRefundUid(String orderRefundUid) {
        this.orderRefundUid = orderRefundUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.order_uid
     *
     * @return the value of order_refund.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderUid() {
        return orderUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.order_uid
     *
     * @param orderUid the value for order_refund.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.refund_sequence
     *
     * @return the value of order_refund.refund_sequence
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getRefundSequence() {
        return refundSequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.refund_sequence
     *
     * @param refundSequence the value for order_refund.refund_sequence
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRefundSequence(String refundSequence) {
        this.refundSequence = refundSequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.refund_amount
     *
     * @return the value of order_refund.refund_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.refund_amount
     *
     * @param refundAmount the value for order_refund.refund_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.refund_status
     *
     * @return the value of order_refund.refund_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Byte getRefundStatus() {
        return refundStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.refund_status
     *
     * @param refundStatus the value for order_refund.refund_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRefundStatus(Byte refundStatus) {
        this.refundStatus = refundStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.confirm_date
     *
     * @return the value of order_refund.confirm_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.confirm_date
     *
     * @param confirmDate the value for order_refund.confirm_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.refund_date
     *
     * @return the value of order_refund.refund_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getRefundDate() {
        return refundDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.refund_date
     *
     * @param refundDate the value for order_refund.refund_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.refund_remark
     *
     * @return the value of order_refund.refund_remark
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getRefundRemark() {
        return refundRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.refund_remark
     *
     * @param refundRemark the value for order_refund.refund_remark
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.operate_date
     *
     * @return the value of order_refund.operate_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getOperateDate() {
        return operateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.operate_date
     *
     * @param operateDate the value for order_refund.operate_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.operator
     *
     * @return the value of order_refund.operator
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.operator
     *
     * @param operator the value for order_refund.operator
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.row_status
     *
     * @return the value of order_refund.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getRowStatus() {
        return rowStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.row_status
     *
     * @param rowStatus the value for order_refund.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_refund.row_version
     *
     * @return the value of order_refund.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getRowVersion() {
        return rowVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_refund.row_version
     *
     * @param rowVersion the value for order_refund.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRowVersion(Date rowVersion) {
        this.rowVersion = rowVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderRefundPo other = (OrderRefundPo) that;
        return (this.getOrderRefundUid() == null ? other.getOrderRefundUid() == null : this.getOrderRefundUid().equals(other.getOrderRefundUid()))
            && (this.getOrderUid() == null ? other.getOrderUid() == null : this.getOrderUid().equals(other.getOrderUid()))
            && (this.getRefundSequence() == null ? other.getRefundSequence() == null : this.getRefundSequence().equals(other.getRefundSequence()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getRefundStatus() == null ? other.getRefundStatus() == null : this.getRefundStatus().equals(other.getRefundStatus()))
            && (this.getConfirmDate() == null ? other.getConfirmDate() == null : this.getConfirmDate().equals(other.getConfirmDate()))
            && (this.getRefundDate() == null ? other.getRefundDate() == null : this.getRefundDate().equals(other.getRefundDate()))
            && (this.getRefundRemark() == null ? other.getRefundRemark() == null : this.getRefundRemark().equals(other.getRefundRemark()))
            && (this.getOperateDate() == null ? other.getOperateDate() == null : this.getOperateDate().equals(other.getOperateDate()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getRowStatus() == null ? other.getRowStatus() == null : this.getRowStatus().equals(other.getRowStatus()))
            && (this.getRowVersion() == null ? other.getRowVersion() == null : this.getRowVersion().equals(other.getRowVersion()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderRefundUid() == null) ? 0 : getOrderRefundUid().hashCode());
        result = prime * result + ((getOrderUid() == null) ? 0 : getOrderUid().hashCode());
        result = prime * result + ((getRefundSequence() == null) ? 0 : getRefundSequence().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getRefundStatus() == null) ? 0 : getRefundStatus().hashCode());
        result = prime * result + ((getConfirmDate() == null) ? 0 : getConfirmDate().hashCode());
        result = prime * result + ((getRefundDate() == null) ? 0 : getRefundDate().hashCode());
        result = prime * result + ((getRefundRemark() == null) ? 0 : getRefundRemark().hashCode());
        result = prime * result + ((getOperateDate() == null) ? 0 : getOperateDate().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getRowStatus() == null) ? 0 : getRowStatus().hashCode());
        result = prime * result + ((getRowVersion() == null) ? 0 : getRowVersion().hashCode());
        return result;
    }
}