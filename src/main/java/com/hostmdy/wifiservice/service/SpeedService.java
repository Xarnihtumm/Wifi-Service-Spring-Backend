package com.hostmdy.wifiservice.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.Speed;

import jakarta.validation.Valid;


public interface SpeedService {
	List<Speed> findAll();
	Optional<Speed> findById(Long id);
//	Optional<Speed> findByMB(Integer MB);
	 
	void deleteById(Long id);
	void DeleteAll(Speed speed);
	
	Speed saveOrUpdateSpeed (Speed speed);
	
	Speed createSpeed(Speed speed);
	List<Speed> saveOrUpdateSpeeds(@Valid List<Speed> speeds);

}
