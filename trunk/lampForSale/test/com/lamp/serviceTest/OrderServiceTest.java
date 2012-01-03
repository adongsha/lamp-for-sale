package com.lamp.serviceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lamp.service.OrderService;
import com.lamp.vo.CartShopVo;

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
    
    /**
     * 測試統計今天的銷售額
     */
    @Test
    public void testStatisticsOrderAmountForToday(){
    	System.out.println(orderService.statisticsOrderAmountForToday());
    }
    
    /*@Test
    public void testTest(){
    	orderService.addOrders(23l, 36.2, "sdf", "sdf", "54654", "erw", "wer", 3l);
    }*/
    
    @Test
    public void testInsertOrder(){
    	orderService.insertOrder(25l, 545.3, "qqq", "bb", "cc", "dd", "ee", 3l);
    }
    
    @Test
    public void testLoadCartShopById(){
    	List<CartShopVo> c = orderService.loadCartShopById(1325486783635l);
    	for(CartShopVo v : c){
    		System.out.println(v.getLampName());
    	}
    }
}
