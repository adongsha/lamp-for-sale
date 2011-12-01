package com.lamp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
import com.lamp.model.Lamp;
@Component("lampDao")
public class LampDaoImpl extends HibernateDaoImpl implements LampDao {

	public void addLamp(Lamp lamp) {
        this.save(lamp);
	}

	public List<Lamp> getLampList() {
		String hql = "from Lamp";
		return this.find(hql);
	}

	public void updateLamp(Integer lampId) {
		String hql = "update Lamp l set l.isdn=?, l.lampName=?, l.type=?, l.lampDescription=?, l.price=?,"+
		             "l.origin, l.size=?, l.material=?, l.process=?, l.weight=?, l.prictureImage1=?, l.prictureImage2=?,"+
		             "l.prictureImage13=?, l.prictureImage4=? where l.lampId=?";
		Object[] object = new Object[]{};

	}

	
    
}
