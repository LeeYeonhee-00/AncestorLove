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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.exception.InvalidSignupException;
import com.ce.fisa.exception.NotExistPartnerException;
import com.ce.fisa.model.dto.LoginResponseDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.dto.ReviewDTO;
import com.ce.fisa.service.PartnerService;

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
	
	
	@PostMapping("/review")
	public ResponseEntity<String> review(@RequestBody ReviewDTO reviewDTO) throws NotExistPartnerException {
	    // 유효성 검사
	    if (reviewDTO.getReuserId() <= 0 || reviewDTO.getPartnerId() <= 0 || 
	        reviewDTO.getReContent() == null || reviewDTO.getReContent().isEmpty() || 
	        reviewDTO.getReRating() < 1 || reviewDTO.getReRating() > 5) {
	        return ResponseEntity.badRequest().body("모든 필드는 필수이며, 평점은 1에서 5 사이여야 합니다.");
	    }

	    // 리뷰 작성 로직 실행
	    partnerService.createReview(reviewDTO);
	    return ResponseEntity.ok("리뷰가 성공적으로 작성되었습니다.");
	}

}
