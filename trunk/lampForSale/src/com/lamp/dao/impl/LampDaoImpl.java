package com.lamp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
import com.lamp.model.CartShop;
import com.lamp.model.Lamp;
import com.lamp.model.OrderInfo;
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
	
	public Lamp detailsLamp(Long lampId){
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

	public void addCartShop(CartShop cartShop) {
	    this.save(cartShop);
	}

	public Lamp loadLampByLampId(Long lampId) {
		String hql = "from Lamp l where l.lampId="+lampId;
		List<Lamp> list = this.find(hql);
		if(list.size() < 1){
			return null;
		}
		return list.get(0);
	}

	public OrderInfo loadOrderByOrderId(Long orderId) {
		String hql = "from OrderInfo o where o.orderId="+orderId;
		List<OrderInfo> list = this.find(hql);
		if(list.size() < 1){
			return null;
		}
		return list.get(0);
	}

	public void insertCartShop(Long lampId, Long orderId, Integer count,
			Double perPrice) {
		String sql = "insert into cartShop (lampId,orderId,count,perPrice)"
			         +" values("+lampId+","+orderId+","+count+","+perPrice+")";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

       
}
