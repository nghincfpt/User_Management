package com.nghinc.service;

import com.nghinc.model.User;

public interface UsersService  {
	public User createUser(User user);
	
	public boolean checkemail(String email);
}
