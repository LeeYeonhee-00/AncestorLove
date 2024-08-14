package com.ce.fisa.service;

import org.springframework.stereotype.Service;

import com.ce.fisa.exception.InvalidSignupException;
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.exception.NotExistUserException;
import com.ce.fisa.model.dto.UserDTO;

import jakarta.servlet.http.HttpSession;

@Service
public interface UserService {
	public boolean signupUser(UserDTO user) throws InvalidSignupException ;
	public boolean authenticate(String userEmail, String userPW) throws NotExistUserException;
	public boolean logout (HttpSession httpSession);

}
