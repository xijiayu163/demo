package com.yu.study.dao.impl;

import org.springframework.stereotype.Repository;
import com.yu.study.common.dao.BaseDaoImpl;
import com.yu.study.dao.UserDao;
import com.yu.study.dao.po.UserPo;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserPo> implements UserDao{

}