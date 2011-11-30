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
 * SaleTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "saleTable", schema = "dbo", catalog = "lampForSale")
public class SaleTable implements java.io.Serializable {

	// Fields

	private Integer saleId;
	private OrderInfo orderInfo;
	private String annual;
	private Double janSaleroom;
	private Double febSaleroom;
	private Double marSaleroom;
	private Double aprilSaleroom;
	private Double maySaleroom;
	private Double juneSaleroom;
	private Double julySaleroom;
	private Double augustSaleroom;
	private Double septemberSaleroom;
	private Double octoberSaleroom;
	private Double novSaleroom;
	private Double decSaleroom;
	private Double yearSaleroom;

	// Constructors

	/** default constructor */
	public SaleTable() {
	}

	/** full constructor */
	public SaleTable(OrderInfo orderInfo, String annual, Double janSaleroom,
			Double febSaleroom, Double marSaleroom, Double aprilSaleroom,
			Double maySaleroom, Double juneSaleroom, Double julySaleroom,
			Double augustSaleroom, Double septemberSaleroom,
			Double octoberSaleroom, Double novSaleroom, Double decSaleroom,
			Double yearSaleroom) {
		this.orderInfo = orderInfo;
		this.annual = annual;
		this.janSaleroom = janSaleroom;
		this.febSaleroom = febSaleroom;
		this.marSaleroom = marSaleroom;
		this.aprilSaleroom = aprilSaleroom;
		this.maySaleroom = maySaleroom;
		this.juneSaleroom = juneSaleroom;
		this.julySaleroom = julySaleroom;
		this.augustSaleroom = augustSaleroom;
		this.septemberSaleroom = septemberSaleroom;
		this.octoberSaleroom = octoberSaleroom;
		this.novSaleroom = novSaleroom;
		this.decSaleroom = decSaleroom;
		this.yearSaleroom = yearSaleroom;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "saleId", unique = true, nullable = false)
	public Integer getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	public OrderInfo getOrderInfo() {
		return this.orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Column(name = "annual", length = 50)
	public String getAnnual() {
		return this.annual;
	}

	public void setAnnual(String annual) {
		this.annual = annual;
	}

	@Column(name = "janSaleroom", precision = 15, scale = 0)
	public Double getJanSaleroom() {
		return this.janSaleroom;
	}

	public void setJanSaleroom(Double janSaleroom) {
		this.janSaleroom = janSaleroom;
	}

	@Column(name = "febSaleroom", precision = 15, scale = 0)
	public Double getFebSaleroom() {
		return this.febSaleroom;
	}

	public void setFebSaleroom(Double febSaleroom) {
		this.febSaleroom = febSaleroom;
	}

	@Column(name = "marSaleroom", precision = 15, scale = 0)
	public Double getMarSaleroom() {
		return this.marSaleroom;
	}

	public void setMarSaleroom(Double marSaleroom) {
		this.marSaleroom = marSaleroom;
	}

	@Column(name = "aprilSaleroom", precision = 15, scale = 0)
	public Double getAprilSaleroom() {
		return this.aprilSaleroom;
	}

	public void setAprilSaleroom(Double aprilSaleroom) {
		this.aprilSaleroom = aprilSaleroom;
	}

	@Column(name = "maySaleroom", precision = 15, scale = 0)
	public Double getMaySaleroom() {
		return this.maySaleroom;
	}

	public void setMaySaleroom(Double maySaleroom) {
		this.maySaleroom = maySaleroom;
	}

	@Column(name = "juneSaleroom", precision = 15, scale = 0)
	public Double getJuneSaleroom() {
		return this.juneSaleroom;
	}

	public void setJuneSaleroom(Double juneSaleroom) {
		this.juneSaleroom = juneSaleroom;
	}

	@Column(name = "julySaleroom", precision = 15, scale = 0)
	public Double getJulySaleroom() {
		return this.julySaleroom;
	}

	public void setJulySaleroom(Double julySaleroom) {
		this.julySaleroom = julySaleroom;
	}

	@Column(name = "augustSaleroom", precision = 15, scale = 0)
	public Double getAugustSaleroom() {
		return this.augustSaleroom;
	}

	public void setAugustSaleroom(Double augustSaleroom) {
		this.augustSaleroom = augustSaleroom;
	}

	@Column(name = "septemberSaleroom", precision = 15, scale = 0)
	public Double getSeptemberSaleroom() {
		return this.septemberSaleroom;
	}

	public void setSeptemberSaleroom(Double septemberSaleroom) {
		this.septemberSaleroom = septemberSaleroom;
	}

	@Column(name = "octoberSaleroom", precision = 15, scale = 0)
	public Double getOctoberSaleroom() {
		return this.octoberSaleroom;
	}

	public void setOctoberSaleroom(Double octoberSaleroom) {
		this.octoberSaleroom = octoberSaleroom;
	}

	@Column(name = "novSaleroom", precision = 15, scale = 0)
	public Double getNovSaleroom() {
		return this.novSaleroom;
	}

	public void setNovSaleroom(Double novSaleroom) {
		this.novSaleroom = novSaleroom;
	}

	@Column(name = "decSaleroom", precision = 15, scale = 0)
	public Double getDecSaleroom() {
		return this.decSaleroom;
	}

	public void setDecSaleroom(Double decSaleroom) {
		this.decSaleroom = decSaleroom;
	}

	@Column(name = "yearSaleroom", precision = 15, scale = 0)
	public Double getYearSaleroom() {
		return this.yearSaleroom;
	}

	public void setYearSaleroom(Double yearSaleroom) {
		this.yearSaleroom = yearSaleroom;
	}

}