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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/add/{categoryId}")
	public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable("categoryId") int categoryId) throws ProductException, CategoryException {
		
		Product pro= productservice.addProduct(product, categoryId);
		
		return new ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
	
	}
	
	
	
	@GetMapping("/view/{productId}")
	public ResponseEntity<Product> viewProduct(@PathVariable("productId") int productId) throws ProductException {
		
		Product pro= productservice.viewProduct(productId);
		
		return new ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/viewAllProduct")
	public ResponseEntity<List<Product>> allProduct() throws ProductException {
		
		List<Product>list=productservice.allProduct();
		
		return new ResponseEntity<List<Product>>(list,HttpStatus.ACCEPTED);
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException {
		
		Product p=productservice.updateProduct(product);
		
		return new ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Product> removeProduct(@PathVariable("productId") int productId) throws ProductException {
		
		Product pro=productservice.removeProduct(productId);
		
		return new ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/productByName/{name}")
	public ResponseEntity<List<Product>> productByName(@PathVariable("name") String name) throws ProductException {
		
		List<Product>list=productservice.productByName(name);
		
		return new ResponseEntity<List<Product>>(list,HttpStatus.ACCEPTED);
	}
	

}
