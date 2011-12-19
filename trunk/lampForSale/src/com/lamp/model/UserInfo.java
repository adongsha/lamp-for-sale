package com.lamp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userInfo", schema = "dbo", catalog = "lampForSale")
public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private String userPicture;
	private String email;
	private String phone;
	private String company;
	private String address;
	private Integer power;
	private Set<OrderInfo> orderInfos = new HashSet<OrderInfo>(0);
	private Set<Forum> forums = new HashSet<Forum>(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userName) {
		this.userName = userName;
	}

	/** full constructor */
	public UserInfo(String userName, String password, String userPicture,
			String email, String phone, String company, String address,
			Integer power, Set<OrderInfo> orderInfos, Set<Forum> forums) {
		this.userName = userName;
		this.password = password;
		this.userPicture = userPicture;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.address = address;
		this.power = power;
		this.orderInfos = orderInfos;
		this.forums = forums;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "userName", nullable = false, length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "userPicture", length = 50)
	public String getUserPicture() {
		return this.userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Column(name = "power")
	public Integer getPower() {
		return this.power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userInfo")
	public Set<OrderInfo> getOrderInfos() {
		return this.orderInfos;
	}

	public void setOrderInfos(Set<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userInfo")
	public Set<Forum> getForums() {
		return this.forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

}