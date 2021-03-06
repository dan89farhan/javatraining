package com.newpractical.application.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newpractical.application.dao.ProductDao;
import com.newpractical.application.model.Category;
import com.newpractical.application.model.Product;
import com.newpractical.application.model.QProduct;
import com.querydsl.jpa.impl.JPAQuery;

@Transactional
@Repository
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
		return prodQuery.from(qProduct).where(qProduct.id.eq(id))
				.fetchOne();
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

	@Override
	public List<Product> get(String brand_name, String stringLower,
			String stringUpper) {
		int lower = Integer.parseInt(stringLower);
		int upper = Integer.parseInt(stringUpper);
		final JPAQuery<Product> pQuery = new JPAQuery<Product>(em);
		final QProduct qproduct = QProduct.product;
		return pQuery
				.from(qproduct)
				.where(qproduct.productBrand.eq(brand_name).or(
						qproduct.productPrice.between(lower, upper))).fetch();

	}

	@Override
	public void updateProduct(Product p) {
	em.merge(p);
	}
}
