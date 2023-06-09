package com.hostmdy.wifiservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.WifiUser;
import com.hostmdy.wifiservice.repository.WifiUserRepository;
import com.hostmdy.wifiservice.service.WifiUserService;

@Service
public class WifiUserServiceImpl  implements WifiUserService{
	
	
	private final WifiUserRepository wifiRepository;
	
	
	@Autowired
	public WifiUserServiceImpl(WifiUserRepository wifiRepository) {
		super();
		this.wifiRepository = wifiRepository;
	}

	@Override
	public List<WifiUser> findAllPayment() {
		// TODO Auto-generated method stub
		return (List<WifiUser>) wifiRepository.findAll();
	}

	@Override
	public Optional<WifiUser> findById(Long id) {
		// TODO Auto-generated method stub
		return wifiRepository.findById(id) ;
	}
	

	@Override
	public Optional<WifiUser> findByNrc(String nrc) {
		// TODO Auto-generated method stub
		return wifiRepository.findByNrc(nrc);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		wifiRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll(WifiUser wifiUser) {
		// TODO Auto-generated method stub
		wifiRepository.deleteAll();
	}

	@Override
	public WifiUser saveOrUpdate(WifiUser wifiUser) {
		// TODO Auto-generated method stub
		return wifiRepository.save(wifiUser);
	}

	@Override
	public WifiUser createWifiUser(WifiUser wifiUser) {
		// TODO Auto-generated method stub
		return wifiRepository.save(wifiUser);
	}

	

}
