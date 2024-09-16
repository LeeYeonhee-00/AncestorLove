/*
 * 사용자 정의 예외 클래스
 * 1. 필요성 - 클래스명으로 상황 판단용
 * 2. 구조
 * - 상위클래스 / 생성자
 */

package com.ce.fisa.exception;

import lombok.Getter;

@Getter
public class NotExistUserException extends RuntimeException {
	
	private ErrorCode errorCode;
		
	public NotExistUserException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
