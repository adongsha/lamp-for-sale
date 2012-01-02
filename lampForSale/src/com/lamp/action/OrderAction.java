package com.lamp.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.model.OrderInfo;
import com.lamp.model.UserInfo;
import com.lamp.service.OrderService;
import com.lamp.util.PageInfo;
import com.lamp.vo.OrderInfoVo;
import com.lamp.vo.UserInfoVo;
import com.opensymphony.xwork2.ActionContext;

@Component("OrderAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name = "orderAction")
public class OrderAction extends SuperAction {
     OrderService orderService;

    @Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
    
    /*-----------------ͳ�ƶ�����---------------------------*/
    @RemoteMethod
    public Integer statisticsOrderForToday(){
    	return orderService.statisticsOrderForToday();
    } 
    
    @RemoteMethod
    public Integer statisticsOrderForMonth(){
    	return orderService.statisticsOrderForMonth();
    } 
    
    @RemoteMethod
    public Integer statisticsOrderForYear(){
    	return orderService.statisticsOrderForYear();
    }
    /*---------------------ͳ�ƶ�����-----------------------------------------*/
    
    @RemoteMethod
    public Double statisticsOrderAmountForMonth(){
    	return orderService.statisticsOrderAmountForMonth();
    }
    
    @RemoteMethod
    public Double statisticsOrderAmountForToday(){
    	return orderService.statisticsOrderAmountForToday();
    }
    
    @RemoteMethod
    public Double statisticsOrderAmountForYear(){
    	return orderService.statisticsOrderAmountForYear();
    }
    
    /*-------------------------ͳ���˵���-------------------------------------*/
    
    @RemoteMethod
    public Integer statisticsBackSingleForMonth() {
    	return orderService.statisticsBackSingleForMonth();
    }
    
    @RemoteMethod
    public Integer statisticsBackSingleForToday(){
    	return orderService.statisticsBackSingleForToday();
    }
    
    @RemoteMethod
    public Integer statisticsBackSingleForYear() {
    	return orderService.statisticsBackSingleForYear();
    }	
    
    /*--------------------------ͳ���˵���------------------------------------*/

    @RemoteMethod
    public Double statisticsOrderBackSingleAmountForDay(){
    	return orderService.statisticsBackSingleAmountForToday();
    }
    
    @RemoteMethod
    public Double statisticsOrderBackSingleAmountForMonth(){
    	return orderService.statisticsBackSingleAmountForMonth();
    }
    
    @RemoteMethod
    public Double statisticsOrderBackSingleAmountForYear(){
    	return orderService.statisticsBackSingleAmountForYear();
    }
    
    
	 /**
     * δ����Ķ���
     */
    @RemoteMethod
    public Integer notDealOrder(){
    	return orderService.notDealOrder();
    }
    
    /**
     * �Ѿ�����Ķ���
     * @return
     */
    @RemoteMethod
    public Integer dealedOrder(){
    	return orderService.dealedOrder();
    }
    
    /**
     * ������Ķ���
     * @return
     */
    @RemoteMethod
    public Integer problemOrder(){
    	return orderService.problemOrder();
    }
    
    /**
     * �Ѵ��������ܶ�
     * @return
     */
    @RemoteMethod
    public Double dealedOrderAmount(){
    	return orderService.dealedOrderAmount();
    }
    
    /**
     * δ���������ܶ�
     * @return
     */
    @RemoteMethod
    public Double notDealOrderAmount(){
    	return orderService.notDealOrderAmount();
    }
    
    /**
     * �����ⶩ�����ܶ�
     * @return
     */
    @RemoteMethod
    public Double problemOrderAmount(){
    	return orderService.problemOrderAmount();
    }
    
    /**
     * �����б�ͷ�ҳ
     * @param pageInfo ��ҳ����
     * @return
     */
    @RemoteMethod
    public Map<String, Object> orderListByPage(PageInfo pageInfo){
    	List<OrderInfoVo> orderLists = orderService.orderListByPage(pageInfo);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("orderLists", orderLists);
    	map.put("pageInfo", pageInfo);
    	return map;
    }
    
    /**
     * ���ඩ���б�
     * @param pageInfo    ��ҳ����
     * @param orderStatus ����״̬
     * @return
     */
    @RemoteMethod
    public Map<String, Object> orderStatusListByPage(PageInfo pageInfo, int orderStatus){
    	List<OrderInfoVo> orderInfoVos = orderService.orderStatusListByPage(pageInfo, orderStatus);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageInfo", pageInfo);
    	map.put("orderInfoVos", orderInfoVos);
    	return map;
    }
    
    /**
     * ��Ӷ���      2��ʾû�д���Ķ���
     * @param userName   �û���
     * @param telephone  �绰
     * @param message    ��ע
     * @param email      �ʼ�
     * @param code       �ʱ�
     * @param address    ��ַ
     * @param allPrice   �ܼ�Ǯ
     */
    @RemoteMethod
    public void addOrder(String userName, String telephone, String message, 
    		String email, String code, String address, Double allPrice){
    	OrderInfo order = new OrderInfo();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    	order.setAllPrice(allPrice);
    	order.setMessage(message);
    	order.setOrderEmail(email);
    	order.setOrderPerson(userName);
    	order.setOrderAddress(address);
    	order.setOrderPhone(telephone);
    	order.setOrderTime(sdf.toString());
    	order.setOrderStatus(2);
    	orderService.addOrder(order);
    }
    
    /**
     * ��䶩��������Ϣ
     * @return
     */
    @RemoteMethod
    public Map<String,Object> orderInfo(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	long orderId = System.currentTimeMillis();  //������ɶ�����
    	map.put("orderId", orderId);
    	String userName = (String)ActionContext.getContext().getSession().get("userName");
    	UserInfoVo user = orderService.personalInfo(userName);
    	map.put("userInfo", user);
    	Double allPrice = (Double)ActionContext.getContext().getSession().get("allPrice");
    	map.put("allPrice", allPrice);
    	return map;
    }
    
    /**
     * ��ס�ܼ�Ǯ
     * @param allPrice  �ܼ�Ǯ
     */
    @RemoteMethod
    public void sessionAllPrice(Double allPrice){
    	System.out.println("�M��allPrice");
    	ActionContext.getContext().getSession().put("allPrice", allPrice);
    	System.out.println("ݔ��allPRice:"+ActionContext.getContext().getSession().get("allPrice"));
    }
    
    /**
     * �ύ������Ϣ
     * @param orderId   ����id
     * @param allPrice  �����ܼ�
     * @param userName  ������
     * @param email     �ʼ�
     * @param phone     �绰
     * @param address   ��ַ
     * @param message   ��ע
     */
    @RemoteMethod
    public void insertOrder(Long orderId, Double allPrice, String userName,
			String email, String phone, String address, String message,
			Long userId) {
    	orderService.insertOrder(orderId, allPrice, userName, email, phone, address, message, userId);
    }
/*    @RemoteMethod
    public void addOrder(Long orderId, Double allPrice, String userName, 
    		String email, String phone, String address, String message, Long userId){
    	OrderInfo orderInfo = new OrderInfo();
    	UserInfo user = orderService.loadUserByUserId(userId);
    	orderInfo.setUserInfo(user);
    	orderInfo.setAllPrice(allPrice);
    	orderInfo.setOrderId(orderId);
    	orderInfo.setOrderAddress(address);
    	orderInfo.setOrderEmail(email);
    	orderInfo.setOrderPerson(userName);
    	orderInfo.setMessage(message);
    	orderInfo.setAllPrice(allPrice);
    	System.out.println("�M��addOrder");
    	orderService.addOrder(orderInfo);
    	System.out.println("�ɹ�");
    }*/
    
}
