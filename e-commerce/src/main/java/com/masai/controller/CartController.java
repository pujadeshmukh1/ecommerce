package com.masai.controller;

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

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartservice;

	
	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws CustomerException{
		
		Cart c=cartservice.addCart(cart);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
		
	}

	
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Cart> viewCart(@PathVariable("id") int cartId) throws CartException {
		
		Cart c=cartservice.viewCart(cartId);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
		
	}

	
	
	@PutMapping("/addItemIntoCart/{cartId}/{productId}")
	public ResponseEntity<Cart> addItemIntoCart(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId) throws CartException, ProductException {
		
		Cart c=cartservice.addItemIntoCart(cartId, productId);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
		
	}

	
	
	@PutMapping("/removeItemFromCart/{cartId}/{productId}")
	public ResponseEntity<Cart> removeItemFromCart(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId) throws CartException, ProductException {
		
		Cart c=  cartservice.removeItemFromCart(cartId, productId);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
	}

	
	
	@PutMapping("/increaseQuantity/{cartId}/{productId}/{quantity}")
	public ResponseEntity<Cart> increaseQuantity(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId, @PathVariable("quantity") int quantity) throws CartException, ProductException {
		
		Cart c= cartservice.increaseQuantity(cartId, productId, quantity);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
	}

	
	
	@PutMapping("/clearCart/{cartId}")
	public ResponseEntity<Cart> clearCart(@PathVariable("cartId") int cartId) throws CartException {
		
		Cart c=cartservice.clearCart(cartId);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
	}
	
	
	
	@PutMapping("/decreaseQuantity/{cartId}/{productId}/{quantity}")
	public ResponseEntity<Cart> decreaseQuantity(@PathVariable("cartId") int cartId, @PathVariable("productId") int productId, @PathVariable("quantity") int quantity) throws CartException, ProductException {
		
		Cart c=cartservice.decreaseQuantity(cartId, productId, quantity);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
	}

	
	
	
	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<Cart> deleteCart(@PathVariable("cartId") int cartId) throws CartException {
		
		Cart c=cartservice.deleteCart(cartId);
		
		return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
	}


}
