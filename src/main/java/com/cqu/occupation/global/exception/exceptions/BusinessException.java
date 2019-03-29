package com.cqu.occupation.global.exception.exceptions;

import com.cqu.occupation.global.exception.exceptions.code.ExceptionCode;

/**
 * @author sukaiyi
 */
public class BusinessException extends RuntimeException{
	private int code = ExceptionCode.OTHER;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(int code, String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
