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
public class CommentDTO {
	private long comId;
	private long inquiryId; 
	private String comContent;
	private Contract comConsign;
    public enum Contract {
        CONSIGN, UNCONSIGN
    }
}