package com.springboot.api.Transporte.exception;

public class TechnicalException extends CustomException{
	private static final long serialVersionUID = 759212213938421816L;

	public TechnicalException(String code, String message, Object source) {
		super(code, message, source);
	}

}
