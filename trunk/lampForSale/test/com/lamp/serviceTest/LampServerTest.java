package com.lamp.serviceTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
   
   @Test
   public void test(){
	     DateFormat df=DateFormat.getDateInstance();
	     SimpleDateFormat defaultSDF=new SimpleDateFormat();
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	     SimpleDateFormat aaa=new SimpleDateFormat("MM");
	     System.out.println(new Date());
	     System.out.println("--"+df.format(new Date()));
	     System.out.println(defaultSDF.format(new Date()));
	     System.out.println(sdf.format(new Date()));
         System.out.println(aaa.format(new Date()));
   }
}
