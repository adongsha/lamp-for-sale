package com.lamp.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.model.UserInfo;
import com.lamp.service.UserService;
import com.lamp.util.PageInfo;
import com.lamp.vo.UserInfoVo;
import com.opensymphony.xwork2.ActionContext;

@Component("UserAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name="userAction")
public class UserAction extends SuperAction {
   private UserService userService;

   @Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
   
	/**
	 * 用户注册
	 * @param userName  用户名
	 * @param password  密码
	 * @param email     邮件
	 * @param telephone 电话
	 * @param address   地址
	 */
	@RemoteMethod
	public void register(String userName, String password, 
			String email, String telephone, String address) {
		UserInfo user = new UserInfo();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(telephone);
		user.setAddress(address);
		userService.register(user);
	}
	
	/**
	 * 登录
	 * @param userName  用户名
	 * @param password  密码
	 * @return
	 */
	@RemoteMethod
	public boolean login(String userName, String password){
		boolean flag = userService.login(userName, password);
		if(flag == true){
		ActionContext.getContext().getSession().put("userName", userName);
		}
		return flag;
	}
	
	/**
	 * 统计用户级别的人数
	 * @return
	 */
	@RemoteMethod
	public Map<String, Integer> countPower() {
		return userService.countPower();
	}
	
	/**
	 * 用户列表和分页
	 * @param pageInfo  分页参数
	 * @return
	 */
	@RemoteMethod
	public Map<String, Object> userListByPage(PageInfo pageInfo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserInfoVo> lists = userService.getUserList(pageInfo);
		map.put("pageInfo", pageInfo);
		map.put("userLists", lists);
		return map;
	}
	
	/**
	 * 得到用户名
	 * @return
	 */
	@RemoteMethod
	public String loadUserName(){	
		String userName = (String)ActionContext.getContext().getSession().get("userName");
		if(userName == null){
			return "";
		}else{
			return userName;
		}
		
	}
    
}
