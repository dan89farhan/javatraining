package com.newpractical.application.Implementation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.data.annotation.Transient;

@Entity
public class CategoryStructure {
	
	@Id
	private int categoryId;
	private String categoryName;
	private int parentId;

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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public CategoryStructure(int categoryId, String categoryName, int parentId) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentId = parentId;
	}
	
	@Override
	public String toString() {
		return "CategoryCascade [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", parentId=" + parentId + "]";
	}
	
	public CategoryStructure()
	{}
	

}
