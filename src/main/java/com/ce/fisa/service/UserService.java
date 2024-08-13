package com.ce.fisa.service;

import org.springframework.stereotype.Service;

import com.ce.fisa.model.entity.User;

@Service
public interface UserService {
	public boolean signupUser(User user) ;
	public boolean authenticate(String username, String password);

}
