package com.hostmdy.wifiservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.wifiservice.domain.WifiUser;



public interface WifiUserRepository extends CrudRepository<WifiUser, Long> {
	
	

	Optional<WifiUser> findByNrc(String nrc);
	Optional <WifiUser>  findByName(String name);
	
}
