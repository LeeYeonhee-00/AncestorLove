package com.ce.fisa.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "Review")
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq_gen")
	@SequenceGenerator(name = "review_seq_gen", sequenceName = "review_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "re_id")
	private long reId;

	@ManyToOne
	@JoinColumn(name = "partner_id", nullable = false)
	private Partner partnerId;

	// For Refactoring
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private Users user_id; 
	
	@Column(name = "reuser_id")
	private long reuserId;

	@Column(name = "re_content", length = 800)
	private String reContent;

	@Column(name = "re_date")
	private LocalDateTime reDate;

	@Column(name = "re_rating")
	private int reRating;
}