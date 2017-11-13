package com.yu.study.dao.impl;

import org.springframework.stereotype.Repository;
import com.yu.study.common.dao.BaseDaoImpl;
import com.yu.study.dao.OrderDao;
import com.yu.study.dao.po.OrderPo;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<OrderPo> implements OrderDao{

}