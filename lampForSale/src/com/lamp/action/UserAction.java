package com.lamp.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.model.UserInfo;
import com.lamp.service.UserService;
import com.lamp.util.PageInfo;
import com.lamp.vo.UserInfoVo;

@Component("UserAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name="userAction")
public class UserAction extends SuperAction {
   private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
   
	/**
	 * �û�ע��
	 * @param userName  �û���
	 * @param password  ����
	 * @param email     �ʼ�
	 * @param telephone �绰
	 * @param address   ��ַ
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
	 * ͳ���û����������
	 * @return
	 */
	@RemoteMethod
	public Map<String, Integer> countPower() {
		return userService.countPower();
	}
	
	/**
	 * �û��б�ͷ�ҳ
	 * @param pageInfo  ��ҳ����
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
}
