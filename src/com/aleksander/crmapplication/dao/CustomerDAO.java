package com.aleksander.crmapplication.dao;

import java.util.List;
import com.aleksander.crmapplication.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

	public Customer showCustomer(int theId);
	

}
