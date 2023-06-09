package com.hostmdy.wifiservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.hostmdy.wifiservice.domain.WifiPlan;

public interface WifiPlanRepository  extends CrudRepository<WifiPlan, Long>{

	Optional<WifiPlan> findPlanByplanName(String planName);
	Optional <WifiPlan>  findById(Long id);
	
	
	
}
