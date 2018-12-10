package com.aleksander.crmapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aleksander.crmapplication.dao.CustomerDAO;
import com.aleksander.crmapplication.dao.ProductDAO;
import com.aleksander.crmapplication.entity.Customer;
import com.aleksander.crmapplication.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
		// need to inject product dao
		@Autowired
		private ProductDAO productDAO;
		
		
		@Override
		@Transactional
		public List<Product> getProduct() {
			// TODO Auto-generated method stub
			return productDAO.getProduct();
		}


		@Override
		@Transactional
		public void saveProduct(Product theProduct) {
			
			productDAO.saveProduct(theProduct);
			
		}


		@Override
		@Transactional
		public Product getProduct(int theId) {
			
			return productDAO.getProduct(theId);
		}


		@Override
		@Transactional
		public void deleteProduct(int theId) {
			
			productDAO.deleteProduct(theId);
			
		}


		@Override
		@Transactional
		public List<Product> searchProduct(String theSearchName) {
			
			return productDAO.searchProduct(theSearchName);
		}


		@Override
		@Transactional
		public Product productDetails(int theId) {
			
			return productDAO.showProduct(theId);
		}

}
