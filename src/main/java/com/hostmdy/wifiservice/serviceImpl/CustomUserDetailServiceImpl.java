package com.hostmdy.wifiservice.serviceImpl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.User;
import com.hostmdy.wifiservice.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	
	
	public CustomUserDetailServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> userOptional =  userRepository.findByUsername(username);
		
		
		if(userOptional.isEmpty())
			throw new UsernameNotFoundException("User not exits  with this name");
		
		
		return  userOptional.get() ;
	}

	@Transactional
	public User loadUserById(Long id) {
		Optional<User> userOptional = userRepository.getUserById(id);
		
		if(userOptional.isEmpty())
			throw new UsernameNotFoundException("User with id="+id+" is not found");
		
		return userOptional.get();
	} 
	
	
}
