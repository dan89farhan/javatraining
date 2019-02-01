package com.pranali.restWithQueryDsl.com.pranali.restWithQueryDsl;

import java.util.List;


public class CategoryToJson {
	
	private String name;
	private boolean isLeaf;
	private List<CategoryToJson> childern; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public List<CategoryToJson> getChildern() {
		return childern;
	}
	public void setChildern(List<CategoryToJson> childern) {
		this.childern = childern;
	}
	public CategoryToJson(String name, boolean isLeaf,
			List<CategoryToJson> childern) {
		super();
		this.name = name;
		this.isLeaf = isLeaf;
		this.childern = childern;
	}
	@Override
	public String toString() {
		return "CategoryFromJson [name=" + name + ", isLeaf=" + isLeaf
				+ ", childern=" + childern + "]";
	}
}
