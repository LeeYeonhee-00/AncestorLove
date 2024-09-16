package com.ce.fisa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.exception.InvalidSignupException;
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.exception.NotExistUserException;
import com.ce.fisa.model.dto.LoginResponseDTO;
import com.ce.fisa.model.dto.UserDTO;
import com.ce.fisa.model.entity.User;
import com.ce.fisa.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private HttpSession httpSession;

	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session){
		boolean result = userService.logout(session);
        if (result) {
        	logger.info("[ancestorlove] 로그아웃 성공 - 세션 무효화 완료");
            return ResponseEntity.ok("로그아웃 성공");
        } else {
        	logger.warn("[ancestorlove] 로그아웃 실패 - 세션이 null입니다.");
            return ResponseEntity.status(500).body("로그아웃 실패");
        }
		
	}

	@PostMapping("/signup")
	public String signupUser(@RequestBody UserDTO user) throws InvalidSignupException {
		logger.debug("[ancestorlove] 회원가입 요청");
		boolean valid = userService.signupUser(user);
		if (valid) {
			logger.info("[ancestorlove] 회원가입 성공");
			return "회원가입 성공!!";
		} else {
	 		logger.warn("[ancestorlove] 회원가입 실패");
			throw new InvalidSignupException("유효한 값을 입력하세요");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO user) {

		logger.debug("[ancestorlove] 로그인 요청");

		boolean isAuthenticated = userService.authenticate(user.getUserEmail(), user.getUserPw());

//		if (isAuthenticated) {
			
			long id = (long)httpSession.getAttribute("userId");
			String name = (String)httpSession.getAttribute("userName");
			
			LoginResponseDTO response = new LoginResponseDTO("로그인 성공", id, name);
			logger.info("[ancestorlove] 로그인 성공");

	        return ResponseEntity.ok(response);
//	    } 
//		else {
//	        logger.warn("[ancestorlove] 로그인 실패");
//	        return ResponseEntity.status(401).body(new LoginResponseDTO("로그인 실패", 0, null));
//	    }
			
	}

}
