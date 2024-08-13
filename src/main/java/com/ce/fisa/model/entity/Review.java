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
@Table(name = "Review")
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "re_id")
	private long re_id;

	@ManyToOne
	@JoinColumn(name = "partner_id")
	private Partner partner_id;

	// For Refactoring
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private Users user_id; 
	
	@Column(name = "reuser_id")
	private long reuser_id;

	@Column(name = "re_content", length = 800)
	private String re_content;

	@Column(name = "re_date")
	private LocalDateTime re_date;

	@Column(name = "re_rating")
	private int re_rating;
}