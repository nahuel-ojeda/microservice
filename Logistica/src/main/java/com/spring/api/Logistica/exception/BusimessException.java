package com.spring.api.Logistica.exception;

public class BusimessException extends CustomException{
	private static final long serialVersionUID = 1L;

	public BusimessException(String code, String message, Object source) {
		super(code, message, source);
	}
}
