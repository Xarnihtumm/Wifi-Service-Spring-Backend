package com.hostmdy.wifiservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.wifiservice.domain.Discount;


public interface DiscountRepository  extends CrudRepository<Discount, Long>{
	
	Optional<Discount> findDiscountById(Long id);
	Optional <Discount>  findByDiscountName(String disountName);
	

}
