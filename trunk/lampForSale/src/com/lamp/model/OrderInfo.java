package com.lamp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderInfo", schema = "dbo", catalog = "lampForSale")
public class OrderInfo implements java.io.Serializable {

	// Fields

	private Long orderId;
	private UserInfo userInfo;
	private String orderPerson;
	private String orderEmail;
	private String orderAddress;
	private String orderPhone;
	private String message;
	private String orderTime;
	private Double allPrice;
	private Integer isBackSingle;
	private Integer orderStatus;
	private Set<SaleTable> saleTables = new HashSet<SaleTable>(0);
	private Set<SaledLamp> saledLampsForLampId = new HashSet<SaledLamp>(0);
	private Set<OrderStatus> orderStatuses = new HashSet<OrderStatus>(0);
	private Set<OrderGoods> orderGoodses = new HashSet<OrderGoods>(0);
	private SaledLamp saledLampByOrderId;
	private CartShop cartShop;

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** full constructor */
	public OrderInfo(UserInfo userInfo, String orderPerson, String orderEmail,
			String orderAddress, String orderPhone, String message,
			String orderTime, Double allPrice, Integer isBackSingle,
			Integer orderStatus, Set<SaleTable> saleTables,
			Set<SaledLamp> saledLampsForLampId, Set<OrderStatus> orderStatuses,
			Set<OrderGoods> orderGoodses, SaledLamp saledLampByOrderId,
			CartShop cartShop) {
		this.userInfo = userInfo;
		this.orderPerson = orderPerson;
		this.orderEmail = orderEmail;
		this.orderAddress = orderAddress;
		this.orderPhone = orderPhone;
		this.message = message;
		this.orderTime = orderTime;
		this.allPrice = allPrice;
		this.isBackSingle = isBackSingle;
		this.orderStatus = orderStatus;
		this.saleTables = saleTables;
		this.saledLampsForLampId = saledLampsForLampId;
		this.orderStatuses = orderStatuses;
		this.orderGoodses = orderGoodses;
		this.saledLampByOrderId = saledLampByOrderId;
		this.cartShop = cartShop;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "orderId", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "orderPerson", length = 50)
	public String getOrderPerson() {
		return this.orderPerson;
	}

	public void setOrderPerson(String orderPerson) {
		this.orderPerson = orderPerson;
	}

	@Column(name = "orderEmail", length = 50)
	public String getOrderEmail() {
		return this.orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	@Column(name = "orderAddress", length = 150)
	public String getOrderAddress() {
		return this.orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	@Column(name = "orderPhone", length = 50)
	public String getOrderPhone() {
		return this.orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	@Column(name = "message", length = 250)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "orderTime", length = 100)
	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	@Column(name = "allPrice", precision = 15, scale = 0)
	public Double getAllPrice() {
		return this.allPrice;
	}

	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}

	@Column(name = "isBackSingle")
	public Integer getIsBackSingle() {
		return this.isBackSingle;
	}

	public void setIsBackSingle(Integer isBackSingle) {
		this.isBackSingle = isBackSingle;
	}

	@Column(name = "orderStatus")
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderInfo")
	public Set<SaleTable> getSaleTables() {
		return this.saleTables;
	}

	public void setSaleTables(Set<SaleTable> saleTables) {
		this.saleTables = saleTables;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderInfoByLampId")
	public Set<SaledLamp> getSaledLampsForLampId() {
		return this.saledLampsForLampId;
	}

	public void setSaledLampsForLampId(Set<SaledLamp> saledLampsForLampId) {
		this.saledLampsForLampId = saledLampsForLampId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderInfo")
	public Set<OrderStatus> getOrderStatuses() {
		return this.orderStatuses;
	}

	public void setOrderStatuses(Set<OrderStatus> orderStatuses) {
		this.orderStatuses = orderStatuses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderInfo")
	public Set<OrderGoods> getOrderGoodses() {
		return this.orderGoodses;
	}

	public void setOrderGoodses(Set<OrderGoods> orderGoodses) {
		this.orderGoodses = orderGoodses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "orderInfoByOrderId")
	public SaledLamp getSaledLampByOrderId() {
		return this.saledLampByOrderId;
	}

	public void setSaledLampByOrderId(SaledLamp saledLampByOrderId) {
		this.saledLampByOrderId = saledLampByOrderId;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "orderInfo")
	public CartShop getCartShop() {
		return this.cartShop;
	}

	public void setCartShop(CartShop cartShop) {
		this.cartShop = cartShop;
	}

}