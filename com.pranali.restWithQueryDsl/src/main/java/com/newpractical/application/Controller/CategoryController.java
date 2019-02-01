package com.newpractical.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpractical.application.Implementation.CategoryToJson;
import com.newpractical.application.Implementation.CreateCategoryHierarchy;
import com.newpractical.application.dao.CategoryDao;
import com.newpractical.application.model.Category;


@RestController
public class CategoryController {

	
	@Autowired 
	CategoryDao catDao;
	@Autowired
	CreateCategoryHierarchy cv;
	
	@CrossOrigin
	@RequestMapping("/getCategory")
	public List<Category> getCategoryList(){
		return catDao.getCategoryFromDb();
	}
	
	@CrossOrigin
	@RequestMapping("/getCascadingCategory")
	public List<CategoryToJson> getCascadingCategory(){
		return(cv.createTree(catDao.getCascadingCategoryList()));
	}
}
