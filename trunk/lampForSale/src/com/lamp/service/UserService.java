package com.lamp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.UserDao;
import com.lamp.model.UserInfo;
import com.lamp.util.Model2VoUtil;
import com.lamp.util.PageInfo;
import com.lamp.vo.UserInfoVo;
import com.opensymphony.xwork2.ActionContext;

@Component("userService")
public class UserService {
	private UserDao userDao;
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	/**
	 * ע��
	 * @param user  �û�
	 */
	public void register(UserInfo user) {
		System.out.println("--service--");
		userDao.register(user);
	}
	
	
	/**
	 * ͳ���û������������
	 * @return
	 */
	public Map<String, Integer> countPower() {
		return userDao.countPower();
	}
	
	
	/**
	 * ǰ̨��¼
	 */
	public boolean login(String userName, String password) {
		boolean flag = userDao.login(userName, password);
		return flag;
	}
	
	
	 /**
     * ��̨��½
     */
	public boolean ad_login(String userName, String password) {
		return userDao.ad_login(userName, password);
	}
	
	
	/**
	 * �û��б�
	 * @param pageInfo  ��ҳ
	 * @return
	 */
	public List<UserInfoVo> getUserList(PageInfo pageInfo) {
		List<UserInfoVo> userInfoVos = new ArrayList<UserInfoVo>();
		List<UserInfo> userInfos = userDao.getUserList(pageInfo);
		for(UserInfo userInfo : userInfos){
			UserInfoVo userInfoVo = Model2VoUtil.userInfo2userInfoVo(userInfo);
			userInfoVos.add(userInfoVo);
		}
		return userInfoVos;
	}
	
	
	public void deleteUser(UserInfo user){
		userDao.deleteUser(user);
	}
	
	
	public UserInfo userInfo(Long userId){
		return userDao.userInfo(userId);
	}

}
