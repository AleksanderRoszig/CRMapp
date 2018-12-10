package com.aleksander.crmapplication.service;

import java.util.List;

import com.aleksander.crmapplication.entity.Product;

public interface ProductService {

	public List<Product> getProduct();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);

	public List<Product> searchProduct(String theSearchName);

	public Product productDetails(int theId);
}
