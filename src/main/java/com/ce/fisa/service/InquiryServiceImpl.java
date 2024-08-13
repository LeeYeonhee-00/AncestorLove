package com.ce.fisa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce.fisa.dao.InquiryRepository;
import com.ce.fisa.exception.NotExistEmp2Exception;
import com.ce.fisa.exception.NotExistInquiryException;
import com.ce.fisa.model.dto.Emp2DTO;
import com.ce.fisa.model.dto.InquiryDTO;
import com.ce.fisa.model.entity.Inquiry;

@Service
public class InquiryServiceImpl implements InquiryService {
	
	@Autowired
	private InquiryRepository inquiryDAO;
	
	// DTO <-> Entity
	private ModelMapper mapper = new ModelMapper();

	@Override
	public List<InquiryDTO> getAllInquiry() {

		List<Inquiry> inquiryEntityList = inquiryDAO.findAll();
		System.out.println("getAllInquiry() : " + inquiryEntityList);
		
		List<InquiryDTO> inquiryDTOList = inquiryEntityList.stream()
	            .map(entity -> mapper.map(entity, InquiryDTO.class))
	            .collect(Collectors.toList());
		return inquiryDTOList;
	}

	@Override
	public InquiryDTO getInquiry(long inquiry_id) throws NotExistInquiryException {

		Inquiry inquiryEntity = inquiryDAO.findByInquiry_id(inquiry_id);
		System.out.println("getAllInquiry() : " + inquiryEntity);
		
		if (inquiryEntity == null) {
			throw new NotExistInquiryException("No exists inquiry ");
		}
		
		InquiryDTO inquiryDTO = mapper.map(inquiryEntity, InquiryDTO.class);
		System.out.println(inquiryDTO);
		return inquiryDTO;
	}

}
