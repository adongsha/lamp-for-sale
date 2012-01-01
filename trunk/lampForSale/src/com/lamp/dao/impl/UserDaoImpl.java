package com.lamp.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lamp.dao.UserDao;
import com.lamp.model.UserInfo;
import com.lamp.util.PageInfo;

@Component("userDao")
public class UserDaoImpl extends HibernateDaoImpl implements UserDao {
    
	/**
	 * 前台登录
	 */
	public boolean login(String userName, String password) {
		String hql = "from UserInfo u where u.userName='"+userName+"' and u.power=0";
        List<UserInfo> list = this.find(hql);
        if(list.size()<1){
        	System.out.println("aaaaaaaa");
        	return false;
        }
        UserInfo user = list.get(0);
        if(user.getPassword().equals(password)){
        	return true;
        }
        return false;
     
	}
	
	
    /**
     * 后台登陆
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
	 * 注册
	 */
	public void register(UserInfo user) {
		this.save(user);
	}
   
	/**
	 * 修改
	 */
	public void updateUserInfo(Integer userId) {
		
	}

	/**
	 * 用户列表
	 */
	public List<UserInfo> getUserList(PageInfo pageInfo) {
		String hql = "from UserInfo";
		if(pageInfo == null){
		return this.find(hql);
		} else {
			return this.findPageByQuery(hql, null, pageInfo);
		}
	}

	/**
	 * 统计用户级别
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
