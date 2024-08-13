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
@Table(name = "Partner")
@Entity
public class Partner {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "partner_id")
	private long partner_id; 

	@Column(name = "partner_name")
	private String partner_name;

	@Column(name = "partner_location")
	private String partner_location;

	@Column(name = "metric_price")
	private int metric_price;

	@Column(name = "partner_info", length = 800)
	private String partner_info;
}