package com.hostmdy.wifiservice.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.wifiservice.domain.Order;



public interface OrderRepository extends CrudRepository<Order, Long> {
	
	Optional<Order> findByOrderId(Long orderId);
	Optional <Order>  findByDate(LocalDate  date);
	
	
}


