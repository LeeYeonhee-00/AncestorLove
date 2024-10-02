package com.ce.fisa.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.ce.fisa.model.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PartnerDTO {
	private long partnerId; 
	private String partnerName;
	private String partnerEmail;
	private String partnerPw;
	private String partnerLocation;
	private int metricPrice;
	private String partnerInfo;
	private List<ReviewDTO> reviews = new ArrayList<>();
}