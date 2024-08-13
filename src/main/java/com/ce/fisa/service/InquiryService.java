package com.ce.fisa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.InquiryDTO;

@Service
public interface InquiryService {
	
	// 전체 Inquiry 리스트 조회
	public List<InquiryDTO> getAllInquiry();
	
	// ID값으로 Inquiry 상세 조회
	public InquiryDTO getInquiry(long inquiry_id) throws NotExistInquiryException;

}
