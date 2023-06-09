package com.hostmdy.wifiservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.Order;


public interface OrderService {

	List<Order> findAllOrder();
	Optional<Order> findByOrderId(Long orderId);
	Optional<Order>  findByDate(LocalDate date);
	
	void deleteById(Long orderId);
	void deleteAll(Order order);
	
	Order saveOrUpdate(Order order);
	Order createOrder(Order order);
	
	
	
	
}
