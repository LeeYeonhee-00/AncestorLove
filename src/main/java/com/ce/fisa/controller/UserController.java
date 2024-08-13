package com.ce.fisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.model.entity.User;
import com.ce.fisa.service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userService  ;
		
		@PostMapping("/signup")
	    public boolean signupUser(@RequestBody User user) {
			userService.signupUser(user);
			return false;
	        
	    }
		

}
