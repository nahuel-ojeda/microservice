package com.spring.api.Logistica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDto {

	private Long id;
	private int dni;
	private String apellido;
	private String nombre;
	private int edad;
	private String turno;
	
}
