package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.CartException;
import com.masai.exception.OrderException;
import com.masai.model.Order;

public interface OrderService {
	
	public Order addOrder(Order order, int cartId)throws OrderException,CartException;
	
	public Order viewOrder(int orderId)throws OrderException;
	
	public List<Order> viewOrdersByDate(LocalDate startDate, LocalDate endDate)throws OrderException;
	
	public Order updateOrderStatus(int orderId, String status)throws OrderException;
	
	public Order deleteOrder(int orderId)throws OrderException;
	
}
