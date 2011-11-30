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
 * OrderGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderGoods", schema = "dbo", catalog = "lampForSale")
public class OrderGoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private OrderInfo orderInfo;
	private Integer lampId;
	private Integer counts;
	private String totalPrice;

	// Constructors

	/** default constructor */
	public OrderGoods() {
	}

	/** full constructor */
	public OrderGoods(OrderInfo orderInfo, Integer lampId, Integer counts,
			String totalPrice) {
		this.orderInfo = orderInfo;
		this.lampId = lampId;
		this.counts = counts;
		this.totalPrice = totalPrice;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "goodsId", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Column(name = "lampId")
	public Integer getLampId() {
		return this.lampId;
	}

	public void setLampId(Integer lampId) {
		this.lampId = lampId;
	}

	@Column(name = "counts")
	public Integer getCounts() {
		return this.counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	@Column(name = "totalPrice", length = 50)
	public String getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

}