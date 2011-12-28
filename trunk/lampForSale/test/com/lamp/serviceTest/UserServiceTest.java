package com.lamp.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lamp.model.UserInfo;
import com.lamp.service.UserService;

public class UserServiceTest {
	UserService userService = null;
	ClassPathXmlApplicationContext context = null;

	@Before
	public void Before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		userService = (UserService) context.getBean("userService");
		System.out.println(userService);
	}
	
	
	/**
	 * ²âÊÔ×¢²á·½·¨
	 */
	@Test
	public void testRegister(){
		UserInfo user = new UserInfo();
		user.setUserName("xiao");
		user.setAddress("sdfsdf");
		user.setPhone("35463");
		user.setPassword("sdfsdf");
		user.setEmail("sdfsdf");
		userService.register(user);
	}
}
