package com.lamp.dao;

import java.util.List;

import com.lamp.model.OrderInfo;

public interface OrderDao {
	/**
	 * ��Ӷ���
	 * @param order  ��������
	 */
    public void addOrder(OrderInfo order);
    
    /**
     * �����б�
     * @return  orderInfo����
     */
    public List<OrderInfo> orderList();
    
    /**
     * ͳ���ܶ�����
     * @return  ������
     */
    public Integer statisticsOrder();
    
    /**
     * ͳ�ƽ���Ķ�����
     * @return  ��������
     */
    public Integer statisticsOrderForToday();
    
    /**
     * ͳ���µ��ܶ�����
     * @return  �¶�����
     */
    public Integer statisticsOrderForMonth();
    
    /**
     * ���ܶ�����
     * @return  �궩����
     */
    public Integer statisticsOrderForYear();
    
    /**
     * ͳ�ƽ���������ܶ�
     * @return
     */
    public Double statisticsOrderAmountForToday();
    
    /**
     * ͳ���µ������ܶ�
     * @return
     */
    public Double statisticsOrderAmountForMonth();
    
    /**
     * ͳ����������ܶ�
     * @return
     */
    public Double statisticsOrderAmountForYear();
    
    /**
     * ͳ�ƽ�������˵���
     * @return
     */
    public Integer statisticsBackSingleForToday();
    
    /**
     * ͳ���µ����˵���
     * @return
     */
    public Integer statisticsBackSingleForMonth();
    
    /**
     * ͳ��������˵���
     * @return
     */
    public Integer statisticsBackSingleForYear();
    
    /**
     * ͳ�ƽ��յ����˵���
     * @return
     */
    public Double statisticsBackSingleAmountForToday();
    
    /**
     * ͳ���µ����˵���
     * @return
     */
    public Double statisticsBackSingleAmountForMonth();
    
    /**
     * ͳ��������˵���
     * @return
     */
    public Double statisticsBackSingleAmountForYear();
}
