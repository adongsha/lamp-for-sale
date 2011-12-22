package com.lamp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
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
}
