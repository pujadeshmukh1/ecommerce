package com.masai.service;

import com.masai.exception.CartException;
import com.masai.exception.CustomerException;
import com.masai.exception.ProductException;
import com.masai.model.Cart;

public interface CartService {
	
	public Cart addCart(Cart cart)throws CustomerException;
	
	public Cart viewCart(int cartId)throws CartException;
	
	public Cart addItemIntoCart(int cartId, int productId)throws CartException,ProductException;
	
	public Cart removeItemFromCart(int cartId, int productId)throws CartException,ProductException;
	
	public Cart increaseQuantity(int cartId, int productId, int quantity)throws CartException,ProductException;
	
	public Cart decreaseQuantity(int cartId, int productId, int quantity)throws CartException,ProductException;
	
	public Cart clearCart(int cartId)throws CartException;
	
	public Cart deleteCart(int cartId)throws CartException;
	
}
