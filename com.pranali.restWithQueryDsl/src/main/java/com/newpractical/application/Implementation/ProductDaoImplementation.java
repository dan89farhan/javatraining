package com.newpractical.application.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newpractical.application.dao.ProductDao;
import com.newpractical.application.model.Category;
import com.newpractical.application.model.Product;
import com.newpractical.application.model.QProduct;
import com.querydsl.jpa.impl.JPAQuery;


@Transactional
@Service
public class ProductDaoImplementation implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveProduct(Product p) {
		em.persist(p);
	}

	@Override
	public Product getProductFromDbById(int id) {
		
		final JPAQuery<Product> prodQuery = new JPAQuery<Product>(em);
		final QProduct qProduct = QProduct.product;
		return prodQuery.from(qProduct).where(qProduct.productId.eq(id)).fetchOne();
	}

	@Override
	public void deleteProduct(int id) {
		Product p = getProductFromDbById(id);
		em.remove(p);
		
	}

	@Override
	public List<Product> getProductFromDb() {
		final JPAQuery<Product> prodQuery = new JPAQuery<Product>(em);
		final QProduct qProduct = QProduct.product;
		return prodQuery.from(qProduct).fetch();
	}

}
