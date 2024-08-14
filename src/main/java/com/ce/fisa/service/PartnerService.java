package com.ce.fisa.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerAndReviewDTO;
import com.ce.fisa.model.dto.PartnerDTO;

@Service
public interface PartnerService {
	// 파트너이름, 지역, 평점 평균 조회
	public List<Map<String, Object>> getAverageRatings();

	public List<PartnerDTO> getAllPartner();

	public PartnerDTO getPartners(long partnerId);

}
