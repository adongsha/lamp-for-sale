package com.lamp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.OrderDao;
import com.lamp.model.OrderInfo;
import com.lamp.util.Model2VoUtil;
import com.lamp.util.PageInfo;
import com.lamp.vo.OrderInfoVo;

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
	
	
	 /**
     * 未处理的订单
     */
    public Integer notDealOrder(){
    	return orderDao.notDealOrder();
    }
    
    /**
     * 已经处理的订单
     * @return
     */
    public Integer dealedOrder(){
    	return orderDao.dealedOrder();
    }
    
    /**
     * 有问题的订单
     * @return
     */
    public Integer problemOrder(){
    	return orderDao.problemOrder();
    }
    
    /**
     * 已处理订单的总额
     * @return
     */
    public Double dealedOrderAmount(){
    	return orderDao.dealedOrderAmount();
    }
    
    /**
     * 未处理订单的总额
     * @return
     */
    public Double notDealOrderAmount(){
    	return orderDao.notDealOrderAmount();
    }
    
    /**
     * 有问题订单的总额
     * @return
     */
    public Double problemOrderAmount(){
    	return orderDao.problemOrderAmount();
    }
    
    /*---------------------------------------------------*/
    /**
     * 所用订单
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
     * 分类订单:已处理订单、未处理订单、有问题订单
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
     * 添加订单
     * @param order  订单对象
     */
    public void addOrder(OrderInfo order){
    	orderDao.addOrder(order);
    }
    
    public void test(){
    	Long s = System.currentTimeMillis();
    	System.out.println("--->"+s);
    }
}
