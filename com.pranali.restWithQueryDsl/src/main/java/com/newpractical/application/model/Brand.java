package com.newpractical.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
	@Id
	private int brandId;
	private String brandName;
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Brand(int brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "BrandPojo [brandId=" + brandId + ", brandName=" + brandName
				+ "]";
	}
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}
	
	

}
