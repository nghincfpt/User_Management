package com.nghinc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nghinc.model.User;
import com.nghinc.repository.UserRepository;
@Service
public class UserServiceImpl  implements UsersService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public User createUser(User user) {
	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	user.setRole("ROLE_USER");
		
		return userRepository.save(user);
	}

	@Override
	public boolean checkemail(String email) {
	return userRepository.existsByEmail(email);
	}


}
