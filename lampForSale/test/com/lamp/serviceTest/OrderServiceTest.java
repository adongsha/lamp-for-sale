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
	 * 测试统计今天的订单数
	 */
    @Test
    public void testStatisticsOrderForToday(){
    	System.out.println("今天的订单数"+orderService.statisticsOrderForToday());
    }
    
    /**
     * 测试统计月的总订单数
     */
    @Test
    public void testStatisticsOrderForMonth(){
    	System.out.println(orderService.statisticsOrderForMonth());
    }
    
    /**
     * 测试统计年的总订单数
     */
    @Test
    public void testStatisticsOrderForYear(){
    	System.out.println(orderService.statisticsOrderForYear());
    }
    
    /**
     * 测试统计月销售额
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
