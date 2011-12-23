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
 * Lamp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lamp", schema = "dbo", catalog = "lampForSale")
public class Lamp implements java.io.Serializable {

	// Fields

	private Integer lampId;
	private String lampName;
	private String type;
	private String lampDescription;
	private Double price;
	private String origin;
	private String isDiscount;
	private String size;
	private String material;
	private String process;
	private String weight;
	private String prictureImage1;
	private String prictureImage2;
	private String prictureImage3;
	private String prictureImage4;
	private String evaluationCount;
	private Integer saleEvMouth;
	private String isbn;
	private Set<CartShop> cartShops = new HashSet<CartShop>(0);
	private Set<Forum> forums = new HashSet<Forum>(0);

	// Constructors

	/** default constructor */
	public Lamp() {
	}

	/** minimal constructor */
	public Lamp(String lampName) {
		this.lampName = lampName;
	}

	/** full constructor */
	public Lamp(String lampName, String type, String lampDescription,
			Double price, String origin, String isDiscount, String size,
			String material, String process, String weight,
			String prictureImage1, String prictureImage2,
			String prictureImage3, String prictureImage4,
			String evaluationCount, Integer saleEvMouth, String isbn,
			Set<CartShop> cartShops, Set<Forum> forums) {
		this.lampName = lampName;
		this.type = type;
		this.lampDescription = lampDescription;
		this.price = price;
		this.origin = origin;
		this.isDiscount = isDiscount;
		this.size = size;
		this.material = material;
		this.process = process;
		this.weight = weight;
		this.prictureImage1 = prictureImage1;
		this.prictureImage2 = prictureImage2;
		this.prictureImage3 = prictureImage3;
		this.prictureImage4 = prictureImage4;
		this.evaluationCount = evaluationCount;
		this.saleEvMouth = saleEvMouth;
		this.isbn = isbn;
		this.cartShops = cartShops;
		this.forums = forums;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "lampId", unique = true, nullable = false)
	public Integer getLampId() {
		return this.lampId;
	}

	public void setLampId(Integer lampId) {
		this.lampId = lampId;
	}

	@Column(name = "lampName", nullable = false, length = 50)
	public String getLampName() {
		return this.lampName;
	}

	public void setLampName(String lampName) {
		this.lampName = lampName;
	}

	@Column(name = "type", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "lampDescription", length = 550)
	public String getLampDescription() {
		return this.lampDescription;
	}

	public void setLampDescription(String lampDescription) {
		this.lampDescription = lampDescription;
	}

	@Column(name = "price", precision = 15, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "origin", length = 50)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Column(name = "isDiscount", length = 50)
	public String getIsDiscount() {
		return this.isDiscount;
	}

	public void setIsDiscount(String isDiscount) {
		this.isDiscount = isDiscount;
	}

	@Column(name = "size", length = 50)
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "material", length = 50)
	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(name = "process", length = 50)
	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	@Column(name = "weight", length = 50)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "prictureImage1", length = 200)
	public String getPrictureImage1() {
		return this.prictureImage1;
	}

	public void setPrictureImage1(String prictureImage1) {
		this.prictureImage1 = prictureImage1;
	}

	@Column(name = "prictureImage2", length = 200)
	public String getPrictureImage2() {
		return this.prictureImage2;
	}

	public void setPrictureImage2(String prictureImage2) {
		this.prictureImage2 = prictureImage2;
	}

	@Column(name = "prictureImage3", length = 200)
	public String getPrictureImage3() {
		return this.prictureImage3;
	}

	public void setPrictureImage3(String prictureImage3) {
		this.prictureImage3 = prictureImage3;
	}

	@Column(name = "prictureImage4", length = 200)
	public String getPrictureImage4() {
		return this.prictureImage4;
	}

	public void setPrictureImage4(String prictureImage4) {
		this.prictureImage4 = prictureImage4;
	}

	@Column(name = "evaluationCount", length = 50)
	public String getEvaluationCount() {
		return this.evaluationCount;
	}

	public void setEvaluationCount(String evaluationCount) {
		this.evaluationCount = evaluationCount;
	}

	@Column(name = "saleEvMouth")
	public Integer getSaleEvMouth() {
		return this.saleEvMouth;
	}

	public void setSaleEvMouth(Integer saleEvMouth) {
		this.saleEvMouth = saleEvMouth;
	}

	@Column(name = "isbn", length = 50)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lamp")
	public Set<CartShop> getCartShops() {
		return this.cartShops;
	}

	public void setCartShops(Set<CartShop> cartShops) {
		this.cartShops = cartShops;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lamp")
	public Set<Forum> getForums() {
		return this.forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

}