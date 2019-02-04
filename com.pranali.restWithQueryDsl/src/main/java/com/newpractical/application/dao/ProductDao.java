package com.newpractical.application.dao;

import java.util.List;

import com.newpractical.application.model.Category;
import com.newpractical.application.model.Product;

public interface ProductDao {
	public List<Product> getProductFromDb();
	public void saveProduct(Product p);
	public Product getProductFromDbById(int id);
	public void deleteProduct(int id);
	public List<Product> get(String brand_name,String lower,String upper);
}
