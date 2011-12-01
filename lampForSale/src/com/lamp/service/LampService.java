package com.lamp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
import com.lamp.model.Lamp;
@Component("lampService")
public class LampService {
    LampDao lampDao;

    @Resource
	public void setLampDao(LampDao lampDao) {
		this.lampDao = lampDao;
	}
    
    public void addLamp(Lamp lamp){
    	lampDao.addLamp(lamp);
    }
}
