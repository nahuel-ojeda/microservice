package com.springboot.api.Empleados.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min = 2 , message = "EL campo codigo debe tener al menos 2 digitos")
	int dni;
	
	@NotNull
	@NotEmpty
	@Size(min = 2 , message = "EL campo codigo debe tener al menos 2 digitos")
	String apellido;
	
	@NotNull
	@NotEmpty
	@Size(min = 2 , message = "EL campo codigo debe tener al menos 2 digitos")
	String nombre;
	
	@NotNull
	@NotEmpty
	@Size(min = 2 , message = "EL campo codigo debe tener al menos 2 digitos")
	int edad;
	
	@NotNull
	@NotEmpty
	@Size(min = 2 , message = "EL campo codigo debe tener al menos 2 digitos")
	String turno;
	
}
