package com.ce.fisa.model.dto;

import java.time.LocalDateTime;

import com.ce.fisa.model.entity.User;
import com.ce.fisa.model.entity.Work;

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
public class UserDTO {

	private long userId;
	private String userName;
	private String userEmail;
	private String userPw;
	private int userAge;
    private Gender userGender; // 이분형 타입으로 정의된 Gender
    // Enum for Gender
    public enum Gender {
        MALE, FEMALE
    }
}