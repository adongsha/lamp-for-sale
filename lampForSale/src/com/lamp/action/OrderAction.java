package com.lamp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.service.OrderService;
import com.lamp.util.PageInfo;
import com.lamp.vo.OrderInfoVo;

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
}
