package com.hostmdy.wifiservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.WifiPlan;
import com.hostmdy.wifiservice.repository.WifiPlanRepository;
import com.hostmdy.wifiservice.service.WifiPlanService;

@Service
public class WifiPlanServiceImpl  implements WifiPlanService {
	
	
	
	private final WifiPlanRepository wifiPlanRepository;
	
	@Autowired
	public WifiPlanServiceImpl(WifiPlanRepository wifiPlanRepository) {
		super();
		this.wifiPlanRepository = wifiPlanRepository;
	}

	@Override
	public List<WifiPlan> findAllPlan() {
		// TODO Auto-generated method stub
		return (List<WifiPlan>) wifiPlanRepository.findAll();
	}

	@Override
	public Optional<WifiPlan> findById(Long id) {
		// TODO Auto-generated method stub
		return wifiPlanRepository.findById(id);
	}

	@Override
	public Optional<WifiPlan> findByplanName(String planName) {
		// TODO Auto-generated method stub
		return wifiPlanRepository.findPlanByplanName(planName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		wifiPlanRepository.deleteById(id);
	}

	@Override
	public void deleteAll(WifiPlan wifiPlan) {
		// TODO Auto-generated method stub
		wifiPlanRepository.deleteAll();
	}

	@Override
	public WifiPlan createWifiPlan(WifiPlan wifiPlan) {
		// TODO Auto-generated method stub
		return wifiPlanRepository.save(wifiPlan);
	}

	@Override
	public WifiPlan updateWifiPlan(WifiPlan wifiPlan) {
		// TODO Auto-generated method stub
		return wifiPlanRepository.save(wifiPlan);
	}

}
