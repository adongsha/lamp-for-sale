package com.lamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderStatus", schema = "dbo", catalog = "lampForSale")
public class OrderStatus implements java.io.Serializable {

	// Fields

	private Integer orderStatusId;
	private OrderInfo orderInfo;
	private Integer monthReturnNum;
	private Double monthReturnSum;
	private Integer yearReturnNum;
	private Double yearReturnSum;
	private Integer monthTotalOrder;
	private Double monthTotalSum;
	private Integer yearTotalOrder;
	private Double yearTotalSum;

	// Constructors

	/** default constructor */
	public OrderStatus() {
	}

	/** minimal constructor */
	public OrderStatus(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	/** full constructor */
	public OrderStatus(OrderInfo orderInfo, Integer monthReturnNum,
			Double monthReturnSum, Integer yearReturnNum, Double yearReturnSum,
			Integer monthTotalOrder, Double monthTotalSum,
			Integer yearTotalOrder, Double yearTotalSum) {
		this.orderInfo = orderInfo;
		this.monthReturnNum = monthReturnNum;
		this.monthReturnSum = monthReturnSum;
		this.yearReturnNum = yearReturnNum;
		this.yearReturnSum = yearReturnSum;
		this.monthTotalOrder = monthTotalOrder;
		this.monthTotalSum = monthTotalSum;
		this.yearTotalOrder = yearTotalOrder;
		this.yearTotalSum = yearTotalSum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "orderStatusId", unique = true, nullable = false)
	public Integer getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", nullable = false)
	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Column(name = "monthReturnNum")
	public Integer getMonthReturnNum() {
		return this.monthReturnNum;
	}

	public void setMonthReturnNum(Integer monthReturnNum) {
		this.monthReturnNum = monthReturnNum;
	}

	@Column(name = "monthReturnSum", precision = 15, scale = 0)
	public Double getMonthReturnSum() {
		return this.monthReturnSum;
	}

	public void setMonthReturnSum(Double monthReturnSum) {
		this.monthReturnSum = monthReturnSum;
	}

	@Column(name = "yearReturnNum")
	public Integer getYearReturnNum() {
		return this.yearReturnNum;
	}

	public void setYearReturnNum(Integer yearReturnNum) {
		this.yearReturnNum = yearReturnNum;
	}

	@Column(name = "yearReturnSum", precision = 15, scale = 0)
	public Double getYearReturnSum() {
		return this.yearReturnSum;
	}

	public void setYearReturnSum(Double yearReturnSum) {
		this.yearReturnSum = yearReturnSum;
	}

	@Column(name = "monthTotalOrder")
	public Integer getMonthTotalOrder() {
		return this.monthTotalOrder;
	}

	public void setMonthTotalOrder(Integer monthTotalOrder) {
		this.monthTotalOrder = monthTotalOrder;
	}

	@Column(name = "monthTotalSum", precision = 15, scale = 0)
	public Double getMonthTotalSum() {
		return this.monthTotalSum;
	}

	public void setMonthTotalSum(Double monthTotalSum) {
		this.monthTotalSum = monthTotalSum;
	}

	@Column(name = "yearTotalOrder")
	public Integer getYearTotalOrder() {
		return this.yearTotalOrder;
	}

	public void setYearTotalOrder(Integer yearTotalOrder) {
		this.yearTotalOrder = yearTotalOrder;
	}

	@Column(name = "yearTotalSum", precision = 15, scale = 0)
	public Double getYearTotalSum() {
		return this.yearTotalSum;
	}

	public void setYearTotalSum(Double yearTotalSum) {
		this.yearTotalSum = yearTotalSum;
	}

}