package com.pranali.restWithQueryDsl.com.pranali.restWithQueryDsl;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryPojo {

	@Id
	private int categoryId;
	private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CategoryPojo(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public CategoryPojo() {
		// TODO Auto-generated constructor stub
	}
	
}
