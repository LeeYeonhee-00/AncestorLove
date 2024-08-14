package com.ce.fisa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.controller.UserController;
import com.ce.fisa.dao.UserRepository;
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
			logger.warn("회원가입 실패");
			throw new InvalidSignupException("사용자 이름, 이메일 또는 비밀번호가 누락되었습니다.");
		}
		User user = mapper.map(userDTO, User.class);
		User result = userRepository.save(user);

		return true;
	}

	public boolean authenticate(String userEmail, String userPw) throws NotExistUserException {
		User user = userRepository.findByUserEmail(userEmail);
		if (user != null) {

			if (userPw.equals(user.getUserPw())) {
				// 로그인 성공 시 세션에 사용자 정보 저장
				httpSession.setAttribute("userId", user.getUserId());
				httpSession.setAttribute("userName", user.getUserName());

				 // 세션 사용법 

				logger.debug("사용자 id: " + httpSession.getAttribute("userId"));
				logger.debug("사용자 이름: " + httpSession.getAttribute("userName"));

				return true;
			}

		}
		throw new NotExistUserException("해당 유저는 존재하지 않습니다.");
	}

	@Override
	public boolean logout(HttpSession session) {
//		System.out.println("로그아웃 할 계정의 id:" + session.getAttribute("userId"));
        if (session.getAttribute("userId") != null) {
            session.invalidate();
            logger.info("로그아웃 성공: 세션 무효화 완료");
            return true;
        }
        logger.warn("로그아웃 실패: 세션이 null입니다.");
        return false;
    }

}
