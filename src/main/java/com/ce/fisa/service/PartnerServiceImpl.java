package com.ce.fisa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.controller.PartnerController;
import com.ce.fisa.dao.PartnerRepository;
import com.ce.fisa.dao.ReviewRepository;
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.exception.NotExistPartnerException;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerAndReviewDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.model.entity.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerDAO;

	private ModelMapper mapper = new ModelMapper();

	private static final Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

	@Override
	public PartnerDTO getPartners(long partnerId) throws NotExistPartnerException {

		Partner partnerEntity = partnerDAO.findByPartnerId(partnerId);

		if (partnerEntity == null) {
			logger.warn("Partner 상세조회 실패");
			throw new NotExistPartnerException("해당 파트너는 존재하지 않습니다.");
		}

		PartnerDTO parterdto = mapper.map(partnerEntity, PartnerDTO.class);
		logger.info("Partner 상세조회 성공");
		return parterdto;
	}

	@Override
	public List<PartnerDTO> getAllPartner() {
		List<Partner> partnerEntityList = partnerDAO.findAll();
		System.out.println("getAllPartner() : " + partnerEntityList);

		List<PartnerDTO> partnerDTOList = partnerEntityList.stream().map(entity -> mapper.map(entity, PartnerDTO.class))
				.collect(Collectors.toList());
		logger.info("Partner 전체조회 성공");
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

		logger.info("Partner 전체조회 성공");
		return response;
	}

}
