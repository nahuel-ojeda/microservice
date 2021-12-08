package com.springboot.api.Empleados.exception;

public class BusinessException extends CustomException {

	private static final long serialVersionUID = -3079195472560312187L;

	public BusinessException(String code, String message, Object source) {
		super(code, message, source);
	}
}
