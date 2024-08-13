package com.ce.fisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.dao.UserRepository;
import com.ce.fisa.model.entity.User;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
    private HttpSession httpSession; // 세션 객체 주입
	
	@Override
	public boolean signupUser(User user) {
		User result = userRepository.save(user);
		if(result == null) {
			// 추후 추가
		}
		return true;
	}
	public boolean authenticate(String userName, String userPW) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {

        	
        	
        	if (userPW.equals(user.getUserPw())) {
                // 로그인 성공 시 세션에 사용자 정보 저장
                httpSession.setAttribute("user", user);
				/*
				 * 세션 사용법 
				 * System.out.println (httpSession.getAttribute("user")); User user2 =
				 * (User) httpSession.getAttribute("user");
				 * System.out.println(user2.getUserName());
				 */
                return true;
            }
        }
        return false;
    }

}
