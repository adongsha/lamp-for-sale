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
	private Integer id;
	private String lampName;
	private String type;
	private String lampDescription;
	private Double price;
	private String color;
	private Double freight;
	private Integer evaluationCount;
	private Integer saleNum;
	private Double discount;
	private String size;
	private String material;
	private String process;
	private Double weight;
	private String picture;
	private Set<Forum> forums = new HashSet<Forum>(0);

	// Constructors

	/** default constructor */
	public Lamp() {
	}

	/** minimal constructor */
	public Lamp(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Lamp(Integer id, String lampName, String type,
			String lampDescription, Double price, String color, Double freight,
			Integer evaluationCount, Integer saleNum, Double discount,
			String size, String material, String process, Double weight,
			String picture, Set<Forum> forums) {
		this.id = id;
		this.lampName = lampName;
		this.type = type;
		this.lampDescription = lampDescription;
		this.price = price;
		this.color = color;
		this.freight = freight;
		this.evaluationCount = evaluationCount;
		this.saleNum = saleNum;
		this.discount = discount;
		this.size = size;
		this.material = material;
		this.process = process;
		this.weight = weight;
		this.picture = picture;
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

	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "lampName", length = 50)
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

	@Column(name = "color", length = 50)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "freight", precision = 15, scale = 0)
	public Double getFreight() {
		return this.freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	@Column(name = "evaluationCount")
	public Integer getEvaluationCount() {
		return this.evaluationCount;
	}

	public void setEvaluationCount(Integer evaluationCount) {
		this.evaluationCount = evaluationCount;
	}

	@Column(name = "saleNum")
	public Integer getSaleNum() {
		return this.saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	@Column(name = "discount", precision = 15, scale = 0)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
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

	@Column(name = "weight", precision = 15, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "picture", length = 50)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lamp")
	public Set<Forum> getForums() {
		return this.forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

}