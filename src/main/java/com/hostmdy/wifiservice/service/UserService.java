package com.hostmdy.wifiservice.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.User;

public interface UserService {
	
	
	List<User> findAll();
	Optional<User> findById(Long id);
	Optional<User> findByName(String name);
	 
	void deleteById(Long id);
	void DeleteAll(User user);
	
	User saveOrUpdateUser (User user);
	
	User createUser(User user);

}
