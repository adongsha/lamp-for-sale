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
import com.lamp.model.OrderInfo;
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
	public LampVo detailsLamp(Long lampId){
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
    public void addLampToCart(Long lampId, Integer count){
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
/*    @RemoteMethod
    public void insertAllLamp(Long orderId){
    	List<LampVo> listVo = this.cartLamp();
    	for(LampVo lampVo : listVo){
    		CartShop cartShop = new CartShop();
    		Lamp lamp = lampService.loadLampByLampId(lampVo.getLampId());
    		cartShop.setLamp(lamp);
    		OrderInfo orderInfo = lampService.loadOrderByOrderId(orderId);
    		cartShop.setOrderInfo(orderInfo);
    		cartShop.setCount(lampVo.getCount());
    		cartShop.setPerPrice(lampVo.getPrice());
    		lampService.addCartShop(cartShop);
    	}
    }*/
    
    
    /**
     * 插入訂單物品
     * @param lampId
     * @param orderId
     * @param count
     * @param perPrice
     */
    @RemoteMethod
    public void insertCartShop(Long orderId) {
    	List<LampVo> listVo = this.cartLamp();
    	for(LampVo lampVo : listVo){
    		lampService.insertCartShop(lampVo.getLampId(), orderId, lampVo.getCount(), lampVo.getPrice());
    	}
    }
    
    /**
     * 修改灯饰
     * @param isbn
     * @param lampName
     * @param type
     * @param lampDescription
     * @param price
     * @param origin
     * @param size
     * @param material
     * @param process
     * @param lampId
     */
    @RemoteMethod
    public void updateLamp(String isbn, String lampName, Integer type, String lampDescription, Double price,
	          String origin, String size, String material, String process, String weight, Long lampId) {
    	lampService.updateLamp(isbn, lampName, type, lampDescription, price, origin, size, material, process, weight, lampId);
    }
    
    /**
     * 删除灯饰
     * @param lampId
     */
    @RemoteMethod
    public void delLamp(Long lampId){
    	Lamp lamp = lampService.lamp(lampId);
    	lampService.delLamp(lamp);
    }
}
