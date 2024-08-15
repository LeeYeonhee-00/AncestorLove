package com.ce.fisa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Users")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "user_id")
	private long userId;

    @Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "user_email", nullable = false)
	@NonNull
	private String userEmail;

	@Column(name = "user_pw", length = 100, nullable = false)
	@NonNull
	private String userPw;

	@Column(name = "user_age")
	private int userAge;

	@Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender userGender; // 이분형 타입으로 정의된 Gender
}