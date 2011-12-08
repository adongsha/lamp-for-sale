package com.lamp.action;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.service.OrderService;

@Component("OrderAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name = "orderAction")
public class OrderAction extends SuperAction {
     OrderService orderService;

    @Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
     
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
    /*--------------------------------------------------------------*/
    
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
    
    /*--------------------------------------------------------------*/
    
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
    
    
}
