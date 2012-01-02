package com.lamp.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lamp.service.OrderService;

public class OrderServiceTest {
	OrderService orderService = null;
	ClassPathXmlApplicationContext context = null;

	@Before
	public void Before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		orderService = (OrderService) context.getBean("orderService");
		System.out.println(orderService);
	}
	
	/**
	 * ����ͳ�ƽ���Ķ�����
	 */
    @Test
    public void testStatisticsOrderForToday(){
    	System.out.println("����Ķ�����"+orderService.statisticsOrderForToday());
    }
    
    /**
     * ����ͳ���µ��ܶ�����
     */
    @Test
    public void testStatisticsOrderForMonth(){
    	System.out.println(orderService.statisticsOrderForMonth());
    }
    
    /**
     * ����ͳ������ܶ�����
     */
    @Test
    public void testStatisticsOrderForYear(){
    	System.out.println(orderService.statisticsOrderForYear());
    }
    
    /**
     * ����ͳ�������۶�
     */
    @Test
    public void testStatisticsOrderAmountForMonth(){
    	System.out.println(orderService.statisticsOrderAmountForMonth());
    }
    
    @Test
    public void testTest(){
    	//orderService.test();
    }
}
