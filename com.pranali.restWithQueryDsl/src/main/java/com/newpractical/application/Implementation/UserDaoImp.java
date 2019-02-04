package com.newpractical.application.Implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.newpractical.application.dao.UserDao;
import com.newpractical.application.model.Product;
import com.newpractical.application.model.QProduct;
import com.newpractical.application.model.QUser;
import com.newpractical.application.model.User;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class UserDaoImp implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public String AuthenticateUser(String userName, String password) {
		
		
		final JPAQuery<User> userQuery = new JPAQuery<User>(em);
		final QUser quser = QUser.user;
		User u=userQuery.from(quser).where(quser.userName.eq(userName),quser.password.eq(password)).fetchOne();
		if(u!=null)
			return "true";
		
		return "false";	
		
	}
	
	

}
