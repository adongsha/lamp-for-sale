package com.lamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * SaledLamp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "saledLamp", schema = "dbo", catalog = "lampForSale")
public class SaledLamp implements java.io.Serializable {

	// Fields

	private Long saledLampId;
	private OrderInfo orderInfoByOrderId;
	private OrderInfo orderInfoByLampId;
	private Integer count;
	private Integer orderNumber;
	private Long orderId;

	// Constructors

	/** default constructor */
	public SaledLamp() {
	}

	/** minimal constructor */
	public SaledLamp(OrderInfo orderInfoByOrderId) {
		this.orderInfoByOrderId = orderInfoByOrderId;
	}

	/** full constructor */
	public SaledLamp(OrderInfo orderInfoByOrderId, OrderInfo orderInfoByLampId,
			Integer count, Integer orderNumber, Long orderId) {
		this.orderInfoByOrderId = orderInfoByOrderId;
		this.orderInfoByLampId = orderInfoByLampId;
		this.count = count;
		this.orderNumber = orderNumber;
		this.orderId = orderId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "saledLampId", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getSaledLampId() {
		return this.saledLampId;
	}

	public void setSaledLampId(Long saledLampId) {
		this.saledLampId = saledLampId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public OrderInfo getOrderInfoByOrderId() {
		return this.orderInfoByOrderId;
	}

	public void setOrderInfoByOrderId(OrderInfo orderInfoByOrderId) {
		this.orderInfoByOrderId = orderInfoByOrderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lampId")
	public OrderInfo getOrderInfoByLampId() {
		return this.orderInfoByLampId;
	}

	public void setOrderInfoByLampId(OrderInfo orderInfoByLampId) {
		this.orderInfoByLampId = orderInfoByLampId;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "orderNumber")
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "orderId", precision = 18, scale = 0)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}