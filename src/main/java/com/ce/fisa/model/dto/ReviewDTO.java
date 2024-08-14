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
public class ReviewDTO {
	
	private long reId;
	private long partnerId;
	private long reuserId;
	private String reContent;
	private LocalDateTime reDate;
	private int reRating;
}