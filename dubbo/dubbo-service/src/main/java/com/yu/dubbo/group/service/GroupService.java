package com.yu.dubbo.group.service;

import com.yu.dubbo.entity.User;

/** 该接口有多个实现， dubbo服务暴露配置分组
 *
 * @author yuxijia
 *
 */
public interface GroupService {
	public User getUser(String accountUid);
}
