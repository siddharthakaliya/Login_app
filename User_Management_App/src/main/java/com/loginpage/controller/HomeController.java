package com.loginpage.controller;

import java.net.http.HttpClient;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginpage.model.UserDetails;
import com.loginpage.service.UserService;


@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDetails user,HttpSession session) {
		//System.out.println(user); // This should print the user details
	boolean f=	userService.checkEmail(user.getEmail());
	if(f) {
		session.setAttribute("msg", "Email Id already Exist");
		//System.out.println("Email Id already Exist");
		
		
	}
	else {
		UserDetails UserDetails= userService.createUser(user); // Save user to the database
		if(UserDetails != null) {
			session.setAttribute("msg","Register Sucessfully");
			//System.out.println("Register Sucessfully");
		}else {
			session.setAttribute("msg","Error like value null possible or Server Error");
				//System.out.println("Error like value null possible");	
				
	}
	}
		
//		UserDetails UserDetails= userService.createUser(user); // Save user to the database
//	if(UserDetails != null) {
//		System.out.println("Register Sucessfully");
//	}else {
//	
//			System.out.println("Error like value null possible");	
//			
//		}
	return "redirect:/register"; // Redirect or forward to the register page
	
	//return "register"; 

	}
	}

