package com.ce.fisa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.service.PartnerService;

@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	@GetMapping("/partner/{id}")
	public PartnerDTO getPartners(@PathVariable("id") Long partnerId) {
		System.out.println("11111");
		return partnerService.getPartners(partnerId);
	}
	
	@GetMapping("partnerall")
	public List<PartnerDTO> getAllPartner() {
		return partnerService.getAllPartner();
	}
	@GetMapping("/allpartner")
	public List<Map<String, Object>> getAverageRatings() {
		return partnerService.getAverageRatings();
	}

	
	
	
	
}
