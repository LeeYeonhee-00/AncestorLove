package com.ce.fisa.model.entity;

import java.time.LocalDateTime;

import com.ce.fisa.model.entity.Comment.Contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "Inquiry")
@Entity
public class Inquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "inquiry_id")
	private long inquiryId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@ManyToOne
	@JoinColumn(name = "work_id")
	private Work workId;

	@Column(name = "inquiry_date")
	private LocalDateTime inquiryDate;

	@Column(name = "inquiry_address")
	private String inquiryAddress;

	@Column(name = "inquiry_content")
	private String inquiryContent;

	@Column(name = "inquiry_title")
	private String inquiryTitle;
}