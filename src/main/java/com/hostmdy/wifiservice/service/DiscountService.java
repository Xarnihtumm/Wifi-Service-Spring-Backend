package com.hostmdy.wifiservice.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.Discount;

public interface DiscountService {
	
	List<Discount> findAll();
	Optional<Discount> findById(Long id);
	Optional<Discount> findByName(String name);
	 
	void deleteById(Long id);
	void DeleteAll(Discount discount);
	
	Discount saveOrUpdateDiscount (Discount discount);
	
	Discount createDiscount(Discount discount);

}
