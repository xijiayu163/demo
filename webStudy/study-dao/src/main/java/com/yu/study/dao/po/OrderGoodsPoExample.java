package com.yu.study.dao.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderGoodsPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public OrderGoodsPoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
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
     * This method corresponds to the database table order_goods
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
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
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
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_goods
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order_goods
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

        public Criteria andOrderGoodUidIsNull() {
            addCriterion("order_good_uid is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidIsNotNull() {
            addCriterion("order_good_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidEqualTo(String value) {
            addCriterion("order_good_uid =", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidNotEqualTo(String value) {
            addCriterion("order_good_uid <>", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidGreaterThan(String value) {
            addCriterion("order_good_uid >", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidGreaterThanOrEqualTo(String value) {
            addCriterion("order_good_uid >=", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidLessThan(String value) {
            addCriterion("order_good_uid <", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidLessThanOrEqualTo(String value) {
            addCriterion("order_good_uid <=", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidLike(String value) {
            addCriterion("order_good_uid like", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidNotLike(String value) {
            addCriterion("order_good_uid not like", value, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidIn(List<String> values) {
            addCriterion("order_good_uid in", values, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidNotIn(List<String> values) {
            addCriterion("order_good_uid not in", values, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidBetween(String value1, String value2) {
            addCriterion("order_good_uid between", value1, value2, "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidNotBetween(String value1, String value2) {
            addCriterion("order_good_uid not between", value1, value2, "orderGoodUid");
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

        public Criteria andGoodUidIsNull() {
            addCriterion("good_uid is null");
            return (Criteria) this;
        }

        public Criteria andGoodUidIsNotNull() {
            addCriterion("good_uid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodUidEqualTo(String value) {
            addCriterion("good_uid =", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidNotEqualTo(String value) {
            addCriterion("good_uid <>", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidGreaterThan(String value) {
            addCriterion("good_uid >", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidGreaterThanOrEqualTo(String value) {
            addCriterion("good_uid >=", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidLessThan(String value) {
            addCriterion("good_uid <", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidLessThanOrEqualTo(String value) {
            addCriterion("good_uid <=", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidLike(String value) {
            addCriterion("good_uid like", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidNotLike(String value) {
            addCriterion("good_uid not like", value, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidIn(List<String> values) {
            addCriterion("good_uid in", values, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidNotIn(List<String> values) {
            addCriterion("good_uid not in", values, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidBetween(String value1, String value2) {
            addCriterion("good_uid between", value1, value2, "goodUid");
            return (Criteria) this;
        }

        public Criteria andGoodUidNotBetween(String value1, String value2) {
            addCriterion("good_uid not between", value1, value2, "goodUid");
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

        public Criteria andGoodsCountIsNull() {
            addCriterion("goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNull() {
            addCriterion("sale_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIsNotNull() {
            addCriterion("sale_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAmountEqualTo(BigDecimal value) {
            addCriterion("sale_amount =", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotEqualTo(BigDecimal value) {
            addCriterion("sale_amount <>", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThan(BigDecimal value) {
            addCriterion("sale_amount >", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_amount >=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThan(BigDecimal value) {
            addCriterion("sale_amount <", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_amount <=", value, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountIn(List<BigDecimal> values) {
            addCriterion("sale_amount in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotIn(List<BigDecimal> values) {
            addCriterion("sale_amount not in", values, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_amount between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSaleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_amount not between", value1, value2, "saleAmount");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(String value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(String value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(String value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(String value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(String value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLike(String value) {
            addCriterion("specifications like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotLike(String value) {
            addCriterion("specifications not like", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<String> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<String> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(String value1, String value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(String value1, String value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andOrderGoodUidLikeInsensitive(String value) {
            addCriterion("upper(order_good_uid) like", value.toUpperCase(), "orderGoodUid");
            return (Criteria) this;
        }

        public Criteria andRowStatusLikeInsensitive(String value) {
            addCriterion("upper(row_status) like", value.toUpperCase(), "rowStatus");
            return (Criteria) this;
        }

        public Criteria andGoodUidLikeInsensitive(String value) {
            addCriterion("upper(good_uid) like", value.toUpperCase(), "goodUid");
            return (Criteria) this;
        }

        public Criteria andOrderUidLikeInsensitive(String value) {
            addCriterion("upper(order_uid) like", value.toUpperCase(), "orderUid");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLikeInsensitive(String value) {
            addCriterion("upper(specifications) like", value.toUpperCase(), "specifications");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table order_goods
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
     * This class corresponds to the database table order_goods
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