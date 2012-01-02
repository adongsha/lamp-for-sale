package com.lamp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
import com.lamp.model.CartShop;
import com.lamp.model.Lamp;
import com.lamp.util.Model2VoUtil;
import com.lamp.util.PageInfo;
import com.lamp.vo.LampVo;
@Component("lampService")
public class LampService {
    LampDao lampDao;

    @Resource
	public void setLampDao(LampDao lampDao) {
		this.lampDao = lampDao;
	}
    
    
    /**
     * 添加灯饰
     * @param lamp
     */
    public void addLamp(Lamp lamp){
    	lampDao.addLamp(lamp);
    }
    
    /**
     * 获得灯的详细信息
     * @param lampId  灯的id
     * @return
     */
    public LampVo detailsLamp(Integer lampId){
    	Lamp lamp =  lampDao.detailsLamp(lampId);
    	LampVo lampVo = Model2VoUtil.lamp2lampVo(lamp);
    	return lampVo;
    }
    
    
    /**
     * 灯饰列表和分页
     * @param pageInfo 分页参数
     * @return
     */
    public List<LampVo> getLampList(PageInfo pageInfo){
    	List<Lamp> lamps = lampDao.getLampList(pageInfo);
    	List<LampVo> lampVos = new ArrayList<LampVo>();
    	for(Lamp lamp : lamps){
    		LampVo lampVo = Model2VoUtil.lamp2lampVo(lamp);
    		lampVos.add(lampVo);
    	}
    	return lampVos;
    }
    
    /**
     * 分类查询灯饰列表
     * @param pageInfo  分页参数
     * @param type      灯饰类型
     * @return
     */
    public List<LampVo> lampTypeListByPage(PageInfo pageInfo, Integer type){
    	List<Lamp> lamps = lampDao.lampTypeListByPage(pageInfo, type);
    	List<LampVo> lampVos = new ArrayList<LampVo>();
    	for(Lamp lamp : lamps){
    		LampVo lampVo = Model2VoUtil.lamp2lampVo(lamp);
    		lampVos.add(lampVo);
    	}
    	return lampVos;
    }
    
    /**
     * 添加购物车商品
     * @param cartShop  对象
     */
    public void addCartShop(CartShop cartShop) {
    	lampDao.addCartShop(cartShop);
    }
}
