package com.newpractical.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newpractical.application.dao.ProductDao;
import com.newpractical.application.model.Product;


@RestController
public class ProductController {
	
	@Autowired 
	ProductDao prodDao;
	
	@CrossOrigin
	@RequestMapping("/getProducts")
	public List<Product> getProductList(){
		System.out.println("working product");
		return prodDao.getProductFromDb();
	}

	
	@CrossOrigin
	@RequestMapping(value = "/saveProduct",  method= RequestMethod.POST)
	public void addProduct(@RequestBody Product p){
		prodDao.saveProduct(p);
		System.out.println(p);
	}
	

	@CrossOrigin
	@RequestMapping(value = "/Product",  method= RequestMethod.DELETE)
	public void deleteProduct(@RequestParam("id") int id){
		System.out.println(id);
		prodDao.deleteProduct(id);
		System.out.println("working");
	}
}
