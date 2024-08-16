package com.ce.fisa.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.AllInquiryDTO;
import com.ce.fisa.model.dto.CommentDTO;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.getInquiryDTO;
import com.ce.fisa.model.entity.Comment;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.service.InquiryService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class InquiryController {
	
	@Autowired
	private InquiryService inqService;
	
	@Autowired
	private HttpSession httpSession;
	
	private static final Logger logger = LogManager.getLogger(PartnerController.class);
	
	// 전체 Inquiry 리스트 조회
	@GetMapping("/allinquiry")
	public List<AllInquiryDTO> getAllInquiryList() {
		logger.debug("[ancestorlove] 의뢰하기 전체 조회 요청");
		return inqService.getAllInquiry();
	}
	
	// 특정 Inquiry 상세 조회
	@GetMapping("/inquiry/{id}")
	public getInquiryDTO getInquiryById(@PathVariable("id") Long inquiryid) throws NotExistInquiryException {
		logger.debug("[ancestorlove] 의뢰하기 상세 조회 요청");
		return inqService.getInquiry(inquiryid);
	}
	
	// Inquiry 작성
	@PostMapping("inquiry")
	public String postInquiry(@RequestBody InquiryDTO inquiryDTO) throws NotExistInquiryException {
		logger.debug("[ancestorlove] 의뢰하기 작성 요청");
		
		List<Object> results = inqService.postInquiry(inquiryDTO);
		Inquiry inquiryResult = (Inquiry)results.get(0);
		String work = (String)results.get(1);

		if (inquiryResult != null) {
			logger.info("[ancestorlove] 의뢰하기 작성 성공" + "사용자 성별 : "+ httpSession.getAttribute("userGender") +
					", 사용자 나이 : " + httpSession.getAttribute("userAge") + ", 의뢰 유형 : " + work +", 의뢰장소 : " + inquiryDTO.getInquiryAddress()+
					", 작업 날짜 : " + inquiryDTO.getInquiryDate());			
			return "의뢰하기 성공!!";
		} else {
			logger.warn("[ancestorlove] 의뢰하기 작성 실패");
			throw new NotExistInquiryException("유효한 값을 입력하세요");
		}
	}
	
	// Comment 작성
	@PostMapping("/comment")
	public ResponseEntity<String> postComment(@RequestBody CommentDTO commentDTO) throws NotExistInquiryException {

		logger.debug("[ancestorlove] 댓글 작성 요청");

		Comment result = inqService.postComment(commentDTO);

		if (result != null) {
			logger.info("[ancestorlove] 댓글 작성 성공");
			return ResponseEntity.ok("댓글 작성 성공!!");
		} else {
			logger.warn("[ancestorlove] 댓글 작성 실패");
			return ResponseEntity.status(401).body("댓글 작성 실패");
		}
	}
	
	// 계약 체결
	@PostMapping("/consign/{id}")
	public ResponseEntity<String> postConsignByCommentId(@PathVariable("id") Long commentid) throws NotExistInquiryException {
		
		logger.debug("[ancestorlove] 계약 체결 요청");
		
		Comment result = inqService.postConsign(commentid);
		
		if (result != null) {
			logger.info("[ancestorlove] 계약 체결 성공");
			return ResponseEntity.ok("계약 체결 성공!!");
		} else {
			logger.warn("[ancestorlove] 계약 체결 실패");
			return ResponseEntity.status(401).body("계약 체결 실패");
		}
	}
	
}
