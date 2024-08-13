package com.ce.fisa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Comments")
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "com_id")
	private long comId;

	@ManyToOne
	@JoinColumn(name = "inquiry_id")
	private Inquiry inquiryId; 

	@Column(name = "com_content", length = 800)
	private String comContent;

	@Enumerated(EnumType.STRING)
	@Column(name = "com_consign")
	private Contract comConsign;
	
	// Enum for Gender
    public enum Contract {
        CONSIGN, UNCONSIGN
    }
}