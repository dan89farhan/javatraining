package com.newpractical.application.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	
	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("price")
	private int productPrice;
	
	@JsonProperty("brand")
	private String productBrand;
	
	@JsonProperty("category")
	private String productCategory;
	
	@JsonProperty("date")
	private Date mfgDate;
	
	@JsonProperty("type")
	private String productType;
	
	@JsonProperty("description")
	private String productDescription;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Date getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public Product(String productName, int productPrice, String productBrand,
			String productCategory, Date mfgDate, String productType,
			String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productBrand = productBrand;
		this.productCategory = productCategory;
		this.mfgDate = mfgDate;
		this.productType = productType;
		this.productDescription = productDescription;
	}
	
	public Product(){
		
	}
	
	@Override
	public String toString() {
		return "ProductPojo [productName=" + productName + ", productPrice="
				+ productPrice + ", productBrand=" + productBrand
				+ ", productCategory=" + productCategory + ", mfgDate="
				+ mfgDate + ", productType=" + productType
				+ ", productDescription=" + productDescription + "]";
	}
	
	
	
}
