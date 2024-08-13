package com.ce.fisa.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.dao.PartnerRepository;
import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.entity.Partner;

@Service
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private PartnerRepository partnerDAO;
	
	private ModelMapper mapper = new ModelMapper();
	
	public PartnerDTO getPartners(long partnerId) {
		
		Partner entity = partnerDAO.findByPartnerId(partnerId);
		
		// 예외 처리
		
		PartnerDTO parterdto = mapper.map(entity, PartnerDTO.class);
		return parterdto;
	}

}
