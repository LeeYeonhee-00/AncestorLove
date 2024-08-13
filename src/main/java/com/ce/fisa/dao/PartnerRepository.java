package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.entity.Partner;
import java.util.List;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long>{
	
	public Partner findByPartnerId(long partnerId);
	
//@Query("select p from Partner p where p.partner_id = :partner_id")
//public Partner findAll(@Param("partner_id") PartnerDTO partnerId);
}
