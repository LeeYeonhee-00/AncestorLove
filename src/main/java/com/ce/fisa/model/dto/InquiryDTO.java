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
	
	private long inquiryId;
	private UserDTO userId;
	private WorkDTO workId;
	private LocalDateTime inquiryDate;
	private String inquiryAddress;
	private String inquiryContent;
	private String inquiryTitle;
}