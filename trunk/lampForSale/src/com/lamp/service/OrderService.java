package com.lamp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.OrderDao;

@Component("orderService")
public class OrderService {
	private OrderDao orderDao;

	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
	/*---------------------统计 订单 数----------------------------*/
	/**
	 * 统计今天的订单数
	 * @return  今天的订单数
	 */
	public Integer statisticsOrderForToday(){
		return orderDao.statisticsOrderForToday();
	} 
	
	/**
	 * 统计月的总订单数
	 * @return 月的总订单数
	 */
	public Integer statisticsOrderForMonth(){
		return orderDao.statisticsOrderForMonth();
	}
	
	/**
	 * 统计年的总订单数
	 * @return   年的总订单数
	 */
	public Integer statisticsOrderForYear(){
		return orderDao.statisticsOrderForYear();
	}
	/*---------------------统计 订单 数 结束----------------------------*/
	
	
	/*----------------------统计订单总额------------------------------*/
	/**
	 * 统计月的订单总额
	 * @return  月的订单总额
	 */
	public Double statisticsOrderAmountForMonth(){
		return orderDao.statisticsOrderAmountForMonth();
	}
	
	/**
	 * 统计今天的订单总额
	 * @return  今天的订单总额
	 */
	public Double statisticsOrderAmountForToday(){
		return orderDao.statisticsOrderAmountForToday();
	}
	
	/**
	 * 统计年的订单总额
	 * @return  年的订单总额
	 */
	public Double statisticsOrderAmountForYear(){
		return orderDao.statisticsOrderAmountForYear();
	}
	/*----------------------统计订单总额 结束------------------------------*/
	
	
	/*----------------------统计退单数---------------------------------------*/
	
	/**
	 * 统计月退单数
	 */
	public Integer statisticsBackSingleForMonth() {
		return orderDao.statisticsBackSingleForMonth();
	}
	
	
	/**
	 * 统计今天退单数
	 * @return
	 */
	public Integer statisticsBackSingleForToday(){
		return orderDao.statisticsBackSingleForToday();
	}
	
	
	/**
	 * 统计年退单数
	 * @return
	 */
	public Integer statisticsBackSingleForYear() {
		return orderDao.statisticsBackSingleForYear();
	}
	/*----------------------统计退单数 结束---------------------------------------*/


	/*----------------------统计退单总额-----------------------------------*/
	
	/**
	 * 统计月总退单额
	 */
	public Double statisticsBackSingleAmountForMonth() {
		return orderDao.statisticsBackSingleAmountForMonth();
	}
	
	
	/**
	 * 统计今天退单总额
	 * @return
	 */
	public Double statisticsBackSingleAmountForToday(){
		return orderDao.statisticsBackSingleAmountForToday();
	} 
	
	
	/**
	 * 统计年退单总额
	 * @return
	 */
	public Double statisticsBackSingleAmountForYear() {
		return orderDao.statisticsBackSingleAmountForYear();
	}
	/*----------------------统计退单总额结束-----------------------------------*/
}
