package com.loginpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginpage.model.UserDetails;
import com.loginpage.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
		
	
	@Override
	public UserDetails createUser(UserDetails user) {
	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
	
		return  userRepo.existsByEmail(email);
	}
}
