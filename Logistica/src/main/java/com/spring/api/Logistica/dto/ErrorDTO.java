package com.spring.api.Logistica.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorDTO extends ResponseDTO implements Serializable{
	private static final long serialVersionUID = -1186426322269071733L;
	
	private String code;
	private String detail;

}
