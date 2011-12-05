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
		String hql = "from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"'";
		//List<OrderInfo> orders = this.getSession().createSQLQuery(hql).list();  
		List<OrderInfo> orders = this.find(hql);
		for(OrderInfo order : orders){             //�����µ����ж���
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

	
	
	/*----------------------ͳ���˵��ܶ�-----------------------------------*/
	public Double statisticsBackSingleAmountForMonth() {
		Double monthCounts = 0.000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String month = sdf.format(new Date());
		//ͨ����ȡ����ʱ���������ͳ���¶�����
		String hql = "from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"' and o.isBackSingle=1";
		//List<OrderInfo> orders = this.getSession().createSQLQuery(hql).list();  
		List<OrderInfo> orders = this.find(hql);
		for(OrderInfo order : orders){             //�����µ����ж���
			monthCounts += order.getAllPrice();
		}
		return monthCounts;
	}


	public Double statisticsBackSingleAmountForToday() {
		Double todayCounts = 0.000;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(new Date());
		String hql = "from OrderInfo o where o.orderTime='"+today+"' and o.isBackSingle=1";
		List<OrderInfo> orders = this.find(hql);      
		for(OrderInfo order : orders){             //������������ж���
			todayCounts += order.getAllPrice();
		}
		return todayCounts;
	}


	public Double statisticsBackSingleAmountForYear() {
		Double yearCounts = 0.000;
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		String hql = "from OrderInfo o where substring(o.orderTime,0,5) ='"+year+"' and o.isBackSingle=1";
		List<OrderInfo> orders = this.find(hql);      
		for(OrderInfo order : orders){             //������������ж���
			yearCounts += order.getAllPrice();
		}
		return yearCounts;
	}
	/*----------------------ͳ���˵��ܶ����-----------------------------------*/
	

    /*----------------------ͳ���˵���---------------------------------------*/
	public Integer statisticsBackSingleForMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");    //��ʽ��ʱ��
		String month = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+month+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}


	public Integer statisticsBackSingleForToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //��ʽ��ʱ��
		String today = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+today+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}


	public Integer statisticsBackSingleForYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");    //��ʽ��ʱ��
		String year = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+year+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}
	 /*----------------------ͳ���˵��� ����---------------------------------------*/
	

}
