package com.newpractical.application.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.newpractical.application.dao.CategoryDao;
import com.newpractical.application.model.Category;
import com.newpractical.application.model.QCategory;
import com.querydsl.jpa.impl.JPAQuery;

@org.springframework.transaction.annotation.Transactional
@Repository

public class CategoryDaoImplementation implements CategoryDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Category> getCategoryFromDb() {
		
		final JPAQuery<Category> catQuery= new JPAQuery<Category>(em);
		final QCategory qCategory = QCategory.category;
		return catQuery.from(qCategory).fetch();

	}

	@Override
	public List<CategoryStructure> getCascadingCategoryList() {
		
		final JPAQuery< CategoryStructure> catQuery = new JPAQuery<CategoryStructure>(em);
		final QCategoryStructure qCategoryStructure = QCategoryStructure.categoryStructure;
		return catQuery.from(qCategoryStructure).fetch();
	}

}
