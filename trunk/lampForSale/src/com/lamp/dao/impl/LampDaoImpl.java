package com.lamp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
import com.lamp.model.Lamp;
import com.lamp.util.PageInfo;
@Component("lampDao")
public class LampDaoImpl extends HibernateDaoImpl implements LampDao {

	public void addLamp(Lamp lamp) {
        this.save(lamp);
	}

	public List<Lamp> getLampList(PageInfo pageInfo) {
		String hql = "from Lamp";
		if(pageInfo == null){
		return this.find(hql);
		} else {
			return this.findPageByQuery(hql, null, pageInfo);
		}
	}
	
	public Lamp detailsLamp(Integer lampId){
		String hql = "from Lamp l where l.lampId="+lampId;
		return (Lamp) this.find(hql).get(0);
	}

	public void updateLamp(Integer lampId) {
		String hql = "update Lamp l set l.isdn=?, l.lampName=?, l.type=?, l.lampDescription=?, l.price=?,"+
		             "l.origin, l.size=?, l.material=?, l.process=?, l.weight=?, l.prictureImage1=?, l.prictureImage2=?,"+
		             "l.prictureImage13=?, l.prictureImage4=? where l.lampId=?";
		Object[] object = new Object[]{};

	}

	public List<Lamp> lampTypeListByPage(PageInfo pageInfo, Integer type) {
		String hql = "from Lamp l where l.type="+type;
		if(pageInfo == null){
			return this.find(hql);
		} else {
			return this.findPageByQuery(hql, null, pageInfo);
		}
	}

	
    
}
