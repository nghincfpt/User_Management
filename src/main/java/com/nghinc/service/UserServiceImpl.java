package com.nghinc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nghinc.exception.UserNotFountException;
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

	
	@Override
	public void updateResetPasswordToken(String token, String email) throws UserNotFountException {
		
		User user= userRepository.findByEmail(email);
	
		if(user !=null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);	
		}else {
			throw new UserNotFountException("Could not find any user with email" +email);
		}
	}
	@Override
	public User get(String resetPasswordToken) {
		return userRepository.findByResetPasswordToken(resetPasswordToken);
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(newPassword);
		
		user.setPassword(encodePassword);
		user.setResetPasswordToken(null);
		userRepository.save(user);
		
	}
	
	

}
