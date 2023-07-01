package com.hostmdy.wifiservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.WifiCode;
import com.hostmdy.wifiservice.repository.WifiCodeRepository;
import com.hostmdy.wifiservice.service.WificodeService;

@Service
public class WificodeServiceImpl implements WificodeService {

	
	private final WifiCodeRepository wificodeRepository;
	
	
	
	@Autowired
	public WificodeServiceImpl(WifiCodeRepository wificodeRepository) {
		super();
		this.wificodeRepository = wificodeRepository;
	}



	@Override
	public List<WifiCode> findAll() {
		// TODO Auto-generated method stub
		return (List<WifiCode>) wificodeRepository.findAll();
	}



	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		wificodeRepository.deleteById(id);
		
	}



	@Override
	public WifiCode saveOrUpdateWifiCode(WifiCode wificode) {
		// TODO Auto-generated method stub
		return wificodeRepository.save(wificode);
	}



	@Override
	public Optional<WifiCode> findById(Long id) {
		// TODO Auto-generated method stub
		return wificodeRepository.findById(id);
	}




	
}
