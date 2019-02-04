package com.newpractical.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newpractical.application.dao.BrandDao;
import com.newpractical.application.model.Brand;
import com.newpractical.application.model.Product;

@RestController
public class BrandController {

	@Autowired
	BrandDao branddao;

	@CrossOrigin
	@RequestMapping("/getBrands")
	public List<Brand> getBrandList() {
		return branddao.getBrandsFromDb();
	}

	@CrossOrigin
	@RequestMapping(value = "filterByBrandName")
	public List<Product> filterByBrand(
			@RequestParam("brand_name") String brand_name) {
		System.out.println("hit from backbone ");
		return branddao.filterByBrand(brand_name);
	}

	@CrossOrigin
	@RequestMapping(value = "filterByPrice")
	public List<Product> filterByPrice(@RequestParam("lower") String lower,
			@RequestParam("upper") String upper) {
		System.out.println("hitting filter with" + lower + upper);
		return branddao.filterByPrice(lower, upper);
	}
}
