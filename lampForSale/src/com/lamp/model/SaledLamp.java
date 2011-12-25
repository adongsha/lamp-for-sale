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
 * SaledLamp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "saledLamp", schema = "dbo", catalog = "lampForSale")
public class SaledLamp implements java.io.Serializable {

	// Fields

	private Integer saledLampId;
	private Lamp lamp;
	private OrderInfo orderInfo;
	private Integer count;

	// Constructors

	/** default constructor */
	public SaledLamp() {
	}

	/** full constructor */
	public SaledLamp(Lamp lamp, OrderInfo orderInfo, Integer count) {
		this.lamp = lamp;
		this.orderInfo = orderInfo;
		this.count = count;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "saledLampId", unique = true, nullable = false)
	public Integer getSaledLampId() {
		return this.saledLampId;
	}

	public void setSaledLampId(Integer saledLampId) {
		this.saledLampId = saledLampId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lampId")
	public Lamp getLamp() {
		return this.lamp;
	}

	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}