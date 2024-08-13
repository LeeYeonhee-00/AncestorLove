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
	private long inquiry_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user_id;

	@ManyToOne
	@JoinColumn(name = "work_id")
	private Work work_id;

	@Column(name = "inquiry_date")
	private LocalDateTime inquiry_date;

	@Column(name = "inquiry_address")
	private String inquiry_address;

	@Column(name = "inquiry_content")
	private String inquiry_content;

	@Column(name = "inquiry_title")
	private String inquiry_title;
}