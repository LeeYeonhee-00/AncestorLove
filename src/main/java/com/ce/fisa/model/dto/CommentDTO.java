package com.ce.fisa.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class CommentDTO {
	private long com_id;

	private InquiryDTO inquiry_id; 

	@Column(name = "com_content", length = 800)
	private String com_content;

	@Enumerated(EnumType.STRING)
	@Column(name = "com_consign")
	private Contract com_consign;
	
	// Enum for Gender
    public enum Contract {
        CONSIGN, UNCONSIGN
    }
}