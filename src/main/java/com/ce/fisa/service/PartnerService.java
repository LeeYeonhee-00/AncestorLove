package com.ce.fisa.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ce.fisa.exception.InvalidSignupException;
import com.ce.fisa.exception.NotExistPartnerException;
import com.ce.fisa.exception.NotExistUserException;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerAndReviewDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.dto.ReviewDTO;
import com.ce.fisa.model.dto.UserDTO;
import com.ce.fisa.model.entity.Review;

import jakarta.servlet.http.HttpSession;

@Service
public interface PartnerService {
	//파트너이름, 지역, 평점 평균 조회
	public List<Map<String, Object>> getAverageRatings();

	public List<PartnerDTO> getAllPartner();

	//파트너 상세 조회
	public PartnerDTO getPartners(long partnerId) throws NotExistPartnerException;
	
	// 파트너 회원가입
	public boolean signupPartner(PartnerDTO partner) throws InvalidSignupException ;
	
	// 파트너 로그인
	public boolean authenticatePartner(String partnerEmail, String partnerPw) throws NotExistPartnerException;
	
	// 파트너 로그아웃
	public boolean logoutPartner(HttpSession httpSession);

	
	// 리뷰생성
	public void createReview(ReviewDTO reviewDTO) throws NotExistPartnerException;
}
