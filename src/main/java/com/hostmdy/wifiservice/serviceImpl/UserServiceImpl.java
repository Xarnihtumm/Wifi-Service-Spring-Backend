package com.hostmdy.wifiservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.User;
import com.hostmdy.wifiservice.repository.UserRepository;
import com.hostmdy.wifiservice.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository;
	

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
		
	}

	@Override
	public User saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save( user);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void DeleteAll(User user) {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		
	}

}
