package com.ce.fisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ce.fisa.model.dto.PartnerDTO;
import com.ce.fisa.model.entity.Inquiry;
import com.ce.fisa.model.entity.Partner;
import java.util.List;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long>{
	
//    @Query("SELECT p.partnerName, p.partnerLocation, AVG(r.reRating) FROM Partner p LEFT JOIN Review r ON p.partnerId = r.partnerId GROUP BY p.partnerName, p.partnerLocation")
//		List<Object[]> findPartnerWithAverageRating();
//	
	

	public List<Partner> findAll();
	
	public Partner findByPartnerId(long partnerId);

	// 모든 파트너의 정보를 리뷰 평균과 함께 보기 위한 sql
	@Query(value = "SELECT p.partner_id, p.partner_name, p.partner_location, AVG(r.re_rating) AS average_rating " +
			"FROM Review r " +
			"JOIN Partner p ON r.partner_id = p.partner_id " +
			"GROUP BY p.partner_id, p.partner_name, p.partner_location",
			nativeQuery = true)
	List<Object[]> findAverageRatingsForPartners();

	
//@Query("select p from Partner p where p.partner_id = :partner_id")
//public Partner findAll(@Param("partner_id") PartnerDTO partnerId);
}
