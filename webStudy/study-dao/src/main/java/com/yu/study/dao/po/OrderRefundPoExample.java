package com.yu.study.dao.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRefundPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public OrderRefundPoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderRefundUidIsNull() {
            addCriterion("order_refund_uid is null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidIsNotNull() {
            addCriterion("order_refund_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidEqualTo(String value) {
            addCriterion("order_refund_uid =", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidNotEqualTo(String value) {
            addCriterion("order_refund_uid <>", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidGreaterThan(String value) {
            addCriterion("order_refund_uid >", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidGreaterThanOrEqualTo(String value) {
            addCriterion("order_refund_uid >=", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidLessThan(String value) {
            addCriterion("order_refund_uid <", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidLessThanOrEqualTo(String value) {
            addCriterion("order_refund_uid <=", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidLike(String value) {
            addCriterion("order_refund_uid like", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidNotLike(String value) {
            addCriterion("order_refund_uid not like", value, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidIn(List<String> values) {
            addCriterion("order_refund_uid in", values, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidNotIn(List<String> values) {
            addCriterion("order_refund_uid not in", values, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidBetween(String value1, String value2) {
            addCriterion("order_refund_uid between", value1, value2, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidNotBetween(String value1, String value2) {
            addCriterion("order_refund_uid not between", value1, value2, "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidIsNull() {
            addCriterion("order_uid is null");
            return (Criteria) this;
        }

        public Criteria andOrderUidIsNotNull() {
            addCriterion("order_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUidEqualTo(String value) {
            addCriterion("order_uid =", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotEqualTo(String value) {
            addCriterion("order_uid <>", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidGreaterThan(String value) {
            addCriterion("order_uid >", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidGreaterThanOrEqualTo(String value) {
            addCriterion("order_uid >=", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLessThan(String value) {
            addCriterion("order_uid <", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLessThanOrEqualTo(String value) {
            addCriterion("order_uid <=", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLike(String value) {
            addCriterion("order_uid like", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotLike(String value) {
            addCriterion("order_uid not like", value, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidIn(List<String> values) {
            addCriterion("order_uid in", values, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotIn(List<String> values) {
            addCriterion("order_uid not in", values, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidBetween(String value1, String value2) {
            addCriterion("order_uid between", value1, value2, "orderUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidNotBetween(String value1, String value2) {
            addCriterion("order_uid not between", value1, value2, "orderUid");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceIsNull() {
            addCriterion("refund_sequence is null");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceIsNotNull() {
            addCriterion("refund_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceEqualTo(String value) {
            addCriterion("refund_sequence =", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceNotEqualTo(String value) {
            addCriterion("refund_sequence <>", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceGreaterThan(String value) {
            addCriterion("refund_sequence >", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceGreaterThanOrEqualTo(String value) {
            addCriterion("refund_sequence >=", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceLessThan(String value) {
            addCriterion("refund_sequence <", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceLessThanOrEqualTo(String value) {
            addCriterion("refund_sequence <=", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceLike(String value) {
            addCriterion("refund_sequence like", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceNotLike(String value) {
            addCriterion("refund_sequence not like", value, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceIn(List<String> values) {
            addCriterion("refund_sequence in", values, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceNotIn(List<String> values) {
            addCriterion("refund_sequence not in", values, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceBetween(String value1, String value2) {
            addCriterion("refund_sequence between", value1, value2, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceNotBetween(String value1, String value2) {
            addCriterion("refund_sequence not between", value1, value2, "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(BigDecimal value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(BigDecimal value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<BigDecimal> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Byte value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Byte value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Byte value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Byte value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Byte value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Byte> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Byte> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Byte value1, Byte value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNull() {
            addCriterion("confirm_date is null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNotNull() {
            addCriterion("confirm_date is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateEqualTo(Date value) {
            addCriterion("confirm_date =", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotEqualTo(Date value) {
            addCriterion("confirm_date <>", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThan(Date value) {
            addCriterion("confirm_date >", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_date >=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThan(Date value) {
            addCriterion("confirm_date <", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThanOrEqualTo(Date value) {
            addCriterion("confirm_date <=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIn(List<Date> values) {
            addCriterion("confirm_date in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotIn(List<Date> values) {
            addCriterion("confirm_date not in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateBetween(Date value1, Date value2) {
            addCriterion("confirm_date between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotBetween(Date value1, Date value2) {
            addCriterion("confirm_date not between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateIsNull() {
            addCriterion("refund_date is null");
            return (Criteria) this;
        }

        public Criteria andRefundDateIsNotNull() {
            addCriterion("refund_date is not null");
            return (Criteria) this;
        }

        public Criteria andRefundDateEqualTo(Date value) {
            addCriterion("refund_date =", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotEqualTo(Date value) {
            addCriterion("refund_date <>", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateGreaterThan(Date value) {
            addCriterion("refund_date >", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_date >=", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateLessThan(Date value) {
            addCriterion("refund_date <", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateLessThanOrEqualTo(Date value) {
            addCriterion("refund_date <=", value, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateIn(List<Date> values) {
            addCriterion("refund_date in", values, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotIn(List<Date> values) {
            addCriterion("refund_date not in", values, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateBetween(Date value1, Date value2) {
            addCriterion("refund_date between", value1, value2, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundDateNotBetween(Date value1, Date value2) {
            addCriterion("refund_date not between", value1, value2, "refundDate");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIsNull() {
            addCriterion("refund_remark is null");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIsNotNull() {
            addCriterion("refund_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkEqualTo(String value) {
            addCriterion("refund_remark =", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotEqualTo(String value) {
            addCriterion("refund_remark <>", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkGreaterThan(String value) {
            addCriterion("refund_remark >", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("refund_remark >=", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLessThan(String value) {
            addCriterion("refund_remark <", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLessThanOrEqualTo(String value) {
            addCriterion("refund_remark <=", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLike(String value) {
            addCriterion("refund_remark like", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotLike(String value) {
            addCriterion("refund_remark not like", value, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkIn(List<String> values) {
            addCriterion("refund_remark in", values, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotIn(List<String> values) {
            addCriterion("refund_remark not in", values, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkBetween(String value1, String value2) {
            addCriterion("refund_remark between", value1, value2, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkNotBetween(String value1, String value2) {
            addCriterion("refund_remark not between", value1, value2, "refundRemark");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNull() {
            addCriterion("operate_date is null");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNotNull() {
            addCriterion("operate_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDateEqualTo(Date value) {
            addCriterion("operate_date =", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotEqualTo(Date value) {
            addCriterion("operate_date <>", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThan(Date value) {
            addCriterion("operate_date >", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_date >=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThan(Date value) {
            addCriterion("operate_date <", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThanOrEqualTo(Date value) {
            addCriterion("operate_date <=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateIn(List<Date> values) {
            addCriterion("operate_date in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotIn(List<Date> values) {
            addCriterion("operate_date not in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateBetween(Date value1, Date value2) {
            addCriterion("operate_date between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotBetween(Date value1, Date value2) {
            addCriterion("operate_date not between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("`operator` is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("`operator` is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("`operator` =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("`operator` <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("`operator` >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("`operator` >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("`operator` <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("`operator` <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("`operator` like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("`operator` not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("`operator` in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("`operator` not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("`operator` between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("`operator` not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNull() {
            addCriterion("row_status is null");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNotNull() {
            addCriterion("row_status is not null");
            return (Criteria) this;
        }

        public Criteria andRowStatusEqualTo(String value) {
            addCriterion("row_status =", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotEqualTo(String value) {
            addCriterion("row_status <>", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThan(String value) {
            addCriterion("row_status >", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("row_status >=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThan(String value) {
            addCriterion("row_status <", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThanOrEqualTo(String value) {
            addCriterion("row_status <=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLike(String value) {
            addCriterion("row_status like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotLike(String value) {
            addCriterion("row_status not like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusIn(List<String> values) {
            addCriterion("row_status in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotIn(List<String> values) {
            addCriterion("row_status not in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusBetween(String value1, String value2) {
            addCriterion("row_status between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotBetween(String value1, String value2) {
            addCriterion("row_status not between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowVersionIsNull() {
            addCriterion("row_version is null");
            return (Criteria) this;
        }

        public Criteria andRowVersionIsNotNull() {
            addCriterion("row_version is not null");
            return (Criteria) this;
        }

        public Criteria andRowVersionEqualTo(Date value) {
            addCriterion("row_version =", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionNotEqualTo(Date value) {
            addCriterion("row_version <>", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionGreaterThan(Date value) {
            addCriterion("row_version >", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionGreaterThanOrEqualTo(Date value) {
            addCriterion("row_version >=", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionLessThan(Date value) {
            addCriterion("row_version <", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionLessThanOrEqualTo(Date value) {
            addCriterion("row_version <=", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionIn(List<Date> values) {
            addCriterion("row_version in", values, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionNotIn(List<Date> values) {
            addCriterion("row_version not in", values, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionBetween(Date value1, Date value2) {
            addCriterion("row_version between", value1, value2, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionNotBetween(Date value1, Date value2) {
            addCriterion("row_version not between", value1, value2, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andOrderRefundUidLikeInsensitive(String value) {
            addCriterion("upper(order_refund_uid) like", value.toUpperCase(), "orderRefundUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLikeInsensitive(String value) {
            addCriterion("upper(order_uid) like", value.toUpperCase(), "orderUid");
            return (Criteria) this;
        }

        public Criteria andRefundSequenceLikeInsensitive(String value) {
            addCriterion("upper(refund_sequence) like", value.toUpperCase(), "refundSequence");
            return (Criteria) this;
        }

        public Criteria andRefundRemarkLikeInsensitive(String value) {
            addCriterion("upper(refund_remark) like", value.toUpperCase(), "refundRemark");
            return (Criteria) this;
        }

        public Criteria andOperatorLikeInsensitive(String value) {
            addCriterion("upper(`operator`) like", value.toUpperCase(), "operator");
            return (Criteria) this;
        }

        public Criteria andRowStatusLikeInsensitive(String value) {
            addCriterion("upper(row_status) like", value.toUpperCase(), "rowStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order_refund
     *
     * @mbggenerated do_not_delete_during_merge Wed Nov 08 20:53:33 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order_refund
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}