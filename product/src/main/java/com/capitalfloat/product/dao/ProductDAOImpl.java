package com.capitalfloat.product.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capitalfloat.product.model.Offer;
import com.capitalfloat.product.model.Product;

import lombok.NonNull;
@Repository
public class ProductDAOImpl implements IProductDAO{
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	public Session getSession() 
	{ 
		if (entityManagerFactory == null) {
			throw new NullPointerException();
		}
		return 	entityManagerFactory.unwrap(SessionFactory.class).openSession();

	}


	@Override
	public Long saveProduct(Product productEntity) { 
		return (Long)getSession().save(productEntity);
	}



	@Override
	public List<Product> getProducts() {
		return getSession().createQuery("from Product").getResultList();
		//return null;
	}

	@Override
	public Offer getOffer(@NonNull Long offerId) {
		return getSession().get(Offer.class, offerId);
	}

	@Override
	public Integer getUser(@NonNull Long userId) {
		Query q =getSession().createSQLQuery("select u.userId from User u where u.userId=:id");
		return Integer.valueOf(q.setParameter("id", userId).getFirstResult());
	}





}
