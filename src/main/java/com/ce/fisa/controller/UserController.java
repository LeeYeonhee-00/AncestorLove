package com.ce.fisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.model.entity.User;
import com.ce.fisa.service.LoginRequest;
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
		

		@PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
			boolean isAuthenticated = userService.authenticate(loginRequest.getUserName(), loginRequest.getUserPW());

	        if (isAuthenticated) {
	            return ResponseEntity.ok("로그인 성공");
	        } else {
	            return ResponseEntity.status(401).body("로그인 실패");
	        }
	    }

		

}
