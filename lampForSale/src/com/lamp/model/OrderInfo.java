package com.lamp.model;

import java.sql.Timestamp;
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
import javax.persistence.Table;

/**
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderInfo", schema = "dbo", catalog = "lampForSale")
public class OrderInfo implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private UserInfo userInfo;
	private String orderPerson;
	private String orderEmail;
	private String orderCompany;
	private String orderAddress;
	private String orderPhone;
	private String message;
	private String code;
	private String orderTime;
	private Double allPrice;
	private Integer isBackSingle;    //1表示退单的...null表示没有
	private Set<SaleTable> saleTables = new HashSet<SaleTable>(0);
	private Set<OrderStatus> orderStatuses = new HashSet<OrderStatus>(0);
	private Set<OrderGoods> orderGoodses = new HashSet<OrderGoods>(0);

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/** full constructor */
	public OrderInfo(UserInfo userInfo, String orderPerson, String orderEmail,
			String orderCompany, String orderAddress, String orderPhone,
			String message, String code, String orderTime, Double allPrice,Integer isBackSingle,
			Set<SaleTable> saleTables, Set<OrderStatus> orderStatuses,
			Set<OrderGoods> orderGoodses) {
		this.userInfo = userInfo;
		this.orderPerson = orderPerson;
		this.orderEmail = orderEmail;
		this.orderCompany = orderCompany;
		this.orderAddress = orderAddress;
		this.orderPhone = orderPhone;
		this.message = message;
		this.code = code;
		this.orderTime = orderTime;
		this.allPrice = allPrice;
		this.saleTables = saleTables;
		this.orderStatuses = orderStatuses;
		this.orderGoodses = orderGoodses;
		this.isBackSingle = isBackSingle;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "orderId", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
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

	@Column(name = "isBackSingle")
	public Integer getIsBackSingle() {
		return isBackSingle;
	}

	public void setIsBackSingle(Integer isBackSingle) {
		this.isBackSingle = isBackSingle;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	@Column(name = "orderCompany", length = 50)
	public String getOrderCompany() {
		return this.orderCompany;
	}

	public void setOrderCompany(String orderCompany) {
		this.orderCompany = orderCompany;
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

	@Column(name = "code", length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "orderTime", length = 23)
	public String getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	@Column(name = "allPrice")
	public Double getAllPrice() {
		return this.allPrice;
	}

	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderInfo")
	public Set<SaleTable> getSaleTables() {
		return this.saleTables;
	}

	public void setSaleTables(Set<SaleTable> saleTables) {
		this.saleTables = saleTables;
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

}