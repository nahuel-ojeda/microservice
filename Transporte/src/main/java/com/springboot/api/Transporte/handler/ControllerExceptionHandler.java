package com.springboot.api.Transporte.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springboot.api.Transporte.dto.ErrorDto;
import com.springboot.api.Transporte.dto.ResponseDto;
import com.springboot.api.Transporte.exception.BusinessException;
import com.springboot.api.Transporte.exception.TechnicalException;
import com.springboot.api.Transporte.util.ErrorDescriptionUtil;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler({BusinessException.class})
	@Nullable
	public ResponseEntity<ResponseDto> handlerBusinessException(final BusinessException exception,
			final WebRequest request){
		
		return new ResponseEntity<>(ErrorDto
				.builder()
				.code(exception.getCode())
				.detail(exception.getMessage())
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({TechnicalException.class})
	@Nullable
	public ResponseEntity<ResponseDto> handlerTechnicalExeption(final TechnicalException exception,
			final WebRequest request){
		
		return new ResponseEntity<>(ErrorDto
				.builder()
				.code(exception.getCode())
				.detail(exception.getMessage())
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler({Exception.class})
	@Nullable
	public ResponseEntity<ResponseDto> handlerException(final Exception exception,
			final WebRequest request){
		
		return new ResponseEntity<>(ErrorDto
				.builder()
				.code(ErrorDescriptionUtil.E_GENERAL_EXCEPTION)
				.detail(ErrorDescriptionUtil.E_GENERAL_EXCEPTION)
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
