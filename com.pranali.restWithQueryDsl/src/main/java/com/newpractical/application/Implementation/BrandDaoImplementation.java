package com.newpractical.application.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.newpractical.application.dao.BrandDao;
import com.newpractical.application.model.Brand;
import com.newpractical.application.model.Product;
import com.newpractical.application.model.QBrand;
import com.querydsl.jpa.impl.JPAQuery;

@Transactional
@Repository
public class BrandDaoImplementation implements BrandDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Brand> getBrandsFromDb() {
		final JPAQuery<Brand> query = new JPAQuery<Brand>(em);
		final QBrand qBrand = QBrand.brand;
		return query.from(qBrand).fetch();
	}

	@Override
	public List<Product> filterByBrand(String brand_name) {
		Query q = em.createQuery("From Product p1 where p1.productBrand=:brand_names");
		q.setParameter("brand_names", brand_name);
		List<Product> data = q.getResultList();
		return data;
	}

	@Override
	public List<Product> filterByPrice(String lower, String Upper) {
		Query q = em.createQuery("From Product p1 where p1.productPrice between :lower and :Upper");
		q.setParameter("lower", lower);
		q.setParameter("Upper", Upper);
		List<Product> data = q.getResultList();
		return data;
	}

}
