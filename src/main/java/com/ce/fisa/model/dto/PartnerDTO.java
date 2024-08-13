package com.ce.fisa.model.dto;

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
}