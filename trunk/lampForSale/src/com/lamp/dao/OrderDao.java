package com.lamp.dao;

import java.util.List;

import com.lamp.model.OrderInfo;
import com.lamp.model.UserInfo;
import com.lamp.util.PageInfo;

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
    public List<OrderInfo> orderList(PageInfo pageInfo);
    
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
    /*------------------------------------------------*/
    
    /**
     * δ����Ķ���
     */
    public Integer notDealOrder();
    
    /**
     * �Ѿ�����Ķ���
     * @return
     */
    public Integer dealedOrder();
    
    /**
     * ������Ķ���
     * @return
     */
    public Integer problemOrder();
    
    /**
     * �Ѵ��������ܶ�
     * @return
     */
    public Double dealedOrderAmount();
    
    /**
     * δ���������ܶ�
     * @return
     */
    public Double notDealOrderAmount();
    
    /**
     * �����ⶩ�����ܶ�
     * @return
     */
    public Double problemOrderAmount();
    
   // public List<OrderInfo> selectOrder(String orderId);
    
    /**
     * �ѽ��˵Ķ����б�
     * @param pageInfo    ��ҳ����
     * @param orderStatus ������״̬
     * @return
     */
    public List<OrderInfo> orderStatusListByPage(PageInfo pageInfo, int orderStatus);
    
    /**
     * ͨ���û����õ����˵���Ϣ
     * @param userName   �û���
     * @return
     */
    public UserInfo personalInfo(String userName);

    /**
     * ͨ�^�Ñ�id�õ�ָ���Ă��ˌ���
     * @param userId
     * @return
     */
   public UserInfo loadUserByUserId(Long userId);
   
   /**
    * ԭ��SQL�Z�����order
    * @param orderId
    * @param allPrice
    * @param userName
    * @param email
    * @param phone
    * @param address
    * @param message
    * @param userId
    */
   public void insertOrder(Long orderId, Double allPrice, String userName, 
   		String email, String phone, String address, String message, Long userId);
}
