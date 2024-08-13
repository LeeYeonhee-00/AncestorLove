package com.ce.fisa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ce.fisa.model.entity.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
	
//	public List<Inquiry> findList();
	public List<Inquiry> findAll();
	
	public Inquiry findByInquiryId(long inquiryId);
//	public Optional<Inquiry> findById(Long inquiry_id);

}
