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
    
	/*---------------------统计 订单 数----------------------------*/
	public Integer statisticsOrderForMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		//通过截取订单时间的年月来统计月订单数
		String month = sdf.format(new Date());
		System.out.println(month);
		String hql = "select * from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"'";
		return this.getSession().createSQLQuery(hql).list().size();
	}

	public Integer statisticsOrderForToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化时间
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
	/*---------------------统计 订单 数 结束----------------------------*/

	
	
	/*----------------------统计订单总额------------------------------*/
	public Double statisticsOrderAmountForMonth() {
		Double monthCounts = 0.000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String month = sdf.format(new Date());
		//通过截取订单时间的年月来统计月订单数
		String hql = "from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"'";
		//List<OrderInfo> orders = this.getSession().createSQLQuery(hql).list();  
		List<OrderInfo> orders = this.find(hql);
		for(OrderInfo order : orders){             //遍历月的所有订单
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
		for(OrderInfo order : orders){             //遍历今天的所有订单
			todayCounts += order.getAllPrice();
		}
		return todayCounts;
	}


	public Double statisticsOrderAmountForYear() {
		Double yearCounts = 0.000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String hql = "from OrderInfo o where substring(o.orderTime,0,5) ='"+sdf+"'";
		List<OrderInfo> orders = this.find(hql);      
		for(OrderInfo order : orders){             //遍历今天的所有订单
			yearCounts += order.getAllPrice();
		}
		return yearCounts;
	}
	/*----------------------统计订单总额 结束------------------------------*/

	
	
	/*----------------------统计退单总额-----------------------------------*/
	public Double statisticsBackSingleAmountForMonth() {
		Double monthCounts = 0.000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String month = sdf.format(new Date());
		//通过截取订单时间的年月来统计月订单数
		String hql = "from OrderInfo o where substring(o.orderTime,0,8) ='"+month+"' and o.isBackSingle=1";
		//List<OrderInfo> orders = this.getSession().createSQLQuery(hql).list();  
		List<OrderInfo> orders = this.find(hql);
		for(OrderInfo order : orders){             //遍历月的所有订单
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
		for(OrderInfo order : orders){             //遍历今天的所有订单
			todayCounts += order.getAllPrice();
		}
		return todayCounts;
	}


	public Double statisticsBackSingleAmountForYear() {
		Double yearCounts = 0.000;
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		String hql = "from OrderInfo o where substring(o.orderTime,0,5) ='"+year+"' and o.isBackSingle=1";
		List<OrderInfo> orders = this.find(hql);      
		for(OrderInfo order : orders){             //遍历今天的所有订单
			yearCounts += order.getAllPrice();
		}
		return yearCounts;
	}
	/*----------------------统计退单总额结束-----------------------------------*/
	

    /*----------------------统计退单数---------------------------------------*/
	public Integer statisticsBackSingleForMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");    //格式化时间
		String month = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+month+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}


	public Integer statisticsBackSingleForToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化时间
		String today = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+today+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}


	public Integer statisticsBackSingleForYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");    //格式化时间
		String year = sdf.format(new Date());                        
		String hql = "from OrderInfo o where o.orderTime='"+year+"' and o.isBackSingle=1";
		return this.find(hql).size();
	}
	 /*----------------------统计退单数 结束---------------------------------------*/
	

}
