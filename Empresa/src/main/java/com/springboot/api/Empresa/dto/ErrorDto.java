package com.springboot.api.Empresa.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ErrorDto extends ResponseDto implements Serializable{
	private static final long serialVersionUID = 2844614741466838311L;
	
	private String code;
	private String detail;

}
