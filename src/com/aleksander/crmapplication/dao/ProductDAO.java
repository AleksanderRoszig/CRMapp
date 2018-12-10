package com.aleksander.crmapplication.dao;

import java.util.List;
import com.aleksander.crmapplication.entity.Product;

public interface ProductDAO {
	public List<Product> getProduct();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);

	public List<Product> searchProduct(String theSearchName);

	public Product showProduct(int theId);
}
