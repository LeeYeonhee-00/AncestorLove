package com.ce.fisa.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.ce.fisa.model.entity.Review;

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
public class PartnerDTO {
	private long partnerId; 
	private String partnerName;
	private String partnerLocation;
	private int metricPrice;
	private String partnerInfo;
	private List<Review> reviews = new ArrayList<>();
}