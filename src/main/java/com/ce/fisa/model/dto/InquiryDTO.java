package com.ce.fisa.model.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class InquiryDTO {

	private long inquiry_id;

	private UserDTO user_id;

	private WorkDTO work_id;

	private LocalDateTime inquiry_date;

	private String inquiry_address;

	private String inquiry_content;

	private String inquiry_title;
}