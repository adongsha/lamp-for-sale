package com.lamp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
    public Integer addLampToCart(Integer lampId){
    	LampVo lampVo = lampService.detailsLamp(lampId);
    	List<LampVo> listLamps = new ArrayList<LampVo>();
    	listLamps.add(lampVo); 	
    	ActionContext.getContext().getSession().put("listLamps", listLamps);
    	ActionContext.getContext().getSession().put("cartSize", listLamps.size());
    	return null;
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
       List list = (List)ActionContext.getContext().getSession().get("listLamps");
       return list;
    }
    
    
}
