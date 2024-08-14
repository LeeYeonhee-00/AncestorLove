package com.ce.fisa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "Work")
@Entity
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "work_id")
	private long workId;

	@Column(name = "work_name")
	private String workName;
}