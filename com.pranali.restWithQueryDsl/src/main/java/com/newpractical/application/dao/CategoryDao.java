package com.newpractical.application.dao;

import java.util.List;

import com.newpractical.application.Implementation.CategoryStructure;
import com.newpractical.application.model.Category;

public interface CategoryDao {
	public List<Category> getCategoryFromDb();
	public List<CategoryStructure> getCascadingCategoryList();
}
