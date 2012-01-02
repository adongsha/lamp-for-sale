package com.lamp.dao;

import java.util.List;

import com.lamp.model.OrderInfo;
import com.lamp.model.UserInfo;
import com.lamp.util.PageInfo;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param order  订单对象
	 */
    public void addOrder(OrderInfo order);
    
    /**
     * 订单列表
     * @return  orderInfo对象集
     */
    public List<OrderInfo> orderList(PageInfo pageInfo);
    
    /**
     * 统计总订单数
     * @return  订单数
     */
    public Integer statisticsOrder();
    
    /**
     * 统计今天的订单数
     * @return  订单的数
     */
    public Integer statisticsOrderForToday();
    
    /**
     * 统计月的总订单数
     * @return  月订单数
     */
    public Integer statisticsOrderForMonth();
    
    /**
     * 年总订单数
     * @return  年订单数
     */
    public Integer statisticsOrderForYear();
    
    /**
     * 统计今天的销售总额
     * @return
     */
    public Double statisticsOrderAmountForToday();
    
    /**
     * 统计月的销售总额
     * @return
     */
    public Double statisticsOrderAmountForMonth();
    
    /**
     * 统计年的销售总额
     * @return
     */
    public Double statisticsOrderAmountForYear();
    
    /**
     * 统计今天的总退单数
     * @return
     */
    public Integer statisticsBackSingleForToday();
    
    /**
     * 统计月的总退单数
     * @return
     */
    public Integer statisticsBackSingleForMonth();
    
    /**
     * 统计年的总退单数
     * @return
     */
    public Integer statisticsBackSingleForYear();
    
    /**
     * 统计今日的总退单额
     * @return
     */
    public Double statisticsBackSingleAmountForToday();
    
    /**
     * 统计月的总退单额
     * @return
     */
    public Double statisticsBackSingleAmountForMonth();
    
    /**
     * 统计年的总退单额
     * @return
     */
    public Double statisticsBackSingleAmountForYear();
    /*------------------------------------------------*/
    
    /**
     * 未处理的订单
     */
    public Integer notDealOrder();
    
    /**
     * 已经处理的订单
     * @return
     */
    public Integer dealedOrder();
    
    /**
     * 有问题的订单
     * @return
     */
    public Integer problemOrder();
    
    /**
     * 已处理订单的总额
     * @return
     */
    public Double dealedOrderAmount();
    
    /**
     * 未处理订单的总额
     * @return
     */
    public Double notDealOrderAmount();
    
    /**
     * 有问题订单的总额
     * @return
     */
    public Double problemOrderAmount();
    
   // public List<OrderInfo> selectOrder(String orderId);
    
    /**
     * 已结账的订单列表
     * @param pageInfo    分页参数
     * @param orderStatus 订单的状态
     * @return
     */
    public List<OrderInfo> orderStatusListByPage(PageInfo pageInfo, int orderStatus);
    
    /**
     * 通过用户名得到个人的信息
     * @param userName   用户名
     * @return
     */
    public UserInfo personalInfo(String userName);

    /**
     * 通過用戶id得到指定的個人對象
     * @param userId
     * @return
     */
   public UserInfo loadUserByUserId(Long userId);
   
   /**
    * 原生SQL語句插入order
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
