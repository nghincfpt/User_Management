package com.nghinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nghinc.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
public boolean existsByEmail(String email);
}
