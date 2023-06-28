package com.hostmdy.wifiservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.wifiservice.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	
	Optional<User> findByUsername(String username);
	Optional <User>  findByName(String name);
	Optional<User> getUserById(Long id);
}
