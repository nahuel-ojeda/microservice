package com.spring.api.Logistica.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class CustomException extends Exception {

	private static final long serialVersionUID = 4703401319539038378L;
	
	protected final String code;
	protected final String message;
	protected final transient Object source;

}
