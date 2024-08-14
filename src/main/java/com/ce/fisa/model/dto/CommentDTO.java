package com.ce.fisa.model.dto;

import com.ce.fisa.model.entity.Contract;

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
public class CommentDTO {
	private long comId;
	private long inquiryId; 
	private String comContent;
	private Contract comConsign;   
}