package com.ce.fisa.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InquiryDTO {
	
	private long inquiry_id;
	private UserDTO user_id;
	private WorkDTO work_id;
	private LocalDateTime inquiry_date;
	private String inquiry_address;
	private String inquiry_content;
	private String inquiry_title;
}