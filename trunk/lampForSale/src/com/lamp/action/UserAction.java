package com.lamp.action;


import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.model.UserInfo;
import com.lamp.service.UserService;

@Component("UserAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name="userAction")
public class UserAction extends SuperAction {
   private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
   
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
}
