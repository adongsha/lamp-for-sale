package com.lamp.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lamp.model.Lamp;
import com.lamp.service.LampService;



public class LampServerTest {
	LampService lampService = null;
	ClassPathXmlApplicationContext context = null;

	@Before
	public void Before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		lampService = (LampService) context.getBean("lampService");
		System.out.println(lampService);
	}
	
	/**
	 * ≤‚ ‘addLamp()∑Ω∑®
	 */
   @Test
   public void testAddLamp(){
	   Lamp lamp = new Lamp();
	   lamp.setIsbn("sdf");
	   lamp.setPrice(12.0);
	   lamp.setLampName("sdfg");
	   lampService.addLamp(lamp);
   }
}
