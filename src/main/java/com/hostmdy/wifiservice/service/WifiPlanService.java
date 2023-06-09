package com.hostmdy.wifiservice.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.WifiPlan;

public interface WifiPlanService {
	
	
	List<WifiPlan> findAllPlan();
	Optional<WifiPlan> findById(Long id);
	Optional<WifiPlan>  findByplanName(String planName);
	
	void deleteById(Long id);
	void deleteAll(WifiPlan wifiPlan);
	
	WifiPlan createWifiPlan(WifiPlan wifiPlan);
	WifiPlan updateWifiPlan(WifiPlan wifiPlan);

}
