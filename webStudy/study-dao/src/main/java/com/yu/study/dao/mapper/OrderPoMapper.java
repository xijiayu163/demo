package com.yu.study.dao.mapper;

import com.yu.study.dao.po.OrderPo;
import com.yu.study.dao.po.OrderPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int countByExample(OrderPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int deleteByExample(OrderPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int deleteByPrimaryKey(String orderUid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int insert(OrderPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int insertSelective(OrderPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    List<OrderPo> selectByExample(OrderPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    OrderPo selectByPrimaryKey(String orderUid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int updateByExampleSelective(@Param("record") OrderPo record, @Param("example") OrderPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int updateByExample(@Param("record") OrderPo record, @Param("example") OrderPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int updateByPrimaryKeySelective(OrderPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table platform_order
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    int updateByPrimaryKey(OrderPo record);
}