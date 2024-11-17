package com.loginpage.service;



import com.loginpage.model.UserDetails;



public interface UserService {
	public UserDetails createUser(UserDetails user);
	
	public boolean checkEmail(String email);
}
