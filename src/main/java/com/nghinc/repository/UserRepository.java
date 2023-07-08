package com.nghinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.nghinc.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
public boolean existsByEmail(String email);

public User findByEmail(String email);

public User findByResetPasswordToken(String token);
}
