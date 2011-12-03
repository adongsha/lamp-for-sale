package com.lamp.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lamp.dao.OrderDao;
import com.lamp.model.OrderInfo;
@Component("orderDao")
public class OrderDaoImpl extends HibernateDaoImpl implements OrderDao {

	public void addOrder(OrderInfo order) {
         this.save(order);
	}

	
	public List<OrderInfo> orderList() {
		String hql = "from OrderInfo";
		return this.find(hql);
	}


	public Integer statisticsOrder() {
		String hql = "from OrderInfo";
		return this.find(hql).size();
	}
    
	/*---------------------ͳ�� ���� ��----------------------------*/
	public Integer statisticsOrderForMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		//ͨ����ȡ����ʱ���������ͳ���¶�����
		String month = sdf.format(new Date());
		System.out.println(month);
		String hql = "select * from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"'";
		return this.getSession().createSQLQuery(hql).list().size();
	}

	public Integer statisticsOrderForToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //��ʽ��ʱ��
		String today = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+today+"'";
		return this.find(hql).size();
	}

	public Integer statisticsOrderForYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		String hql = "select * from OrderInfo o where substring(o.orderTime,0,5) ='"+year+"'";
		return this.getSession().createSQLQuery(hql).list().size();
	}
	/*---------------------ͳ�� ���� �� ����----------------------------*/

	
	/*----------------------ͳ�ƶ����ܶ�------------------------------*/
	public Double statisticsOrderAmountForMonth() {
		Double monthCounts = 0.000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String month = sdf.format(new Date());
		//ͨ����ȡ����ʱ���������ͳ���¶�����
		String hql = "select * from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"'";
		List<OrderInfo> orders = this.getSession().createSQLQuery(hql).list();      
		for(OrderInfo order : orders){             //�����µ����ж���
			System.out.println("order���󣺣�"+order);
			monthCounts += order.getAllPrice();
		}
		return monthCounts;
	}


	public Double statisticsOrderAmountForToday() {
		Double todayCounts = 0.000;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(new Date());
		String hql = "from OrderInfo o where o.orderTime='"+today+"'";
		List<OrderInfo> orders = this.find(hql);      
		for(OrderInfo order : orders){             //������������ж���
			todayCounts += order.getAllPrice();
		}
		return todayCounts;
	}


	public Double statisticsOrderAmountForYear() {
		Double yearCounts = 0.000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String hql = "from OrderInfo o where substring(o.orderTime,0,5) ='"+sdf+"'";
		List<OrderInfo> orders = this.find(hql);      
		for(OrderInfo order : orders){             //������������ж���
			yearCounts += order.getAllPrice();
		}
		return yearCounts;
	}
	/*----------------------ͳ�ƶ����ܶ� ����------------------------------*/

	public Double statisticsBackSingleAmountForMonth() {
		return null;
	}


	public Double statisticsBackSingleAmountForToday() {
		// TODO Auto-generated method stub
		return null;
	}


	public Double statisticsBackSingleAmountForYear() {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer statisticsBackSingleForMonth() {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer statisticsBackSingleForToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //��ʽ��ʱ��
		String today = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+today+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}


	public Integer statisticsBackSingleForYear() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
