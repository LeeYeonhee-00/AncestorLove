package com.ce.fisa.model.entity;

import com.ce.fisa.model.entity.Comment.Contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Work")
@Entity
public class Work {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "work_id")
	private long work_id;

	@Column(name = "work_name")
	private String work_name;
}