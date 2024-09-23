package com.ce.fisa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.entity.Partner;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long>{
	
	public List<Partner> findAll();
	
	public Partner findByPartnerId(long partnerId);
	
	Partner findByPartnerName(String partnerName);
	
	Partner findByPartnerEmail(String partnerEmail);

	// 모든 파트너의 정보를 리뷰 평균과 함께 보기 위한 sql
	@Query(value = "SELECT p.partner_id, p.partner_name, p.partner_location, COALESCE(AVG(r.re_rating), 0) AS average_rating " +
	        "FROM Partner p " +
	        "LEFT JOIN Review r ON r.partner_id = p.partner_id " +
	        "GROUP BY p.partner_id, p.partner_name, p.partner_location",
	        nativeQuery = true)
	List<Object[]> findAverageRatingsForPartners();
	
}
