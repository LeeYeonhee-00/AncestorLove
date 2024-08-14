package com.ce.fisa.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
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
	
	@JsonIgnore
	@ToString.Exclude // toString() 메서드에서 제외
	@OneToMany(mappedBy = "inquiryId", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();
}