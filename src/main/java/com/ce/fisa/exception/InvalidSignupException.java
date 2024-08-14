/*
 * 사용자 정의 예외 클래스
 * 1. 필요성 - 클래스명으로 상황 판단용
 * 2. 구조
 * - 상위클래스 / 생성자
 */

package com.ce.fisa.exception;

public class InvalidSignupException extends Exception {
	
	public InvalidSignupException() {}
	
	public InvalidSignupException(String message) {
		super(message);
	}

}
