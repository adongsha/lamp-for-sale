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
}
