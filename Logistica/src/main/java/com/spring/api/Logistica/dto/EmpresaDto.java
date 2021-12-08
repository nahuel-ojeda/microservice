package com.spring.api.Logistica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

	private Long id;
	private int codigo;
	private String razonSocial;
	private String tipoProducto;
	
}
