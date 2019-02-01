package com.pranali.restWithQueryDsl.com.pranali.restWithQueryDsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestWithQueryDslController {

	@Autowired 
	RestWithQueryDslService brs;
	@Autowired
	ConvertToJson cv;
	
	
	@RequestMapping("/abd")
	public String welcome() {
		return "Web Service working.";
	}
	
	

	
	@CrossOrigin
	@RequestMapping("/getBrands")
	public List<BrandPojo> getBrandList() {
		return brs.getBrandsFromDb();
	}
	
	@CrossOrigin
	@RequestMapping("/getCategory")
	public List<CategoryPojo> getCategoryList(){
		return brs.getCategoryFromDb();
	}


	@CrossOrigin
	@RequestMapping("/getProducts")
	public List<ProductPojo> getProductList(){
		System.out.println("working product");
		return brs.getProductFromDb();
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/saveProduct",  method= RequestMethod.POST)
	public void addProduct(@RequestBody ProductPojo p){
		brs.saveProduct(p);
		System.out.println(p);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/Product",  method= RequestMethod.DELETE)
	public void deleteProduct(@RequestParam("id") int id){
		System.out.println(id);
		brs.deleteProduct(id);
		System.out.println("working");
	}
	
	
	@CrossOrigin
	@RequestMapping("/getCascadingCategory")
	public List<CategoryToJson> getCascadingCategory(){
		return(cv.createTree(brs.getCascadingCategoryList()));
	}
	
}
