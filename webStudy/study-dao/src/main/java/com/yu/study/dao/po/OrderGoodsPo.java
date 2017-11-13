package com.yu.study.dao.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderGoodsPo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.order_good_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderGoodUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String rowStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Date rowVersion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.good_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String goodUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String orderUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.goods_count
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private Integer goodsCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.sale_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private BigDecimal saleAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_goods.specifications
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private String specifications;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.order_good_uid
     *
     * @return the value of order_goods.order_good_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderGoodUid() {
        return orderGoodUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.order_good_uid
     *
     * @param orderGoodUid the value for order_goods.order_good_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderGoodUid(String orderGoodUid) {
        this.orderGoodUid = orderGoodUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.row_status
     *
     * @return the value of order_goods.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getRowStatus() {
        return rowStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.row_status
     *
     * @param rowStatus the value for order_goods.row_status
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.row_version
     *
     * @return the value of order_goods.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Date getRowVersion() {
        return rowVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.row_version
     *
     * @param rowVersion the value for order_goods.row_version
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setRowVersion(Date rowVersion) {
        this.rowVersion = rowVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.good_uid
     *
     * @return the value of order_goods.good_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getGoodUid() {
        return goodUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.good_uid
     *
     * @param goodUid the value for order_goods.good_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setGoodUid(String goodUid) {
        this.goodUid = goodUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.order_uid
     *
     * @return the value of order_goods.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderUid() {
        return orderUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.order_uid
     *
     * @param orderUid the value for order_goods.order_uid
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.goods_count
     *
     * @return the value of order_goods.goods_count
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getGoodsCount() {
        return goodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.goods_count
     *
     * @param goodsCount the value for order_goods.goods_count
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.sale_amount
     *
     * @return the value of order_goods.sale_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.sale_amount
     *
     * @param saleAmount the value for order_goods.sale_amount
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_goods.specifications
     *
     * @return the value of order_goods.specifications
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getSpecifications() {
        return specifications;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_goods.specifications
     *
     * @param specifications the value for order_goods.specifications
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
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
        OrderGoodsPo other = (OrderGoodsPo) that;
        return (this.getOrderGoodUid() == null ? other.getOrderGoodUid() == null : this.getOrderGoodUid().equals(other.getOrderGoodUid()))
            && (this.getRowStatus() == null ? other.getRowStatus() == null : this.getRowStatus().equals(other.getRowStatus()))
            && (this.getRowVersion() == null ? other.getRowVersion() == null : this.getRowVersion().equals(other.getRowVersion()))
            && (this.getGoodUid() == null ? other.getGoodUid() == null : this.getGoodUid().equals(other.getGoodUid()))
            && (this.getOrderUid() == null ? other.getOrderUid() == null : this.getOrderUid().equals(other.getOrderUid()))
            && (this.getGoodsCount() == null ? other.getGoodsCount() == null : this.getGoodsCount().equals(other.getGoodsCount()))
            && (this.getSaleAmount() == null ? other.getSaleAmount() == null : this.getSaleAmount().equals(other.getSaleAmount()))
            && (this.getSpecifications() == null ? other.getSpecifications() == null : this.getSpecifications().equals(other.getSpecifications()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderGoodUid() == null) ? 0 : getOrderGoodUid().hashCode());
        result = prime * result + ((getRowStatus() == null) ? 0 : getRowStatus().hashCode());
        result = prime * result + ((getRowVersion() == null) ? 0 : getRowVersion().hashCode());
        result = prime * result + ((getGoodUid() == null) ? 0 : getGoodUid().hashCode());
        result = prime * result + ((getOrderUid() == null) ? 0 : getOrderUid().hashCode());
        result = prime * result + ((getGoodsCount() == null) ? 0 : getGoodsCount().hashCode());
        result = prime * result + ((getSaleAmount() == null) ? 0 : getSaleAmount().hashCode());
        result = prime * result + ((getSpecifications() == null) ? 0 : getSpecifications().hashCode());
        return result;
    }
}