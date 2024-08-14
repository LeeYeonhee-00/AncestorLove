/*
 * 사용자 정의 예외 클래스
 * 1. 필요성 - 클래스명으로 상황 판단용
 * 2. 구조
 * - 상위클래스 / 생성자
 */

package com.ce.fisa.exception;

public class NotExistUserException extends Exception {
	
	public NotExistUserException() {}
	
	public NotExistUserException(String message) {
		super(message);
	}

}
