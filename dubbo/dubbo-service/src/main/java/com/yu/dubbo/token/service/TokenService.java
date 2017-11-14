package com.yu.dubbo.token.service;

import com.yu.dubbo.entity.User;

public interface TokenService {
	public User getUser(String accountUid);
}
