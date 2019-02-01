package com.pranali.restWithQueryDsl.com.pranali.restWithQueryDsl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.jpa.impl.JPAQuery;

@Transactional
//@Repository
@Service
public class RestWithQueryDslService {
	@PersistenceContext
	EntityManager em;
	
	public List<BrandPojo> getBrandsFromDb(){
		final JPAQuery<BrandPojo> query = new JPAQuery<BrandPojo>(em);
		final QBrandPojo qBrand = QBrandPojo.brandPojo;
		return query.from(qBrand).fetch();
	}

	public List<CategoryPojo> getCategoryFromDb(){
		final JPAQuery<CategoryPojo> catQuery= new JPAQuery<CategoryPojo>(em);
		final QCategoryPojo qCategory = QCategoryPojo.categoryPojo;
		return catQuery.from(qCategory).fetch();
	}
	
	public List<ProductPojo> getProductFromDb(){
		final JPAQuery<ProductPojo> prodQuery = new JPAQuery<ProductPojo>(em);
		final QProductPojo qProduct = QProductPojo.productPojo;
		return prodQuery.from(qProduct).fetch();
	}
	
	public void saveProduct(ProductPojo p){
		em.persist(p);
	}
	
	public ProductPojo getProductFromDbById(int id){
		final JPAQuery<ProductPojo> prodQuery = new JPAQuery<ProductPojo>(em);
		final QProductPojo qProduct = QProductPojo.productPojo;
		return prodQuery.from(qProduct).where(qProduct.productId.eq(id)).fetchOne();
	}
	
	public void deleteProduct(int id){
		ProductPojo p = getProductFromDbById(id);
		em.remove(p);
	}
	
	public List<CategoryCascade> getCascadingCategoryList(){
		final JPAQuery< CategoryCascade> catQuery = new JPAQuery<CategoryCascade>(em);
		final QCategoryCascade qCategoryCascade = QCategoryCascade.categoryCascade;
		return catQuery.from(qCategoryCascade).fetch();
	}
	
	
	
}
