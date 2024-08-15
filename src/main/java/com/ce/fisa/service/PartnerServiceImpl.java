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
import com.ce.fisa.model.dto.CommentDTO;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.dto.PartnerAndReviewDTO;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.dto.ReviewDTO;
import com.ce.fisa.model.entity.Comment;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.model.entity.Partner;
import com.ce.fisa.model.entity.Review;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerDAO;

	private ModelMapper mapper = new ModelMapper();

	private static final Logger logger = LogManager.getLogger(PartnerServiceImpl.class);
	
	private PartnerDTO convertPartnerToDTO(Partner partner) {
	    return PartnerDTO.builder()
	            .partnerId(partner.getPartnerId())  // Partner 엔티티에서 partnerId 가져오기
	            .partnerName(partner.getPartnerName())  // Partner 이름 가져오기
	            .partnerLocation(partner.getPartnerLocation())  // Partner 위치 가져오기
	            .metricPrice(partner.getMetricPrice())  // Metric 가격 가져오기
	            .partnerInfo(partner.getPartnerInfo())  // Partner 정보 가져오기
	            .reviews(partner.getReviews().stream()  // 리뷰 목록을 ReviewDTO로 변환하여 설정
	                    .map(this::convertReviewToDTO)
	                    .collect(Collectors.toList()))
	            .build();
	}
	
	private ReviewDTO convertReviewToDTO(Review review) {
	    return ReviewDTO.builder()
	            .reId(review.getReId())  // Review 엔티티에서 reId 가져오기
	            .partnerId(review.getPartnerId().getPartnerId())  // Partner 엔티티에서 partnerId 가져오기 (가정)
	            .reuserId(review.getReuserId())  // User 엔티티에서 reuserId 가져오기 (가정)
	            .reContent(review.getReContent())  // Review 내용 가져오기
	            .reDate(review.getReDate())  // Review 작성 날짜 가져오기
	            .reRating(review.getReRating())  // Review 평점 가져오기
	            .build();
	}


	@Override
	public PartnerDTO getPartners(long partnerId) throws NotExistPartnerException {

		Partner partnerEntity = partnerDAO.findByPartnerId(partnerId);

		if (partnerEntity == null) {
			logger.warn("파트너 상세조회 실패");
			throw new NotExistPartnerException("해당 파트너는 존재하지 않습니다.");
		}

//		PartnerDTO parterdto = mapper.map(partnerEntity, PartnerDTO.class);
		PartnerDTO parterdto = convertPartnerToDTO(partnerEntity);
		logger.info("파트너 상세조회 성공");
		return parterdto;
	}

	@Override
	public List<PartnerDTO> getAllPartner() {
		List<Partner> partnerEntityList = partnerDAO.findAll();
		System.out.println("getAllPartner() : " + partnerEntityList);

		List<PartnerDTO> partnerDTOList = partnerEntityList.stream().map(entity -> mapper.map(entity, PartnerDTO.class))
				.collect(Collectors.toList());
		logger.info("파트너 전체조회 성공");
		return partnerDTOList;

	}

	public List<Map<String, Object>> getAverageRatings() {
	    List<Object[]> results = partnerDAO.findAverageRatingsForPartners();
	    List<Map<String, Object>> response = new ArrayList<>();

	    for (Object[] result : results) {
	        Map<String, Object> map = new HashMap<>();
	        map.put("partnerId", result[0]);
	        map.put("partnerName", result[1]);
	        map.put("partnerLocation", result[2]);
	        map.put("averageRating", result[3] != null ? result[3] : 0); // Handle NULL values
	        response.add(map);
	    }

	    logger.info("Partner 전체조회 성공");
	    return response;
	}

}
