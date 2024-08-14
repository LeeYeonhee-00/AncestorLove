package com.ce.fisa.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.exception.NotExistPartnerException;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.service.PartnerService;

@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	private static final Logger logger = LogManager.getLogger(PartnerController.class);
	
	// Partner 상세 조회
	@GetMapping("/partner/{id}")
	public PartnerDTO getPartners(@PathVariable("id") Long partnerId) throws NotExistPartnerException {
		logger.debug("Partner 상세조회 요청");
		return partnerService.getPartners(partnerId);
	}
	
	// 별점 평균 없이 Partner 전체 정보 조회
	@GetMapping("/partnerall")
	public List<PartnerDTO> getAllPartner() {
		logger.debug("Partner 정보 전체조회");
		return partnerService.getAllPartner();
	}
	
	// Partner 전체 리스트 조회
	@GetMapping("/allpartner")
	public List<Map<String, Object>> getAverageRatings() {
		logger.debug("Partner 전체조회 요청");
		return partnerService.getAverageRatings();
	}

	
	
	
	
}
