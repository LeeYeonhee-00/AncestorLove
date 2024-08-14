package com.ce.fisa.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ce.fisa.model.entity.Comment;

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
@ToString
@Builder
public class InquiryDTO {
	
	private long inquiryId;
	private long userId;
	private long workId;
	private LocalDateTime inquiryDate;
	private String inquiryAddress;
	private String inquiryContent;
	private String inquiryTitle;
	private List<CommentDTO> comments = new ArrayList<>();
	
}