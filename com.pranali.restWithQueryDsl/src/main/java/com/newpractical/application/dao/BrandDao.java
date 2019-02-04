package com.newpractical.application.dao;

import java.util.List;

import com.newpractical.application.model.Brand;
import com.newpractical.application.model.Product;

public interface BrandDao {
	public List<Brand> getBrandsFromDb();
	public List<Product> filterByBrand(String brand_name);
	public List<Product> filterByPrice(String lower,String Upper);
}
