package com.ce.fisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.service.InquiryService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class InquiryController {
	
	@Autowired
	private InquiryService inqService;
	
	// 전체 Inquiry 리스트 조회
	@GetMapping("inquriyall")
	public List<InquiryDTO> getMethodName() {
		return inqService.getAllInquiry();
	}
	
	@GetMapping("inquriy")
	public InquiryDTO getMethodName(@RequestParam Long inquriy_id) throws NotExistInquiryException {
		return inqService.getInquiry(inquriy_id);
	}
	

}
