package com.spring.api.Logistica.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.spring.api.Logistica.dto.ErrorDTO;
import com.spring.api.Logistica.dto.ResponseDTO;
import com.spring.api.Logistica.exception.BusimessException;
import com.spring.api.Logistica.exception.TechnicalExeption;
import com.spring.api.Logistica.util.ErrorDescriptionUtil;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler({BusimessException.class})
	@Nullable
	public ResponseEntity<ResponseDTO> handlerBusinessException(final BusimessException exception,
			final WebRequest request){
		
		return new ResponseEntity<>(ErrorDTO
				.builder()
				.code(exception.getCode())
				.detail(exception.getMessage())
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({TechnicalExeption.class})
	@Nullable
	public ResponseEntity<ResponseDTO> handlerTechnicalExeption(final TechnicalExeption exception,
			final WebRequest request){
		
		return new ResponseEntity<>(ErrorDTO
				.builder()
				.code(exception.getCode())
				.detail(exception.getMessage())
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler({Exception.class})
	@Nullable
	public ResponseEntity<ResponseDTO> handlerException(final Exception exception,
			final WebRequest request){
		
		return new ResponseEntity<>(ErrorDTO
				.builder()
				.code(ErrorDescriptionUtil.E_GENERAL_EXCEPTION)
				.detail(ErrorDescriptionUtil.E_GENERAL_EXCEPTION)
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
   
}
