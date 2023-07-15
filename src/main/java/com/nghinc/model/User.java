package com.nghinc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String email;
	private String address;
	private String qualification;
	private String password;
	private String role;
	private String resetPasswordToken;
	
	@Enumerated(EnumType.STRING)
	private AuthenticationProvider authProvider;
	
	@OneToMany(mappedBy = "user")
	private Set<DatHang> datHang;
}
