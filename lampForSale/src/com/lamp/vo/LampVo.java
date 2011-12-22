package com.lamp.vo;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class LampVo {
	private Integer lampId;
	private String isbn;
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

	public Integer getLampId() {
		return lampId;
	}

	public void setLampId(Integer lampId) {
		this.lampId = lampId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLampName() {
		return lampName;
	}

	public void setLampName(String lampName) {
		this.lampName = lampName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLampDescription() {
		return lampDescription;
	}

	public void setLampDescription(String lampDescription) {
		this.lampDescription = lampDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(String isDiscount) {
		this.isDiscount = isDiscount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPrictureImage1() {
		return prictureImage1;
	}

	public void setPrictureImage1(String prictureImage1) {
		this.prictureImage1 = prictureImage1;
	}

	public String getPrictureImage2() {
		return prictureImage2;
	}

	public void setPrictureImage2(String prictureImage2) {
		this.prictureImage2 = prictureImage2;
	}

	public String getPrictureImage3() {
		return prictureImage3;
	}

	public void setPrictureImage3(String prictureImage3) {
		this.prictureImage3 = prictureImage3;
	}

	public String getPrictureImage4() {
		return prictureImage4;
	}

	public void setPrictureImage4(String prictureImage4) {
		this.prictureImage4 = prictureImage4;
	}

	public String getEvaluationCount() {
		return evaluationCount;
	}

	public void setEvaluationCount(String evaluationCount) {
		this.evaluationCount = evaluationCount;
	}

	public Integer getSaleEvMouth() {
		return saleEvMouth;
	}

	public void setSaleEvMouth(Integer saleEvMouth) {
		this.saleEvMouth = saleEvMouth;
	}
}
