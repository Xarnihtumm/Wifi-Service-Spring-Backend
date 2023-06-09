package com.hostmdy.wifiservice.service;


import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.WifiUser;



public interface WifiUserService {
	
	
	
	
	List<WifiUser> findAllPayment();
	Optional<WifiUser> findById(Long id);
	Optional<WifiUser>  findByNrc(String nrc);
	
	void deleteById(Long id);
	void deleteAll(WifiUser wifiUser);
	
	WifiUser saveOrUpdate(WifiUser wifiUser);
	WifiUser createWifiUser(WifiUser wifiUser);

}
