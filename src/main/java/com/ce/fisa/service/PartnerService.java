package com.ce.fisa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ce.fisa.model.dto.PartnerDTO;

@Service
public interface PartnerService {

	public PartnerDTO getPartners(long partnerId);

}
