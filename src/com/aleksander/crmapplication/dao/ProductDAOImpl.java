package com.aleksander.crmapplication.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aleksander.crmapplication.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProduct() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query and sort by name
		Query<Product> theQuery = currentSession.createQuery("from Product order by name", Product.class);
	
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
		
	
		// return the results
		return products;
	}
	
	
	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.saveOrUpdate(theProduct);
		
	}
	
	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrive/read from database using the primary ket 
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}
	
	@Override
	public void deleteProduct(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}
	
	@Override
	public List<Product> searchProduct(String theSearchName) {
		
		// get current hibernate session
		Session currentSession =  sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			
			// search for name of product, case insensitive
			theQuery = currentSession.createQuery("from Product where lower(name) like: theName", Product.class);
			theQuery.setParameter("theName", " %" + theSearchName.toLowerCase() + "%");
		}
		else { 
			// theSearchName is empty, get all customers
			theQuery = currentSession.createQuery("from Product", Product.class);
		}
		
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
		
		// return the results
		return products;
	}
	
	@Override
	public Product showProduct(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrive/read from database using the primary key
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
