package com.newpractical.application.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.newpractical.application.dao.BrandDao;
import com.newpractical.application.model.Brand;
import com.newpractical.application.model.QBrand;
import com.querydsl.jpa.impl.JPAQuery;

@Transactional
@Service

public class BrandDaoImplementation implements BrandDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Brand> getBrandsFromDb() {
		final JPAQuery<Brand> query = new JPAQuery<Brand>(em);
		final QBrand qBrand = QBrand.brand;
		return query.from(qBrand).fetch();
	}

}
