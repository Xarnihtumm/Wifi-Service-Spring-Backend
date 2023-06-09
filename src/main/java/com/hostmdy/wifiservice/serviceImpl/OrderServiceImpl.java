package com.hostmdy.wifiservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.Order;
import com.hostmdy.wifiservice.repository.OrderRepository;
import com.hostmdy.wifiservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	
	private final OrderRepository orderRepository;
	
	
	
	
    @Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return (List<Order>) orderRepository.findAll();
	}

	

	@Override
	public Optional<Order> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return orderRepository.findByDate(date);
	}

	@Override
	public void deleteById(Long orderId) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(orderId);
		
	}

	

	@Override
	public Order saveOrUpdate(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public void deleteAll(Order order) {
		// TODO Auto-generated method stub
		orderRepository.deleteAll();
	}

	@Override
	public Optional<Order> findByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		 return orderRepository.findByOrderId(orderId);
	}

}
