package com.lamp.dao;

import java.util.List;
import java.util.Map;

import com.lamp.model.UserInfo;

/**
 * 用户DAO模块
 * @author 梁绮红
 * @createTime:
 */
public interface UserDao {
	/**
	 * 注册
	 * @param user   用户对象
	 */
    public void register(UserInfo user);
    
    /**
     * 登录
     * @param userName   用户名
     * @param password   密码
     * @return           
     */
    public boolean login(String userName, String password);
    
    /**
     * 修改用户信息
     * @param user   用户对象
     */
    public void updateUserInfo(Integer userId);
    
    /**
     * 得到所用用户列表
     * @return
     */
    public List<UserInfo> getUserList();
    
    /**
     * 统计用户权限人数
     * @return
     */
    public Map<String, Integer> countPower();
    

}
