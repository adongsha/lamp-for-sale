package com.lamp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.OrderDao;
import com.lamp.model.OrderInfo;
import com.lamp.model.UserInfo;
import com.lamp.util.Model2VoUtil;
import com.lamp.util.PageInfo;
import com.lamp.vo.OrderInfoVo;
import com.lamp.vo.UserInfoVo;

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
	
	
	 /**
     * δ����Ķ���
     */
    public Integer notDealOrder(){
    	return orderDao.notDealOrder();
    }
    
    /**
     * �Ѿ�����Ķ���
     * @return
     */
    public Integer dealedOrder(){
    	return orderDao.dealedOrder();
    }
    
    /**
     * ������Ķ���
     * @return
     */
    public Integer problemOrder(){
    	return orderDao.problemOrder();
    }
    
    /**
     * �Ѵ��������ܶ�
     * @return
     */
    public Double dealedOrderAmount(){
    	return orderDao.dealedOrderAmount();
    }
    
    /**
     * δ���������ܶ�
     * @return
     */
    public Double notDealOrderAmount(){
    	return orderDao.notDealOrderAmount();
    }
    
    /**
     * �����ⶩ�����ܶ�
     * @return
     */
    public Double problemOrderAmount(){
    	return orderDao.problemOrderAmount();
    }
    
    /*---------------------------------------------------*/
    /**
     * ���ö���
     */
    public List<OrderInfoVo> orderListByPage(PageInfo pageInfo) {
    	List<OrderInfo> lists = orderDao.orderList(pageInfo);
    	List<OrderInfoVo> listVos = new ArrayList<OrderInfoVo>();
    	for(OrderInfo orderInfo : lists){
    		OrderInfoVo orderInfoVo = Model2VoUtil.orderInfo2orderInfoVo(orderInfo);
    		listVos.add(orderInfoVo);
    	}
    	return listVos;
    }
    
    /**
     * ���ඩ��:�Ѵ�������δ�������������ⶩ��
     */
    public List<OrderInfoVo> orderStatusListByPage(PageInfo pageInfo, int orderStatus){
    	List<OrderInfo> orderInfos = orderDao.orderStatusListByPage(pageInfo, orderStatus);
        List<OrderInfoVo> orderInfoVos = new ArrayList<OrderInfoVo>();
        for(OrderInfo orderInfo : orderInfos){
        	OrderInfoVo orderInfoVo = Model2VoUtil.orderInfo2orderInfoVo(orderInfo);
        	orderInfoVos.add(orderInfoVo);
        }
        return orderInfoVos;
    }
    
    /**
     * ��Ӷ���
     * @param order  ��������
     */
    public void addOrder(OrderInfo order){
    	orderDao.addOrder(order);
    }
    
    /**
     * ��ø�����Ϣ
     * @param userName �û���
     * @return
     */
    public UserInfoVo personalInfo(String userName) {
    	UserInfo user = orderDao.personalInfo(userName);
    	UserInfoVo userInfoVo = Model2VoUtil.userInfo2userInfoVo(user);
    	return userInfoVo;
    }
    
    
    /**
     * ͨ�^�Ñ�id�õ�ָ�����Ñ���Ϣ
     * @param userId  �Ñ�id
     * @return
     */
    public UserInfo loadUserByUserId(Long userId){
    	return orderDao.loadUserByUserId(userId);
    }
    
    public void insertOrder(Long orderId, Double allPrice, String userName,
			String email, String phone, String address, String message,
			Long userId) {
    	orderDao.insertOrder(orderId, allPrice, userName, email, phone, address, message, userId);
    }
    
    
    
   /* public void addOrders(Long orderId, Double allPrice, String userName, 
    		String email, String phone, String address, String message, Long userId){
    	OrderInfo orderInfo = new OrderInfo();
    	UserInfo user = this.loadUserByUserId(userId);
    	System.out.println("user-->"+user);
    	orderInfo.setUserInfo(user);
    	orderInfo.setAllPrice(allPrice);
    	orderInfo.setOrderId(orderId);
    	orderInfo.setOrderAddress(address);
    	orderInfo.setOrderEmail(email);
    	orderInfo.setOrderPerson(userName);
    	orderInfo.setMessage(message);
    	orderInfo.setAllPrice(allPrice);
    	orderInfo.setOrderTime("65655");
    	orderInfo.setOrderStatus(1);
    	System.out.println("�M��addOrder");
    	this.addOrder(orderInfo);
    	System.out.println("�ɹ�");
    }*/
}
