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
	
	
	/*---------------------ͳ�� ���� ��----------------------------*/
	/**
	 * ͳ�ƽ���Ķ�����
	 * @return  ����Ķ�����
	 */
	public Integer statisticsOrderForToday(){
		return orderDao.statisticsOrderForToday();
	} 
	
	/**
	 * ͳ���µ��ܶ�����
	 * @return �µ��ܶ�����
	 */
	public Integer statisticsOrderForMonth(){
		return orderDao.statisticsOrderForMonth();
	}
	
	/**
	 * ͳ������ܶ�����
	 * @return   ����ܶ�����
	 */
	public Integer statisticsOrderForYear(){
		return orderDao.statisticsOrderForYear();
	}
	/*---------------------ͳ�� ���� �� ����----------------------------*/
	
	
	/*----------------------ͳ�ƶ����ܶ�------------------------------*/
	/**
	 * ͳ���µĶ����ܶ�
	 * @return  �µĶ����ܶ�
	 */
	public Double statisticsOrderAmountForMonth(){
		return orderDao.statisticsOrderAmountForMonth();
	}
	
	/**
	 * ͳ�ƽ���Ķ����ܶ�
	 * @return  ����Ķ����ܶ�
	 */
	public Double statisticsOrderAmountForToday(){
		return orderDao.statisticsOrderAmountForToday();
	}
	
	/**
	 * ͳ����Ķ����ܶ�
	 * @return  ��Ķ����ܶ�
	 */
	public Double statisticsOrderAmountForYear(){
		return orderDao.statisticsOrderAmountForYear();
	}
	/*----------------------ͳ�ƶ����ܶ� ����------------------------------*/
	
	
	/*----------------------ͳ���˵���---------------------------------------*/
	
	/**
	 * ͳ�����˵���
	 */
	public Integer statisticsBackSingleForMonth() {
		return orderDao.statisticsBackSingleForMonth();
	}
	
	
	/**
	 * ͳ�ƽ����˵���
	 * @return
	 */
	public Integer statisticsBackSingleForToday(){
		return orderDao.statisticsBackSingleForToday();
	}
	
	
	/**
	 * ͳ�����˵���
	 * @return
	 */
	public Integer statisticsBackSingleForYear() {
		return orderDao.statisticsBackSingleForYear();
	}
	/*----------------------ͳ���˵��� ����---------------------------------------*/


	/*----------------------ͳ���˵��ܶ�-----------------------------------*/
	
	/**
	 * ͳ�������˵���
	 */
	public Double statisticsBackSingleAmountForMonth() {
		return orderDao.statisticsBackSingleAmountForMonth();
	}
	
	
	/**
	 * ͳ�ƽ����˵��ܶ�
	 * @return
	 */
	public Double statisticsBackSingleAmountForToday(){
		return orderDao.statisticsBackSingleAmountForToday();
	} 
	
	
	/**
	 * ͳ�����˵��ܶ�
	 * @return
	 */
	public Double statisticsBackSingleAmountForYear() {
		return orderDao.statisticsBackSingleAmountForYear();
	}
	/*----------------------ͳ���˵��ܶ����-----------------------------------*/
}
