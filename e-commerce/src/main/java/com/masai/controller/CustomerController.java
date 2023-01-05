package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.Order;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws CustomerException {
		
		Customer cust= customerservice.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(cust,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/viewOrders/{id}")
	public ResponseEntity<List<Order>> viewOrders(@PathVariable("id") int customerId, @RequestParam(required = false) String key) throws CustomerException {
		
		List<Order> list = customerservice.viewOrders(customerId, key);
		
		return new ResponseEntity<List<Order>>(list,HttpStatus.ACCEPTED);
	}

	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @RequestParam(required = false) String key ) throws CustomerException {
		
		Customer cust = customerservice.updateCustomer(customer, key);
		
		return new ResponseEntity<Customer>(cust,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int customerId, @RequestParam(required = false) String key) throws CustomerException {
		
		Customer cust = customerservice.deleteCustomer(customerId, key);
		
		return new ResponseEntity<Customer>(cust,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") int customerId) throws CustomerException {
		
		Customer customer = customerservice.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
		
	}
	
	
}
