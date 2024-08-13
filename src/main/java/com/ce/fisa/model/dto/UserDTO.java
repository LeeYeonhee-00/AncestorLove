package com.ce.fisa.model.dto;


public class UserDTO {

	private long user_id;

	private String user_name;

	private String user_email;

	private String user_pw;

	private int user_age;

    private Gender user_gender; // 이분형 타입으로 정의된 Gender

    // Enum for Gender
    public enum Gender {
        MALE, FEMALE
    }
}