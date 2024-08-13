package com.ce.fisa.model.entity;

import com.ce.fisa.model.entity.Comment.Contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Users")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private long userId;

    @Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_pw", length = 100)
	private String userPw;

	@Column(name = "user_age")
	private int userAge;

	@Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender userGender; // 이분형 타입으로 정의된 Gender

    // Enum for Gender
    public enum Gender {
        MALE, FEMALE
    }
}