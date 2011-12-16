package com.lamp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.UserDao;
import com.lamp.model.UserInfo;

@Component("userService")
public class UserService {
	private UserDao userDao;
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	/**
	 * зЂВс
	 */
	public void register(UserInfo user) {
		userDao.register(user);
	}
}
