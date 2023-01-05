package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Order;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer)throws CustomerException;
	
	public Customer viewCustomer(int customerId)throws CustomerException;
	
	public Customer updateCustomer(Customer customer, String key)throws CustomerException;
	
	public Customer deleteCustomer(int customerId, String key)throws CustomerException;
	
	public List<Order> viewOrders(int customerId, String key)throws CustomerException;

}
