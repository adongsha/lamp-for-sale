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
    
    /*-----------------统计订单数---------------------------*/
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
    /*---------------------统计订单额-----------------------------------------*/
    
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
    
    /*-------------------------统计退单数-------------------------------------*/
    
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
    
    /*--------------------------统计退单额------------------------------------*/

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
     * 未处理的订单
     */
    @RemoteMethod
    public Integer notDealOrder(){
    	return orderService.notDealOrder();
    }
    
    /**
     * 已经处理的订单
     * @return
     */
    @RemoteMethod
    public Integer dealedOrder(){
    	return orderService.dealedOrder();
    }
    
    /**
     * 有问题的订单
     * @return
     */
    @RemoteMethod
    public Integer problemOrder(){
    	return orderService.problemOrder();
    }
    
    /**
     * 已处理订单的总额
     * @return
     */
    @RemoteMethod
    public Double dealedOrderAmount(){
    	return orderService.dealedOrderAmount();
    }
    
    /**
     * 未处理订单的总额
     * @return
     */
    @RemoteMethod
    public Double notDealOrderAmount(){
    	return orderService.notDealOrderAmount();
    }
    
    /**
     * 有问题订单的总额
     * @return
     */
    @RemoteMethod
    public Double problemOrderAmount(){
    	return orderService.problemOrderAmount();
    }
    
    /**
     * 订单列表和分页
     * @param pageInfo 分页参数
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
     * 分类订单列表
     * @param pageInfo    分页参数
     * @param orderStatus 订单状态
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
     * 添加订单      2表示没有处理的订单
     * @param userName   用户名
     * @param telephone  电话
     * @param message    备注
     * @param email      邮件
     * @param code       邮编
     * @param address    地址
     * @param allPrice   总价钱
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
     * 填充订单个人信息
     * @return
     */
    @RemoteMethod
    public Map<String,Object> orderInfo(){
    	Map<String, Object> map = new HashMap<String, Object>();
    	long orderId = System.currentTimeMillis();  //随机生成订单号
    	map.put("orderId", orderId);
    	String userName = (String)ActionContext.getContext().getSession().get("userName");
    	UserInfoVo user = orderService.personalInfo(userName);
    	map.put("userInfo", user);
    	Double allPrice = (Double)ActionContext.getContext().getSession().get("allPrice");
    	map.put("allPrice", allPrice);
    	return map;
    }
    
    /**
     * 记住总价钱
     * @param allPrice  总价钱
     */
    @RemoteMethod
    public void sessionAllPrice(Double allPrice){
    	System.out.println("進入allPrice");
    	ActionContext.getContext().getSession().put("allPrice", allPrice);
    	System.out.println("輸出allPRice:"+ActionContext.getContext().getSession().get("allPrice"));
    }
    
    /**
     * 提交订单信息
     * @param orderId   订单id
     * @param allPrice  订单总价
     * @param userName  接收人
     * @param email     邮件
     * @param phone     电话
     * @param address   地址
     * @param message   备注
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
    	System.out.println("進入addOrder");
    	orderService.addOrder(orderInfo);
    	System.out.println("成功");
    }*/
    
}
