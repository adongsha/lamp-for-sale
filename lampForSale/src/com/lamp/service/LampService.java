package com.lamp.service;

import javax.annotation.Resource;

import com.lamp.dao.LampDao;
import com.lamp.model.Lamp;

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
