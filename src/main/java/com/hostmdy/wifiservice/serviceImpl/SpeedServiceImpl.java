package com.hostmdy.wifiservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.Speed;
import com.hostmdy.wifiservice.repository.SpeedRepository;
import com.hostmdy.wifiservice.service.SpeedService;

import jakarta.validation.Valid;

@Service
public class SpeedServiceImpl implements SpeedService {
	
	private final SpeedRepository speedRepository;
	
	
   @Autowired
	public SpeedServiceImpl(SpeedRepository speedRepository) {
		super();
		this.speedRepository = speedRepository;
	}

	@Override
	public List<Speed> findAll() {
		// TODO Auto-generated method stub
		return (List<Speed>) speedRepository.findAll();
	}

	@Override
	public Optional<Speed> findById(Long id) {
		// TODO Auto-generated method stub
		return speedRepository.findById(id);
	}

	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		speedRepository.deleteById(id);
	}

	@Override
	public void DeleteAll(Speed speed) {
		// TODO Auto-generated method stub
		speedRepository.deleteAll();
	}

	@Override
	public Speed saveOrUpdateSpeed(Speed speed) {
		// TODO Auto-generated method stub
		return speedRepository.save(speed);
	}

	@Override
	public Speed createSpeed(Speed speed) {
		// TODO Auto-generated method stub
		return speedRepository.save(speed);
	}

	@Override
	public List<Speed> saveOrUpdateSpeeds(@Valid List<Speed> speeds) {
		// TODO Auto-generated method stub
		return (List<Speed>) speedRepository.saveAll(speeds);
	}

//	@Override
//	public Optional<Speed> findByMB(Integer MB) {
//		// TODO Auto-generated method stub
//		return speedRepository.findBySpeed(MB);
//	}

	

}
