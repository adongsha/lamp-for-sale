package com.lamp.dao.impl;


import java.util.List;

import com.lamp.dao.UserDao;
import com.lamp.model.UserInfo;

public class UserDaoImpl extends HibernateDaoImpl implements UserDao {

	public boolean login(String userName, String password) {
		String hql = "from UserInfo u where u.userName="+userName+"'";
        UserInfo user = (UserInfo)this.find(hql).get(0);
        if(user.getPassword().equals(password)){
        	return true;
        }
        return false;
	}

	public void register(UserInfo user) {
		this.save(user);
	}

	public void updateUserInfo(Integer userId) {
		
	}

	public List<UserInfo> getUserList() {
		String hql = "from UserInfo";
        return this.find(hql);
	}
	
	

}
