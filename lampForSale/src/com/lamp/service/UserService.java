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
	 * 注册
	 * @param user  用户
	 */
	public void register(UserInfo user) {
		System.out.println("--service--");
		userDao.register(user);
	}
	
	
	/**
	 * 统计用户各级别的人数
	 * @return
	 */
	public Map<String, Integer> countPower() {
		return userDao.countPower();
	}
	
	
	/**
	 * 前台登录
	 */
	public boolean login(String userName, String password) {
		boolean flag = userDao.login(userName, password);
		return flag;
	}
	
	
	 /**
     * 后台登陆
     */
	public boolean ad_login(String userName, String password) {
		return userDao.ad_login(userName, password);
	}
	
	
	/**
	 * 用户列表
	 * @param pageInfo  分页
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
