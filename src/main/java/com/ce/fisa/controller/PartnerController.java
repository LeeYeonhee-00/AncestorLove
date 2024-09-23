package com.ce.fisa.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.exception.InvalidSignupException;
import com.ce.fisa.exception.NotExistPartnerException;
import com.ce.fisa.model.dto.LoginResponseDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.dto.ReviewDTO;
import com.ce.fisa.service.PartnerService;
import com.ce.fisa.service.PartnerServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private HttpSession httpSession;
	
	private static final Logger logger = LogManager.getLogger(PartnerController.class);
	
	// Partner 상세 조회
	@GetMapping("/partner/{id}")
	public PartnerDTO getPartners(@PathVariable("id") Long partnerId) throws NotExistPartnerException {
		logger.debug("[ancestorlove] 파트너 상세조회 요청");
		return partnerService.getPartners(partnerId);
	}
	
	// 별점 평균 없이 Partner 전체 정보 조회 - 사용 안함(디버깅 위함)
	@GetMapping("/partnerall")
	public List<PartnerDTO> getAllPartner() {
		logger.debug("[ancestorlove] 파트너 정보 전체조회");
		return partnerService.getAllPartner();
	}
	
	// Partner 전체 리스트 조회
	@GetMapping("/allpartner")
	public List<Map<String, Object>> getAverageRatings() {
		logger.debug("[ancestorlove] 파트너 전체조회 요청");
		return partnerService.getAverageRatings();
	}

	//파트너 회원가입
	@PostMapping("/psignup")
	public String signupPartner(@RequestBody PartnerDTO partner) throws InvalidSignupException {
		logger.debug("[ancestorlove] 파트너 회원가입 요청");
		boolean valid = partnerService.signupPartner(partner);
		if(valid) {
			logger.info("[ancestorlove] 파트너 회원가입 성공");
			return "파트너 회원 가입 성공";
		} else {
			logger.warn("[ancestorlove] 파트너 회원가입 실패");
			throw new InvalidSignupException("유효한 값을 입력하세요");
		}
	}
	
	//파트너 로그인
	@PostMapping("/plogin")
	public ResponseEntity<LoginResponseDTO> plogin(@RequestBody PartnerDTO partner) throws NotExistPartnerException {
		
		logger.debug("[ancestorlove] 파트너 로그인 요청");
		boolean isAuthenticated = partnerService.authenticate(partner.getPartnerEmail(), partner.getPartnerPw());
		
		if(isAuthenticated) {
			
			logger.info("[ancestorlove] 파트너 로그인 성공");
			long pid = (long)httpSession.getAttribute("partnerId");
			String pname = (String)httpSession.getAttribute("partnerName");
			
			LoginResponseDTO response = new LoginResponseDTO("파트너 로그인 성공", pid, pname);
			return ResponseEntity.ok(response);
		} else {
			
			logger.warn("[ancestorlove] 파트너 로그인 실패");
			return ResponseEntity.status(401).body(new LoginResponseDTO("파트너 로그인 실패", 0, null));
		}
	}
	
	//파트너 로그아웃
	@PostMapping("/plogout")
	public ResponseEntity<String> plogout(HttpSession session) {
		boolean result = partnerService.logout(session);
		if(result) {
			logger.info("[ancestorlove] 파트너 로그아웃 성공 - 세션 무효화 완료");
            return ResponseEntity.ok("파트너 로그아웃 성공");
        } else {
        	logger.warn("[ancestorlove] 파트너 로그아웃 실패 - 세션이 null입니다.");
            return ResponseEntity.status(500).body("파트너 로그아웃 실패");
        }
	}
	
	////
	
	
	@PostMapping("/review")
	public void review(@RequestBody ReviewDTO reviewDTO) {
		
		
		partnerService.createReview(reviewDTO);
	}
}
