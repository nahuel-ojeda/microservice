package com.springboot.api.Transporte.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class CustomException extends Exception{
	private static final long serialVersionUID = 3100419445792425303L;
	
	protected final String code;
	protected final String message;
	protected final transient Object source;

}
