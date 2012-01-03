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
    
    /**
     * �yԇ�yӋ������N���~
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
