package com.ce.fisa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.controller.UserController;
import com.ce.fisa.dao.UserRepository;
import com.ce.fisa.exception.ErrorCode;
import com.ce.fisa.exception.InvalidSignupException;
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.exception.NotExistUserException;
import com.ce.fisa.model.dto.UserDTO;
import com.ce.fisa.model.entity.User;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession httpSession; // 세션 객체 주입
	
	// DTO <-> Entity
	private ModelMapper mapper = new ModelMapper();

	@Override
	public boolean signupUser(UserDTO userDTO) throws InvalidSignupException {
		// UserDTO -> User
		if (userDTO.getUserName() == null || userDTO.getUserName().isEmpty() || userDTO.getUserEmail() == null
				|| userDTO.getUserEmail().isEmpty() || userDTO.getUserPw() == null || userDTO.getUserPw().isEmpty()) {
			throw new InvalidSignupException("사용자 이름, 이메일 또는 비밀번호가 누락되었습니다.");
		}
		User user = mapper.map(userDTO, User.class);
		User result = userRepository.save(user);

		return true;
	}

	public boolean authenticate(String userEmail, String userPw) {
		User user = userRepository.findByUserEmail(userEmail);
		if (user != null) {

			if (userPw.equals(user.getUserPw())) {
				// 로그인 성공 시 세션에 사용자 정보 저장
				httpSession.setAttribute("userId", user.getUserId());
				httpSession.setAttribute("userName", user.getUserName());
				httpSession.setAttribute("userAge", user.getUserAge());
				httpSession.setAttribute("userGender", user.getUserGender());

				 // 세션 사용법 

				logger.debug("[ancestorlove] 사용자 id: " + httpSession.getAttribute("userId"));
				logger.debug("[ancestorlove] 사용자 이름: " + httpSession.getAttribute("userName"));

				return true;
			}

		}
		throw new NotExistUserException("해당 유저는 존재하지 않습니다.",ErrorCode.NOT_EXIST_USER);
	}

	@Override
	public boolean logout(HttpSession session) {
        if (session.getAttribute("userId") != null) {
        	logger.debug("[ancestorlove] 로그아웃 할 계정의 id:" + session.getAttribute("userId"));
            session.invalidate();
            return true;
        }
        return false;
    }

}
