package com.lamp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.model.CartShop;
import com.lamp.model.Lamp;
import com.lamp.service.LampService;
import com.lamp.util.PageInfo;
import com.lamp.vo.LampVo;
import com.opensymphony.xwork2.ActionContext;


@Component("LampAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name = "lampAction")
public class LampAction extends SuperAction implements SessionAware{
      LampService lampService;
      Map<String, Object> session;
      Map cart;
      @Resource
	public void setLampService(LampService lampService) {
		this.lampService = lampService;
	}
     
	@RemoteMethod
	public LampVo detailsLamp(Integer lampId){
		return lampService.detailsLamp(lampId);
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	/**
       * 显示所用灯饰
       * @param pageInfo  分页参数
       * @return
       */
    @RemoteMethod
    public Map<String, Object> lampListByPage(PageInfo pageInfo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<LampVo> listVos = lampService.getLampList(pageInfo);
    	map.put("lampVos", listVos);
    	map.put("pageInfo", pageInfo);
    	return map;
    }  
    
    /**
     * 分类显示灯饰
     * @param pageInfo  分页参数
     * @param type      类型
     * @return
     */
    @RemoteMethod
    public Map<String, Object> lampTypeListByPage(Integer type, PageInfo pageInfo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	System.out.println("---------------");
        List<LampVo> lampVos = lampService.lampTypeListByPage(pageInfo, type);
        map.put("pageInfo", pageInfo);
        map.put("lampVos", lampVos);
       
        return map;
    }
    
    /**
     * 添加lamp到购物车
     * @param lampId  灯饰id
     * @return
     */
    @RemoteMethod
    public void addLampToCart(Integer lampId, Integer count){
    	cart = (Map)ActionContext.getContext().getSession().get("cart");
    	System.out.println("cart-->"+cart);
    	if(cart == null){
    		 cart = new HashMap();
    	}
    	LampVo lampVo = lampService.detailsLamp(lampId);
    	
    		lampVo.setCount(count);
    
    	cart.put(lampId, lampVo);	
    	ActionContext.getContext().getSession().put("cart", cart);
    }
    
    /**
     * 取得购物车的物价数
     * @return
     */
    @RemoteMethod
    public Integer cartCount(){
    	return (Integer)ActionContext.getContext().getSession().get("cartSize");
    	
    }
    /**
     * 获取购物车的所有物品
     * @return
     */
    @RemoteMethod
    public List<LampVo> cartLamp(){
       Map map = (Map)ActionContext.getContext().getSession().get("cart");
       System.out.println("mapSize-->"+map.size());
       List list = new ArrayList();
       Iterator it = map.keySet().iterator();
       while(it.hasNext()){
    	   list.add(map.get(it.next()));
       }
       return list;
    }
    
    /**
     * 保存订单..
     */
    @RemoteMethod
    public void insertAllLamp(Long orderId){
    	List<LampVo> listVo = this.cartLamp();
    	for(LampVo lamp : listVo){
    		CartShop cartShop = new CartShop();
    		
    		if(cartShop.getLamp() == null){
    			Lamp lamp1 = new Lamp();
    			lamp1.setLampId(lamp.getLampId());
    		}else{
    			cartShop.getLamp().setLampId(lamp.getLampId());
    		}
    		cartShop.setCount(lamp.getCount());
    		cartShop.setOrderId(orderId);
    		cartShop.setPerPrice(lamp.getPrice());
    		lampService.addCartShop(cartShop);
    	}
    }
    
}
