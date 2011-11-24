package com.lamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LampShop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lampShop", schema = "dbo", catalog = "lampForSale")
public class LampShop implements java.io.Serializable {

	// Fields

	private Integer lampShopId;
	private String shopAddr;
	private String shopName;
	private String shopDescription;

	// Constructors

	/** default constructor */
	public LampShop() {
	}

	/** full constructor */
	public LampShop(String shopAddr, String shopName, String shopDescription) {
		this.shopAddr = shopAddr;
		this.shopName = shopName;
		this.shopDescription = shopDescription;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "lampShopId", unique = true, nullable = false)
	public Integer getLampShopId() {
		return this.lampShopId;
	}

	public void setLampShopId(Integer lampShopId) {
		this.lampShopId = lampShopId;
	}

	@Column(name = "shopAddr", length = 50)
	public String getShopAddr() {
		return this.shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	@Column(name = "shopName", length = 50)
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "shopDescription", length = 50)
	public String getShopDescription() {
		return this.shopDescription;
	}

	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}

}