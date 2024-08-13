package com.ce.fisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.dao.UserRepository;
import com.ce.fisa.model.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean signupUser(User user) {
		User result = userRepository.save(user);
		if(result == null) {
			// 추후 추가
		}
		return true;
	}

}
