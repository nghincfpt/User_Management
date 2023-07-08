package com.nghinc.service;

import com.nghinc.exception.UserNotFountException;
import com.nghinc.model.User;

public interface UsersService  {
	public User createUser(User user);
	
	public boolean checkemail(String email);
	
	 public void updateResetPasswordToken(String token,String email) throws UserNotFountException;
	 
		public void updatePassword(User user,String newPassword);
		public User get(String resetPasswordToken);
}
