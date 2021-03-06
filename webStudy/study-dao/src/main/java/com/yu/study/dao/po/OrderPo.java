package com.yu.study.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderPo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String rowStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date rowVersion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_type
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Byte orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal orderAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_pay_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal orderPayAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_discount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal orderDiscount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_discount_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal orderDiscountAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_freight
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal orderFreight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.extra_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String extraInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.payment_method
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String paymentMethod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.pay_time
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_account
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_account_phone
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderAccountPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.subscribe_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date subscribeDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.receiver
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String receiver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.receiver_phone
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String receiverPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.receiver_address
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String receiverAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.tracking_no
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String trackingNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.tracking_company
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String trackingCompany;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.out_trade_no
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String outTradeNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.cancel_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date cancelDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.delete_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date deleteDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.order_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Byte orderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.operate_platform
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String operatePlatform;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.account_type
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Byte accountType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column platform_order.ThirdServiceWeiXinOpenId
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String thirdserviceweixinopenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_uid
     *
     * @return the value of platform_order.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderUid() {
        return orderUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_uid
     *
     * @param orderUid the value for platform_order.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.row_status
     *
     * @return the value of platform_order.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getRowStatus() {
        return rowStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.row_status
     *
     * @param rowStatus the value for platform_order.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.row_version
     *
     * @return the value of platform_order.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getRowVersion() {
        return rowVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.row_version
     *
     * @param rowVersion the value for platform_order.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRowVersion(Date rowVersion) {
        this.rowVersion = rowVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_type
     *
     * @return the value of platform_order.order_type
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Byte getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_type
     *
     * @param orderType the value for platform_order.order_type
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_amount
     *
     * @return the value of platform_order.order_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_amount
     *
     * @param orderAmount the value for platform_order.order_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_pay_amount
     *
     * @return the value of platform_order.order_pay_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getOrderPayAmount() {
        return orderPayAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_pay_amount
     *
     * @param orderPayAmount the value for platform_order.order_pay_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderPayAmount(BigDecimal orderPayAmount) {
        this.orderPayAmount = orderPayAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_discount
     *
     * @return the value of platform_order.order_discount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getOrderDiscount() {
        return orderDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_discount
     *
     * @param orderDiscount the value for platform_order.order_discount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderDiscount(BigDecimal orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_discount_amount
     *
     * @return the value of platform_order.order_discount_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_discount_amount
     *
     * @param orderDiscountAmount the value for platform_order.order_discount_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderDiscountAmount(BigDecimal orderDiscountAmount) {
        this.orderDiscountAmount = orderDiscountAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_freight
     *
     * @return the value of platform_order.order_freight
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getOrderFreight() {
        return orderFreight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_freight
     *
     * @param orderFreight the value for platform_order.order_freight
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderFreight(BigDecimal orderFreight) {
        this.orderFreight = orderFreight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.extra_info
     *
     * @return the value of platform_order.extra_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.extra_info
     *
     * @param extraInfo the value for platform_order.extra_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.payment_method
     *
     * @return the value of platform_order.payment_method
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.payment_method
     *
     * @param paymentMethod the value for platform_order.payment_method
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.pay_time
     *
     * @return the value of platform_order.pay_time
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.pay_time
     *
     * @param payTime the value for platform_order.pay_time
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_account
     *
     * @return the value of platform_order.order_account
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderAccount() {
        return orderAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_account
     *
     * @param orderAccount the value for platform_order.order_account
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderAccount(String orderAccount) {
        this.orderAccount = orderAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_account_phone
     *
     * @return the value of platform_order.order_account_phone
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderAccountPhone() {
        return orderAccountPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_account_phone
     *
     * @param orderAccountPhone the value for platform_order.order_account_phone
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderAccountPhone(String orderAccountPhone) {
        this.orderAccountPhone = orderAccountPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.subscribe_date
     *
     * @return the value of platform_order.subscribe_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getSubscribeDate() {
        return subscribeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.subscribe_date
     *
     * @param subscribeDate the value for platform_order.subscribe_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.receiver
     *
     * @return the value of platform_order.receiver
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.receiver
     *
     * @param receiver the value for platform_order.receiver
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.receiver_phone
     *
     * @return the value of platform_order.receiver_phone
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.receiver_phone
     *
     * @param receiverPhone the value for platform_order.receiver_phone
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.receiver_address
     *
     * @return the value of platform_order.receiver_address
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.receiver_address
     *
     * @param receiverAddress the value for platform_order.receiver_address
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.tracking_no
     *
     * @return the value of platform_order.tracking_no
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getTrackingNo() {
        return trackingNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.tracking_no
     *
     * @param trackingNo the value for platform_order.tracking_no
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.tracking_company
     *
     * @return the value of platform_order.tracking_company
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getTrackingCompany() {
        return trackingCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.tracking_company
     *
     * @param trackingCompany the value for platform_order.tracking_company
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setTrackingCompany(String trackingCompany) {
        this.trackingCompany = trackingCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.out_trade_no
     *
     * @return the value of platform_order.out_trade_no
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.out_trade_no
     *
     * @param outTradeNo the value for platform_order.out_trade_no
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.cancel_date
     *
     * @return the value of platform_order.cancel_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getCancelDate() {
        return cancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.cancel_date
     *
     * @param cancelDate the value for platform_order.cancel_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.delete_date
     *
     * @return the value of platform_order.delete_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getDeleteDate() {
        return deleteDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.delete_date
     *
     * @param deleteDate the value for platform_order.delete_date
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.order_status
     *
     * @return the value of platform_order.order_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.order_status
     *
     * @param orderStatus the value for platform_order.order_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.operate_platform
     *
     * @return the value of platform_order.operate_platform
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOperatePlatform() {
        return operatePlatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.operate_platform
     *
     * @param operatePlatform the value for platform_order.operate_platform
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOperatePlatform(String operatePlatform) {
        this.operatePlatform = operatePlatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.account_type
     *
     * @return the value of platform_order.account_type
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Byte getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.account_type
     *
     * @param accountType the value for platform_order.account_type
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column platform_order.ThirdServiceWeiXinOpenId
     *
     * @return the value of platform_order.ThirdServiceWeiXinOpenId
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getThirdserviceweixinopenid() {
        return thirdserviceweixinopenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column platform_order.ThirdServiceWeiXinOpenId
     *
     * @param thirdserviceweixinopenid the value for platform_order.ThirdServiceWeiXinOpenId
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setThirdserviceweixinopenid(String thirdserviceweixinopenid) {
        this.thirdserviceweixinopenid = thirdserviceweixinopenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
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
        OrderPo other = (OrderPo) that;
        return (this.getOrderUid() == null ? other.getOrderUid() == null : this.getOrderUid().equals(other.getOrderUid()))
            && (this.getRowStatus() == null ? other.getRowStatus() == null : this.getRowStatus().equals(other.getRowStatus()))
            && (this.getRowVersion() == null ? other.getRowVersion() == null : this.getRowVersion().equals(other.getRowVersion()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getOrderPayAmount() == null ? other.getOrderPayAmount() == null : this.getOrderPayAmount().equals(other.getOrderPayAmount()))
            && (this.getOrderDiscount() == null ? other.getOrderDiscount() == null : this.getOrderDiscount().equals(other.getOrderDiscount()))
            && (this.getOrderDiscountAmount() == null ? other.getOrderDiscountAmount() == null : this.getOrderDiscountAmount().equals(other.getOrderDiscountAmount()))
            && (this.getOrderFreight() == null ? other.getOrderFreight() == null : this.getOrderFreight().equals(other.getOrderFreight()))
            && (this.getExtraInfo() == null ? other.getExtraInfo() == null : this.getExtraInfo().equals(other.getExtraInfo()))
            && (this.getPaymentMethod() == null ? other.getPaymentMethod() == null : this.getPaymentMethod().equals(other.getPaymentMethod()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getOrderAccount() == null ? other.getOrderAccount() == null : this.getOrderAccount().equals(other.getOrderAccount()))
            && (this.getOrderAccountPhone() == null ? other.getOrderAccountPhone() == null : this.getOrderAccountPhone().equals(other.getOrderAccountPhone()))
            && (this.getSubscribeDate() == null ? other.getSubscribeDate() == null : this.getSubscribeDate().equals(other.getSubscribeDate()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()))
            && (this.getReceiverPhone() == null ? other.getReceiverPhone() == null : this.getReceiverPhone().equals(other.getReceiverPhone()))
            && (this.getReceiverAddress() == null ? other.getReceiverAddress() == null : this.getReceiverAddress().equals(other.getReceiverAddress()))
            && (this.getTrackingNo() == null ? other.getTrackingNo() == null : this.getTrackingNo().equals(other.getTrackingNo()))
            && (this.getTrackingCompany() == null ? other.getTrackingCompany() == null : this.getTrackingCompany().equals(other.getTrackingCompany()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getCancelDate() == null ? other.getCancelDate() == null : this.getCancelDate().equals(other.getCancelDate()))
            && (this.getDeleteDate() == null ? other.getDeleteDate() == null : this.getDeleteDate().equals(other.getDeleteDate()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOperatePlatform() == null ? other.getOperatePlatform() == null : this.getOperatePlatform().equals(other.getOperatePlatform()))
            && (this.getAccountType() == null ? other.getAccountType() == null : this.getAccountType().equals(other.getAccountType()))
            && (this.getThirdserviceweixinopenid() == null ? other.getThirdserviceweixinopenid() == null : this.getThirdserviceweixinopenid().equals(other.getThirdserviceweixinopenid()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderUid() == null) ? 0 : getOrderUid().hashCode());
        result = prime * result + ((getRowStatus() == null) ? 0 : getRowStatus().hashCode());
        result = prime * result + ((getRowVersion() == null) ? 0 : getRowVersion().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getOrderPayAmount() == null) ? 0 : getOrderPayAmount().hashCode());
        result = prime * result + ((getOrderDiscount() == null) ? 0 : getOrderDiscount().hashCode());
        result = prime * result + ((getOrderDiscountAmount() == null) ? 0 : getOrderDiscountAmount().hashCode());
        result = prime * result + ((getOrderFreight() == null) ? 0 : getOrderFreight().hashCode());
        result = prime * result + ((getExtraInfo() == null) ? 0 : getExtraInfo().hashCode());
        result = prime * result + ((getPaymentMethod() == null) ? 0 : getPaymentMethod().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getOrderAccount() == null) ? 0 : getOrderAccount().hashCode());
        result = prime * result + ((getOrderAccountPhone() == null) ? 0 : getOrderAccountPhone().hashCode());
        result = prime * result + ((getSubscribeDate() == null) ? 0 : getSubscribeDate().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        result = prime * result + ((getReceiverPhone() == null) ? 0 : getReceiverPhone().hashCode());
        result = prime * result + ((getReceiverAddress() == null) ? 0 : getReceiverAddress().hashCode());
        result = prime * result + ((getTrackingNo() == null) ? 0 : getTrackingNo().hashCode());
        result = prime * result + ((getTrackingCompany() == null) ? 0 : getTrackingCompany().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getCancelDate() == null) ? 0 : getCancelDate().hashCode());
        result = prime * result + ((getDeleteDate() == null) ? 0 : getDeleteDate().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOperatePlatform() == null) ? 0 : getOperatePlatform().hashCode());
        result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
        result = prime * result + ((getThirdserviceweixinopenid() == null) ? 0 : getThirdserviceweixinopenid().hashCode());
        return result;
    }
}