package com.ce.fisa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.dao.PartnerRepository;
import com.ce.fisa.dao.ReviewRepository;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerAndReviewDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.model.entity.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private PartnerRepository partnerDAO;
	@Autowired
	private ReviewRepository reviewDAO;
	
	private ModelMapper mapper = new ModelMapper();
	
	public PartnerDTO getPartners(long partnerId) {
		
		Partner entity = partnerDAO.findByPartnerId(partnerId);
		
		// 예외 처리
		
		PartnerDTO parterdto = mapper.map(entity, PartnerDTO.class);
		return parterdto;
	}

	@Override
	public List<PartnerDTO> getAllPartner() {
		List<Partner> partnerEntityList = partnerDAO.findAll();
		System.out.println("getAllPartner() : " + partnerEntityList);
		
		List<PartnerDTO> partnerDTOList = partnerEntityList.stream()
	            .map(entity -> mapper.map(entity, PartnerDTO.class))
	            .collect(Collectors.toList());
		return partnerDTOList;

	}

	public List<Map<String, Object>> getAverageRatings() {
		List<Object[]> results = partnerDAO.findAverageRatingsForPartners();
		List<Map<String, Object>> response = new ArrayList<>();

		for (Object[] result : results) {
			Map<String, Object> map = new HashMap<>();
			map.put("partnerName", result[0]);
			map.put("partnerLocation", result[1]);
			map.put("averageRating", result[2]);
			response.add(map);
		}

		return response;
	}

		
		// 1. 받아온 파트너 id로 partnerDAO를 이용해서 파트너 이름이랑 주소지를 받아온다
		// 2. 받아온 파트너 id로 reviewDAO를 이용해서 해당 파트너의 평균 별점을 받아온다
		// 3. 받아온 값들을 정의한 DTO로 담아서 반환		
    }


