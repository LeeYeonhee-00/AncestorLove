package com.ce.fisa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.AllInquiryDTO;
import com.ce.fisa.model.dto.CommentDTO;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.getInquiryDTO;
import com.ce.fisa.model.entity.Comment;
import com.ce.fisa.model.entity.Inquiry;

@Service
public interface InquiryService {
	
	// 전체 Inquiry 리스트 조회
	public List<AllInquiryDTO> getAllInquiry();
	
	// ID값으로 Inquiry 상세 조회
	public getInquiryDTO getInquiry(long inquiryId) throws NotExistInquiryException;

	// Inquiry 작성
	public List<Object> postInquiry(InquiryDTO inquiryDTO) throws NotExistInquiryException;
	
	// Comment 작성
	public Comment postComment(CommentDTO commentDTO) throws NotExistInquiryException;
	
	// 계약 체결
	public Comment postConsign(long commentid) throws NotExistInquiryException;
}
