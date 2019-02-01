package com.newpractical.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpractical.application.dao.BrandDao;
import com.newpractical.application.model.Brand;



@RestController
public class BrandController {

	@Autowired 
	BrandDao branddao;
	
	@CrossOrigin
	@RequestMapping("/getBrands")
	public List<Brand> getBrandList() {
		return branddao.getBrandsFromDb();
	}
}
