package com.spring.api.Logistica.exception;

public class TechnicalExeption extends CustomException {

	private static final long serialVersionUID = 1L;

	public TechnicalExeption(String code, String message, Object source) {
		super(code, message, source);
	}

}
