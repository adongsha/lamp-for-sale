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
 * CartShop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cartShop", schema = "dbo", catalog = "lampForSale")
public class CartShop implements java.io.Serializable {

	// Fields

	private Long cartId;
	private Lamp lamp;
	private OrderInfo orderInfo;
	private Long orderId;
	private Integer count;
	private Double perPrice;
	private Double totalPrice;

	// Constructors

	/** default constructor */
	public CartShop() {
	}

	/** minimal constructor */
	public CartShop(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	/** full constructor */
	public CartShop(Lamp lamp, OrderInfo orderInfo, Long orderId,
			Integer count, Double perPrice, Double totalPrice) {
		this.lamp = lamp;
		this.orderInfo = orderInfo;
		this.orderId = orderId;
		this.count = count;
		this.perPrice = perPrice;
		this.totalPrice = totalPrice;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cartId", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getCartId() {
		return this.cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lampId")
	public Lamp getLamp() {
		return this.lamp;
	}

	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Column(name = "orderId", precision = 18, scale = 0)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "perPrice", precision = 15, scale = 0)
	public Double getPerPrice() {
		return this.perPrice;
	}

	public void setPerPrice(Double perPrice) {
		this.perPrice = perPrice;
	}

	@Column(name = "totalPrice", precision = 15, scale = 0)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}