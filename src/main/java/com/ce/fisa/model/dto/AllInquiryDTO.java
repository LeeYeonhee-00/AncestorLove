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
public class AllInquiryDTO {
	
	private long inquiryId;
	private String userName;
	private String workName;
	private LocalDateTime inquiryDate;
	private String inquiryTitle;
}
