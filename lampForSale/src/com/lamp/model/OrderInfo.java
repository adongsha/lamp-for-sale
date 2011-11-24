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
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderInfo", schema = "dbo", catalog = "lampForSale")
public class OrderInfo implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private UserInfo userInfo;
	private String name;
	private String email;
	private String company;
	private String address;
	private String phone;
	private String message;
	private String code;

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/** full constructor */
	public OrderInfo(UserInfo userInfo, String name, String email,
			String company, String address, String phone, String message,
			String code) {
		this.userInfo = userInfo;
		this.name = name;
		this.email = email;
		this.company = company;
		this.address = address;
		this.phone = phone;
		this.message = message;
		this.code = code;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "company", length = 50)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "message", length = 550)
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

}