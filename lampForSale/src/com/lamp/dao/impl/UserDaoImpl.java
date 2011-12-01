package com.lamp.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, Integer> countPower() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String hql1 = "from UserInfo u where u.power = '管理员'";
		map.put("admin", this.find(hql1).size());
		String hql2 = "from UserInfo u where u.power = 'VIP会员'";
		map.put("vip", this.find(hql2).size());
		String hql3 = "from UserInfo u where u.power = '普通会员'";
		map.put("ordinary", this.find(hql3).size());
		return map;
	}
	
	

}
