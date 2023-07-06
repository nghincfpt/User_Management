package com.nghinc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nghinc.model.User;
import com.nghinc.repository.UserRepository;
@Service
public class UserServiceImpl  implements UsersService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
	
	return userRepository.save(user);
	}

	@Override
	public boolean checkemail(String email) {
	return userRepository.existsByEmail(email);
	}


}
