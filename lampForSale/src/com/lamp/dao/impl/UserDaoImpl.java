package com.lamp.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lamp.dao.UserDao;
import com.lamp.model.UserInfo;
@Component("userDao")
public class UserDaoImpl extends HibernateDaoImpl implements UserDao {
    
	/**
	 * ǰ̨��¼
	 */
	public boolean login(String userName, String password) {
		String hql = "from UserInfo u where u.userName="+userName+"' and u.power=0";
        UserInfo user = (UserInfo)this.find(hql).get(0);
        if(user.getPassword().equals(password)){
        	return true;
        }
        return false;
	}
	
	
    /**
     * ��̨��½
     */
	public boolean ad_login(String userName, String password) {
		String hql = "from UserInfo u where u.userName="+userName+"' and u.power=1";
        UserInfo user = (UserInfo)this.find(hql).get(0);
        if(user.getPassword().equals(password)){
        	return true;
        }
        return false;
	}



	/**
	 * ע��
	 */
	public void register(UserInfo user) {
		this.save(user);
	}
   
	/**
	 * �޸�
	 */
	public void updateUserInfo(Integer userId) {
		
	}

	/**
	 * �û��б�
	 */
	public List<UserInfo> getUserList() {
		String hql = "from UserInfo";
        return this.find(hql);
	}

	/**
	 * ͳ���û�����
	 */
	public Map<String, Integer> countPower() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String hql1 = "from UserInfo u where u.power = 1";
		map.put("admin", this.find(hql1).size());
		String hql2 = "from UserInfo u where u.power = 2";
		map.put("vip", this.find(hql2).size());
		String hql3 = "from UserInfo u where u.power = 0";
		map.put("ordinary", this.find(hql3).size());
		return map;
	}
	
	

}
