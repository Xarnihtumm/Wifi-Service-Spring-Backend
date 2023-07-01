package com.hostmdy.wifiservice.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.WifiCode;

public interface WificodeService {

	
	List<WifiCode> findAll();
	void deleteById(Long id);
	WifiCode saveOrUpdateWifiCode (WifiCode wificode);
	Optional<WifiCode> findById(Long id);
}
