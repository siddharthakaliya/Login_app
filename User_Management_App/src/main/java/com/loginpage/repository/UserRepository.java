package com.loginpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginpage.model.UserDetails;


@Repository
	public interface UserRepository extends JpaRepository<UserDetails, Integer>{
	
		
		public boolean existsByEmail(String email);
		
		
		public UserDetails findByEmail(String email);
	}
