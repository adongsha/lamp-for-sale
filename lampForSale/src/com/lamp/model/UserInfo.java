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
	private Integer power;
	private Set<OrderInfo> orderInfos = new HashSet<OrderInfo>(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userName, String password, Integer power) {
		this.userName = userName;
		this.password = password;
		this.power = power;
	}

	/** full constructor */
	public UserInfo(String userName, String password, String userPicture,
			Integer power, Set<OrderInfo> orderInfos) {
		this.userName = userName;
		this.password = password;
		this.userPicture = userPicture;
		this.power = power;
		this.orderInfos = orderInfos;
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

	@Column(name = "password", nullable = false, length = 50)
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

	@Column(name = "power", nullable = false)
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

}