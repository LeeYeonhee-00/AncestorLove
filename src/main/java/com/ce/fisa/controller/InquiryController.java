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
import com.ce.fisa.model.entity.Comment;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.service.InquiryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class InquiryController {
	
	@Autowired
	private InquiryService inqService;
	
	private static final Logger logger = LogManager.getLogger(PartnerController.class);
	
	// 전체 Inquiry 리스트 조회
	@GetMapping("/allinquiry")
	public List<AllInquiryDTO> getAllInquiryList() {
		logger.debug("의뢰하기 전체 조회 요청");
		return inqService.getAllInquiry();
	}
	
	// 특정 Inquiry 상세 조회
	@GetMapping("/inquiry/{id}")
	public InquiryDTO getInquiryById(@PathVariable("id") Long inquiryid) throws NotExistInquiryException {
		logger.debug("의뢰하기 상세 조회 요청");
		return inqService.getInquiry(inquiryid);
	}
	
	// Inquiry 작성
	@PostMapping("inquiry")
	public String postInquiry(@RequestBody InquiryDTO inquiryDTO) throws NotExistInquiryException {
		logger.debug("의뢰하기 작성 요청");
		
		Inquiry result = inqService.postInquiry(inquiryDTO);

		if (result != null) {
			logger.info("의뢰하기 작성 성공");
			return "의뢰하기 성공!!";
		} else {
			throw new NotExistInquiryException("유효한 값을 입력하세요");
		}
	}
	
	
	// Comment 작성
	@PostMapping("/comment")
	public ResponseEntity<String> postComment(@RequestBody CommentDTO commentDTO) throws NotExistInquiryException {

		logger.debug("댓글 작성 요청");

		Comment result = inqService.postComment(commentDTO);

		if (result != null) {
			logger.info("댓글 작성 성공");
			return ResponseEntity.ok("Comment 작성 성공");
		} else {
			logger.warn("댓글 작성 실패");
			return ResponseEntity.status(401).body("댓글 작성 실패");
		}
	}
	
}
